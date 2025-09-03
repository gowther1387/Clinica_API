package com.frederycklohan.ufpb.demo_api.services;

import com.frederycklohan.ufpb.demo_api.DTO.ConsultaDTO;
import com.frederycklohan.ufpb.demo_api.DTO.MedicoDTO;
import com.frederycklohan.ufpb.demo_api.DTO.PacienteDTO;
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

    public ConsultaService(ConsultaRepository consultaRepository, MedicoRepository medicoRepository, PacienteRepository pacienteRepository) {
        this.consultaRepository = consultaRepository;
        this.medicoRepository = medicoRepository;
        this.pacienteRepository = pacienteRepository;
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

    public Set<Paciente> procurarPacientesDoMedico(UUID idMedico) {

        return consultaRepository.findPacienteByIdMedico(idMedico);

/*        Set<Paciente> pacientesDoMedico = new HashSet<>();
            if(c.getMedico().getIdMedico() != null) {
                pacientesDoMedico = c.getPacientes()
                        .stream()
                        .map(p -> consultaRepository.findPacienteByIdMedico(c.getMedico().getIdMedico()))
                        .collect(Collectors.toSet());
            }
            return pacientesDoMedico;*/
    }

    public List<ConsultaDTO> todasConsultas() {
            List<Consulta> consultas = consultaRepository.findAll();
            return consultas.stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
    }

    public ConsultaDTO convertToDto(Consulta consulta) {
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