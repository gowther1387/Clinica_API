package com.frederycklohan.ufpb.demo_api.repositories;

import com.frederycklohan.ufpb.demo_api.models.Consulta;
import com.frederycklohan.ufpb.demo_api.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ConsultaRepository extends JpaRepository<Consulta,Long> {
    Consulta getReferenceByIdChave(long idChave);

    List<Paciente> findPacientesByMedico(@Param("idMedico") UUID idMedico);
}