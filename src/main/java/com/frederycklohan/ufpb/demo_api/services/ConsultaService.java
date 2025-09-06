package com.frederycklohan.ufpb.demo_api.services;

import com.frederycklohan.ufpb.demo_api.DTO.ConsultaDTO;
import com.frederycklohan.ufpb.demo_api.DTO.MedicoDTO;
import com.frederycklohan.ufpb.demo_api.DTO.PacienteDTO;
import com.frederycklohan.ufpb.demo_api.config.ConsultaMapper;
import com.frederycklohan.ufpb.demo_api.config.MedicoMapper;
import com.frederycklohan.ufpb.demo_api.config.PacienteMapper;
import com.frederycklohan.ufpb.demo_api.models.Consulta;
import com.frederycklohan.ufpb.demo_api.models.Medico;
import com.frederycklohan.ufpb.demo_api.models.Paciente;
import com.frederycklohan.ufpb.demo_api.repositories.ConsultaRepository;
import com.frederycklohan.ufpb.demo_api.repositories.MedicoRepository;
import com.frederycklohan.ufpb.demo_api.repositories.PacienteRepository;
import org.springframework.data.repository.query.Param;
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

    public Consulta cadastrarConsulta(Consulta c) {

        //Transforma o objeto em uma entidade legivel pelo JSON
        Medico medicoExistente = medicoRepository.findById(c.getMedico().getIdMedico())
                .orElseThrow(() -> new IllegalArgumentException("Médico não encontrado com o ID fornecido."));


        //Transforma o objeto em uma entidade legivel pelo JSON e garante que ira fazer o cadastro mesmo se não tiver pacientes ja cadastrados
        Set<Paciente> pacientesExistentes = new HashSet<>();
        if (c.getPacientes() != null) {
            pacientesExistentes = c.getPacientes().stream()
                    .map(p -> pacienteRepository.findById(p.getIdPaciente())
                            .orElseThrow(() -> new IllegalArgumentException("Um ou mais pacientes não foram encontrados.")))
                    .collect(Collectors.toSet());
        }

        //Assossia as entidades a consulta
        c.setMedico(medicoExistente);
        c.setPacientes(pacientesExistentes);

        //Salva a consulta
        return consultaRepository.save(c);
    }

    public Consulta procurarConsultaPorId(UUID idChave){
        return consultaRepository.getReferenceByIdChave(idChave);
    }

    public Set<PacienteDTO> procurarPacientesDoMedico(UUID idMedico) {

      Set<Consulta> pacientesDoMedico = new HashSet<>();
      return pacientesDoMedico.stream()
              .flatMap(consulta -> consulta.getPacientes().stream())
              .map(this.pacienteMapper::toDTO)
              .collect(Collectors.toSet());

    }

    public List<ConsultaDTO> todasConsultas() {
            List<Consulta> consultas = consultaRepository.findAll();
            return consultas.stream()
                    .map(this::convertConsultaToDto)
                    .collect(Collectors.toList());
    }

    public ConsultaDTO convertConsultaToDto(Consulta consulta) {
        if (consulta == null) {
            return null;
        }

        ConsultaDTO consultaDTO = new ConsultaDTO();
        consultaDTO.setDataHora(consulta.getDataHora());

        if (consulta.getMedico() != null) {
            consultaDTO.setMedico(consulta.getMedico().getIdMedico());
        }


        if (consulta.getPacientes() != null) {
            consultaDTO.setPacientes(consulta.getPacientes().stream()
                    .map(Paciente::getIdPaciente)
                    .collect(Collectors.toSet()));
        }

        consultaDTO.setStatusConsulta(consulta.getStatusConsulta());

        return consultaDTO;
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