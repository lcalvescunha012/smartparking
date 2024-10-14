package com.smartparking.service;

import com.smartparking.dto.VeiculoDTO;
import com.smartparking.exceptions.NotFoundException;
import com.smartparking.mappers.VeiculoMapper;
import com.smartparking.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final VeiculoMapper veiculoMapper;

    @Transactional(readOnly = true)
    public VeiculoDTO findById(String placa) {
        return veiculoMapper.toDto(veiculoRepository.findById(placa)
                .orElseThrow(() -> new NotFoundException("Não foi possível encontrar o veiculo com a placa: " + placa + ".")));
    }

    @Transactional(readOnly = true)
    public VeiculoDTO update(String placa, VeiculoDTO veiculo) {
        val veiculoAtualiza = veiculoMapper.toEntity(findById(placa));
        veiculoAtualiza.setMarca(veiculo.marca());
        veiculoAtualiza.setModelo(veiculo.modelo());
        veiculoAtualiza.setPlaca(veiculo.placa());
        veiculoAtualiza.setCor(veiculo.cor());
        return veiculoMapper.toDto(veiculoRepository.save(veiculoAtualiza));
    }

    @Transactional
    public VeiculoDTO save(VeiculoDTO veiculoDTO) {
        return veiculoMapper.toDto(veiculoRepository.save(veiculoMapper.toEntity(veiculoDTO)));
    }

    @Transactional
    public void delete(String placa) {
        veiculoRepository.deleteById(placa);
    }
}
