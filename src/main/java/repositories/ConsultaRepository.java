package repositories;

import models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta,Long> {
    Consulta getReferenceByIdChave(long idChave);
}
