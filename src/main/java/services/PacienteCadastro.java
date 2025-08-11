package services;

import Repositories.PacienteRepository;
import models.Paciente;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PacienteCadastro {

    private PacienteRepository pacienteRepository;

    private PacienteCadastro(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente cadastrarPaciente(Paciente p){
        return pacienteRepository.save(p);
    }

    public Paciente procurarPacientePorRg(String rg){
        return pacienteRepository.getReferenceByRg(rg);
    }

    public Paciente atualizarPaciente(Paciente p){
        Optional<Paciente> optionalPaciente = pacienteRepository.findById(p.getId());

        if(optionalPaciente.isPresent()){
            Paciente toUpdate = optionalPaciente.get();
            toUpdate.setNome(p.getNome());
            toUpdate.setRg(p.getRg());
            toUpdate.setCpf(p.getCpf());
            pacienteRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }

    public void deletarPaciente(Paciente p){
        pacienteRepository.delete(p);
    }


}
