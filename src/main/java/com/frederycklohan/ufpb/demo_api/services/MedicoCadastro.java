package com.frederycklohan.ufpb.demo_api.services;

import com.frederycklohan.ufpb.demo_api.EspecializaçãoMedico.Especializacao;
import com.frederycklohan.ufpb.demo_api.repositories.MedicoRepository;
import com.frederycklohan.ufpb.demo_api.models.Medico;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoCadastro {

    private MedicoRepository medicoRepository;

    private void medicoCadastro(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public Medico cadastrarMedico(Medico m) {
        return medicoRepository.save(m);
    }

    public Medico ProcurarMedicoPorCrm(long crm){
        return medicoRepository.getReferenceByCrm(crm);
    }


    public List<Medico> listaDeMedicos(){
        return medicoRepository.findAll();
    }

    public List<Medico> listaDeMedicosPorEspecialidade(Especializacao e){
        return medicoRepository.findByEspecializacao(e);
    }


    public Medico atualizarMedico(Medico m){
        Optional<Medico> optionalMedico = medicoRepository.findById(m.getIdMedico());

        if(optionalMedico.isPresent()){
            Medico toUpdate = optionalMedico.get();
            toUpdate.setNome(m.getNome());
            toUpdate.setEspecializacao( m.getEspecializacao() );
            toUpdate.setCrm(m.getCrm());
            toUpdate.setEmail(m.getEmail());
            toUpdate.getTelefone(); 
            medicoRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }

    public void deletarPaciente(Medico m){
        medicoRepository.delete(m);
    }


}
