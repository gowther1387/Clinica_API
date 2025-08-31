package com.frederycklohan.ufpb.demo_api.repositories;

import com.frederycklohan.ufpb.demo_api.models.Consulta;
import com.frederycklohan.ufpb.demo_api.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ConsultaRepository extends JpaRepository<Consulta, UUID> {
    Consulta getReferenceByIdChave(UUID idChave);



    @Query("SELECT p FROM Consulta c JOIN c.pacientes p WHERE c.medico.idMedico = :idMedico")
    List<Paciente> findPacienteByIdMedico(@Param("idMedico") UUID idMedico);
}