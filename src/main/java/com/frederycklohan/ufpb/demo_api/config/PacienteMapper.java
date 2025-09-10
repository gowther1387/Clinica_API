package com.frederycklohan.ufpb.demo_api.config;

import com.frederycklohan.ufpb.demo_api.DTO.ConsultaDTO;
import com.frederycklohan.ufpb.demo_api.DTO.PacienteDTO;
import com.frederycklohan.ufpb.demo_api.models.Consulta;
import com.frederycklohan.ufpb.demo_api.models.Paciente;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class PacienteMapper {

    private final ModelMapper modelMapper;

    public PacienteMapper() {
        this.modelMapper = new ModelMapper();
    }


    public PacienteMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PacienteDTO toDTO(Paciente paciente) {
        return modelMapper.map(paciente, PacienteDTO.class);
    }

    public Paciente toEntity(PacienteDTO pacienteDTO) {
        return modelMapper.map(pacienteDTO, Paciente.class);
    }

}
