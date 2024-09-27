package com.smartparking.service;

import com.smartparking.dto.VeiculoDTO;
import com.smartparking.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {

    public final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
        System.out.println("This is service -> " + this);
    }

    public VeiculoDTO findById(String placa) {
        return null;
    }

    public VeiculoDTO update(String placa, VeiculoDTO veiculo) {
        return null;
    }

    public VeiculoDTO save(VeiculoDTO veiculoDTO) {
        return null;
    }

    public void delete(String placa) {
    }
}
