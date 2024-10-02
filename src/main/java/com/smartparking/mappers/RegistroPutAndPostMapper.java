package com.smartparking.mappers;

import com.smartparking.dto.RegistroPutAndPostDTO;
import com.smartparking.entities.RegistroEntity;
import org.springframework.stereotype.Component;

@Component
public class RegistroPutAndPostMapper {


    public RegistroEntity toEntity(RegistroPutAndPostDTO registroPutAndPostDTO) {
        return new RegistroEntity(
                registroPutAndPostDTO.veiculoId(),
                registroPutAndPostDTO.parquimetroId(),
                registroPutAndPostDTO.dataHoraInicio(),
                registroPutAndPostDTO.dataHoraFim(),
                registroPutAndPostDTO.valorPago()
        );
    }
}
