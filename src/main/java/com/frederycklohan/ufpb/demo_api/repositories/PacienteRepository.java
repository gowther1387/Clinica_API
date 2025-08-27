package com.frederycklohan.ufpb.demo_api.repositories;

import com.frederycklohan.ufpb.demo_api.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface PacienteRepository extends JpaRepository<Paciente, UUID> {
    Paciente getReferenceByRg(String rg);
    Paciente getReferenceByCpf(String cpf);
    Optional<Paciente> findById(UUID idPaciente);
}
