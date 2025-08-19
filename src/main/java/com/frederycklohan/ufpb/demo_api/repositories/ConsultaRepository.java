package com.frederycklohan.ufpb.demo_api.repositories;

import com.frederycklohan.ufpb.demo_api.models.Consulta;
import com.frederycklohan.ufpb.demo_api.models.Medico;
import com.frederycklohan.ufpb.demo_api.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta,Long> {
    Consulta getReferenceByIdChave(long idChave);

    @Query(value = "SELECT * FROM pacientes p JOIN FETCH p.consulta c WHERE c.medico = :idMedico ", nativeQuery = true)
    List<Paciente> findPacientesByMedico(@Param("idMedico") long idMedico);
}