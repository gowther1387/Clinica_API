package com.frederycklohan.ufpb.demo_api.config;

import com.frederycklohan.ufpb.demo_api.DTO.ConsultaDTO;
import com.frederycklohan.ufpb.demo_api.models.Consulta;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class ConsultaMapper {

    private final ModelMapper modelMapper;

    public ConsultaMapper() {
        this.modelMapper = new ModelMapper();
    }

    public ConsultaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ConsultaDTO toDTO(Consulta consulta){
        return modelMapper.map(consulta, ConsultaDTO.class);
    }

    public Consulta toEntity(ConsultaDTO consultaDTO){
        return modelMapper.map(consultaDTO, Consulta.class);
    }

}
