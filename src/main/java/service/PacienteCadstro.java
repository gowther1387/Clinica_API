package service;

import Repository.PacienteRepository;
import model.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteCadstro {

    private PacienteRepository pacienteRepository;

    private PacienteCadstro(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente cadastrarPaciente(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    public Paciente procurarPacientePorRg(String rg){
        return pacienteRepository.getReferenceByRg(rg);
    }

    public Paciente atualizarPaciente(Paciente paciente){
        Optional<Paciente> optionalPaciente = pacienteRepository.findById(paciente.getId());

        if(optionalPaciente.isPresent()){
            Paciente toUpdate = optionalPaciente.get();
            toUpdate.setNome(paciente.getNome());
            toUpdate.setRg(paciente.getRg());
            toUpdate.setCpf(paciente.getCpf());
            pacienteRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }

    public void deletarPaciente(Paciente paciente){
        pacienteRepository.delete(paciente);
    }


}
