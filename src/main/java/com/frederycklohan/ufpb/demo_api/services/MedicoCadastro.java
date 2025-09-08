package com.frederycklohan.ufpb.demo_api.services;

import com.frederycklohan.ufpb.demo_api.DTO.MedicoDTO;
import com.frederycklohan.ufpb.demo_api.EspecializaçãoMedico.Especializacao;
import com.frederycklohan.ufpb.demo_api.config.MedicoMapper;
import com.frederycklohan.ufpb.demo_api.repositories.MedicoRepository;
import com.frederycklohan.ufpb.demo_api.models.Medico;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MedicoCadastro {

    private final MedicoRepository medicoRepository;
    private final MedicoMapper medicoMapper;

    MedicoCadastro(MedicoRepository medicoRepository,
                   MedicoMapper medicoMapper) {
        this.medicoRepository = medicoRepository;
        this.medicoMapper = medicoMapper;
    }

    public MedicoDTO cadastrarMedico(MedicoDTO medicoDTO) {

        Medico medico = medicoMapper.toEntity(medicoDTO);
        medico = medicoRepository.save(medico);
        return medicoMapper.toDTO(medico);
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


    public MedicoDTO convertMedicoToDto(Medico m){


        MedicoDTO meditoDto = new MedicoDTO();
        meditoDto.setIdMedico(m.getIdMedico());
        meditoDto.setNome(m.getNome());
        meditoDto.setEmail(m.getEmail());
        meditoDto.setTelefone(m.getTelefone());

        return meditoDto;
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

    public void deletarMedico(UUID idMedico){

        medicoRepository.findById(idMedico)
                .ifPresent(m ->medicoRepository.deleteById(m.getIdMedico()));
    }


}
