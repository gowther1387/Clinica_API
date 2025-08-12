package repositories;

import EspecializaçãoMedico.Especializacao;
import models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Medico getReferenceByCrm(String Crm);
        List<Medico> findByEspecializacao(Especializacao especializacao);
}
