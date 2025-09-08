package com.frederycklohan.ufpb.demo_api.config;

import com.frederycklohan.ufpb.demo_api.DTO.MedicoDTO;
import com.frederycklohan.ufpb.demo_api.DTO.PacienteDTO;
import com.frederycklohan.ufpb.demo_api.models.Medico;
import com.frederycklohan.ufpb.demo_api.models.Paciente;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MedicoMapper {

    private final ModelMapper modelMapper;

    public MedicoMapper() {
        this.modelMapper = new ModelMapper();
    }


    public MedicoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public MedicoDTO toDTO(Medico medico) {
        return modelMapper.map(medico, MedicoDTO.class);
    }

    public Medico toEntity(MedicoDTO medicoDTO) {
        return modelMapper.map(medicoDTO, Medico.class);
    }

}