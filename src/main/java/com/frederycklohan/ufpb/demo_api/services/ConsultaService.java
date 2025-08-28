package com.frederycklohan.ufpb.demo_api.services;

import com.frederycklohan.ufpb.demo_api.models.Consulta;
import com.frederycklohan.ufpb.demo_api.models.Paciente;
import com.frederycklohan.ufpb.demo_api.repositories.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConsultaService{

    private final ConsultaRepository consultaRepository;

    ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public Consulta cadastrarConsulta(Consulta c) {
        return consultaRepository.save(c);
    }

    public Consulta procurarConsultaPorId(UUID idChave){
        return consultaRepository.getReferenceByIdChave(idChave);
    }

    public List<Paciente> procurarPacientesDoMedico(UUID idMedico) {
            return consultaRepository.findPacientesByMedico(idMedico);
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