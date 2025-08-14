package services;

import repositories.ConsultaRepository;
import models.Consulta;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsultaService{

    private final ConsultaRepository consultaRepository;


    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public Consulta cadastrarConsulta(Consulta c) {
        return consultaRepository.save(c);
    }

    public Consulta procurarConsultaPorId(Long idChave){
        return consultaRepository.getReferenceByIdChave(idChave);
    }

    public Consulta atualizarConsulta(Consulta c){
        Optional<Consulta> optionalConsulta = consultaRepository.findById(c.getIdChave());

        if(optionalConsulta.isPresent()){
            Consulta toUpdate = optionalConsulta.get();
            toUpdate.setDataHora(c.getDataHora());
            toUpdate.setMedico(c.getMedico() );
            toUpdate.setPaciente(c.getPaciente());
            toUpdate.setConsultaMarcada(c.getConsultaMarcada());
            consultaRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }

    public void deletarConsulta(Consulta c){
        consultaRepository.delete(c);
    }
}