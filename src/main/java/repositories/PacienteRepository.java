package repositories;

import models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Paciente getReferenceByRg(String rg);
}
