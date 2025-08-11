package Repositories;

import models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    List<Paciente> findByCpf(String cpf);

    List<Paciente> cpf(String cpf);

    Paciente getReferenceByRg(String rg);
}
