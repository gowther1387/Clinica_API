package com.frederycklohan.ufpb.demo_api.services;

import com.frederycklohan.ufpb.demo_api.repositories.PacienteRepository;
import com.frederycklohan.ufpb.demo_api.models.Paciente;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PacienteCadastro {

    private PacienteRepository pacienteRepository;

    private PacienteCadastro(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente cadastrarPaciente(Paciente p)   {
        return pacienteRepository.save(p);
    }

    public Paciente procurarPacientePorRg(String rg){
        return pacienteRepository.getReferenceByRg(rg);
    }

    public Paciente procurarPacientePorCpf(String cpf) {
        return pacienteRepository.getReferenceByCpf(cpf);
    }

    
    public Paciente atualizarPaciente(Paciente p){
        Optional<Paciente> optionalPaciente = pacienteRepository.findById(p.getIdPaciente());

        if(optionalPaciente.isPresent()){
            Paciente toUpdate = optionalPaciente.get();
            toUpdate.setNome(p.getNome());
            toUpdate.setEmail(p.getEmail());
            toUpdate.setTelefone(p.getTelefone());
            pacienteRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }

    public void deletarPaciente(UUID idPaciente) {
        pacienteRepository.findById(idPaciente)
                .ifPresent(p ->pacienteRepository.deleteById(p.getIdPaciente()));
    }


}
