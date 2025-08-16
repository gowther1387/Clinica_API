package com.frederycklohan.ufpb.demo_api.repositories;

import com.frederycklohan.ufpb.demo_api.models.Consulta;
import com.frederycklohan.ufpb.demo_api.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta,Long> {
    Consulta getReferenceByIdChave(long idChave);
    List<Medico> findByMedico(long idMedico);

    List<Consulta> idChave(long idChave);
}
