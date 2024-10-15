package com.smartparking.service;

import com.smartparking.dto.PagamentoDTO;
import com.smartparking.dto.RegistroDTO;
import com.smartparking.exceptions.NotFoundException;
import com.smartparking.mappers.PagamentosMapper;
import com.smartparking.repository.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Duration;

@Service
@RequiredArgsConstructor
public class PagamentosService {

    private final PagamentosMapper mapper;
    private final PagamentoRepository repository;
    private final ParquimetroService parquimetroService;
    private final VeiculoService veiculoService;

    @Transactional(readOnly = true)
    public PagamentoDTO findById(String id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new NotFoundException("error " + id + ".")));
    }

    @Transactional(readOnly = true)
    public PagedModel<PagamentoDTO> getAllByPagination(int page, int size) {
        val pageRequest = PageRequest.of(page, size);
        val pageEntity = repository.findAll(pageRequest);
        return new PagedModel<>(pageEntity.map(mapper::toDto));
    }

    @Transactional
    public BigDecimal efetuarPagamento(RegistroDTO dto) {
        val totalHours = Duration.between(dto.dataHoraInicio(), dto.dataHoraFim()).toHours();
        BigDecimal totalCost;

        if (totalHours <= 2) {
            totalCost = BigDecimal.valueOf(5); // Fixed cost for the first 2 hours
        } else {
            // 5 Reais for the first 2 hours, plus 2 Reais for each additional hour
            totalCost = BigDecimal.valueOf(5).add(BigDecimal.valueOf((totalHours - 2) * 2));
        }

        val pagamentoDto = new PagamentoDTO (
            totalCost,
            dto.dataHoraFim(),
            veiculoService.findById(dto.veiculoId()),
            parquimetroService.findById(dto.parquimetroId())
        );

        repository.save(mapper.toEntity(pagamentoDto));

        return totalCost;
    }
}
