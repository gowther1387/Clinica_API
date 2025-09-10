package com.frederycklohan.ufpb.demo_api.services;

import com.frederycklohan.ufpb.demo_api.DTO.PacienteDTO;
import com.frederycklohan.ufpb.demo_api.config.PacienteMapper;
import com.frederycklohan.ufpb.demo_api.repositories.PacienteRepository;
import com.frederycklohan.ufpb.demo_api.models.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PacienteCadastro {

    private final PacienteRepository pacienteRepository;
    private final PacienteMapper pacienteMapper;

    private PacienteCadastro(PacienteRepository pacienteRepository,
                             PacienteMapper pacienteMapper) {
        this.pacienteRepository = pacienteRepository;
        this.pacienteMapper = pacienteMapper;
    }

    public PacienteDTO cadastrarPaciente(PacienteDTO pacienteDTO)   {

        Paciente paciente = pacienteMapper.toEntity(pacienteDTO);
        paciente = pacienteRepository.save(paciente);
        return pacienteMapper.toDTO(paciente);
    }

    public Paciente procurarPacientePorRg(String rg){
        return pacienteRepository.getReferenceByRg(rg);
    }

    public Paciente procurarPacientePorCpf(String cpf) {
        return pacienteRepository.getReferenceByCpf(cpf);
    }

    public List<Paciente> listaTodosPacientes(){
        return pacienteRepository.findAll();
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
