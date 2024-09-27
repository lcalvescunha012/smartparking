package com.smartparking.service;

import com.smartparking.dto.VeiculoDTO;
import com.smartparking.entities.VeiculoEntity;
import com.smartparking.exceptions.NotFoundException;
import com.smartparking.mappers.VeiculoMapper;
import com.smartparking.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final VeiculoMapper veiculoMapper;

    public VeiculoDTO findById(String placa) {
        return veiculoMapper.toDto(veiculoRepository.findById(placa)
                .orElseThrow(() -> new NotFoundException("Não foi possível encontrar o veiculo com a placa: " + placa + ".")));
    }

    public VeiculoDTO update(String placa, VeiculoDTO veiculo) {

        VeiculoEntity veiculoAtualiza;

        veiculoAtualiza = veiculoMapper.toEntity(findById(placa));

        veiculoAtualiza.setMarca(veiculo.marca());
        veiculoAtualiza.setModelo(veiculo.modelo());
        veiculoAtualiza.setPlaca(veiculo.placa());
        veiculoAtualiza.setCor(veiculo.cor());

        return veiculoMapper.toDto(veiculoRepository.save(veiculoAtualiza));
    }

    public VeiculoDTO save(VeiculoDTO veiculoDTO) {
        return veiculoMapper.toDto(veiculoRepository.save(veiculoMapper.toEntity(veiculoDTO)));
    }

    public void delete(String placa) {
        veiculoRepository.deleteById(placa);
    }
}
