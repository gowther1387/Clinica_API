package services;

import EspecializaçãoMedico.Especializacao;
import repositories.MedicoRepository;
import models.Medico;
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

    public Medico ProcurarMedicoPorCrm(String crm){
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
            toUpdate.setArea( m.getArea() );
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
