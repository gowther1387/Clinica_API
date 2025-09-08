package com.frederycklohan.ufpb.demo_api.services;

import com.frederycklohan.ufpb.demo_api.DTO.ConsultaDTO;
import com.frederycklohan.ufpb.demo_api.config.ConsultaMapper;
import com.frederycklohan.ufpb.demo_api.config.MedicoMapper;
import com.frederycklohan.ufpb.demo_api.config.PacienteMapper;
import com.frederycklohan.ufpb.demo_api.models.Consulta;
import com.frederycklohan.ufpb.demo_api.repositories.ConsultaRepository;
import com.frederycklohan.ufpb.demo_api.repositories.MedicoRepository;
import com.frederycklohan.ufpb.demo_api.repositories.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ConsultaService{

    private final ConsultaRepository consultaRepository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;
    private final PacienteCadastro pacienteCadastro;
    private final PacienteMapper pacienteMapper;
    private final ConsultaMapper consultaMapper;
    private final MedicoMapper medicoMapper;

    public ConsultaService(ConsultaRepository consultaRepository,
                           MedicoRepository medicoRepository,
                           PacienteRepository pacienteRepository,
                           PacienteCadastro pacienteCadastro,
                           PacienteMapper pacienteMapper,
                           ConsultaMapper consultaMapper,
                           MedicoMapper medicoMapper) {
        this.consultaRepository = consultaRepository;
        this.medicoRepository = medicoRepository;
        this.pacienteRepository = pacienteRepository;
        this.pacienteCadastro = pacienteCadastro;
        this.pacienteMapper = pacienteMapper;
        this.consultaMapper = consultaMapper;
        this.medicoMapper = medicoMapper;

    }

    public ConsultaDTO cadastrarConsulta(ConsultaDTO consultaDTO) {
         Consulta consulta = consultaMapper.toEntity(consultaDTO);
         consulta = consultaRepository.save(consulta);
         return consultaMapper.toDTO(consulta);
    }

    public Consulta procurarConsultaPorId(UUID idChave){
        return consultaRepository.getReferenceByIdChave(idChave);
    }

/*    public Set<PacienteDTO> procurarPacientesDoMedico(UUID idMedico) {


      Set<PacienteDTO> pacientesDoMedico = new HashSet<>();
      return pacientesDoMedico.stream()
              .map()
              .collect(Collectors.toSet());

    }*/

    public List<ConsultaDTO> todasConsultas() {
            List<Consulta> consultas = consultaRepository.findAll();
            return consultas.stream()
                    .map(this::convertConsultaToDto)
                    .collect(Collectors.toList());
    }



    public Consulta atualizarConsulta(Consulta c){
        Optional<Consulta> optionalConsulta = consultaRepository.findById(c.getIdChave());

        if(optionalConsulta.isPresent()){
            Consulta toUpdate = optionalConsulta.get();
            toUpdate.setDataHora(c.getDataHora());
            toUpdate.setMedico(c.getMedico() );
            toUpdate.setPacientes(c.getPacientes());
            toUpdate.setStatusConsulta(c.getStatusConsulta());
            consultaRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }

    public void deletarConsulta(UUID idChave){
        consultaRepository.findById(idChave).ifPresent(c -> consultaRepository.deleteById(c.getIdChave()));
    }
}