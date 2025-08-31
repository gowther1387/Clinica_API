package com.frederycklohan.ufpb.demo_api.services;

import com.frederycklohan.ufpb.demo_api.models.Consulta;
import com.frederycklohan.ufpb.demo_api.models.Medico;
import com.frederycklohan.ufpb.demo_api.models.Paciente;
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

    public ConsultaService(ConsultaRepository consultaRepository,  MedicoRepository medicoRepository, PacienteRepository pacienteRepository) {
        this.consultaRepository = consultaRepository;
        this.medicoRepository = medicoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public Consulta cadastrarConsulta(Consulta c) {

        //Transforma o objeto em uma entidade legivel pelo JSON
        Medico medicoExistente = medicoRepository.findById(c.getMedico().getIdMedico())
                .orElseThrow(() -> new IllegalArgumentException("Médico não encontrado com o ID fornecido."));

        //Transforma o objeto em uma entidade legivel pelo JSON
        Set<Paciente> pacientesExistentes = c.getPacientes().stream()
                .map(p -> pacienteRepository.findById(p.getIdPaciente())
                        .orElseThrow(() -> new IllegalArgumentException("Um ou mais pacientes não foram encontrados.")))
                .collect(Collectors.toSet());

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
    }

    public List<Consulta> todasConsultas() {
        return consultaRepository.findAll();
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