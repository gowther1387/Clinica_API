package Repository;

import model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    List<Medico> findByCrm(String crm);

    Medico getReferenceByCrm(String Crm);
}
