package com.frederycklohan.ufpb.demo_api.repositories;

import com.frederycklohan.ufpb.demo_api.models.Consulta;
import com.frederycklohan.ufpb.demo_api.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta,Long> {
    Consulta getReferenceByIdChave(long idChave);

    @Query(value = "SELECT p FROM pacientes p JOIN FETCH p.consulta c WHERE c.medico.id = : idMedico ", nativeQuery = true)
    List<Consulta> findPacientesByMedico(@Param("medico")Medico medico);
}