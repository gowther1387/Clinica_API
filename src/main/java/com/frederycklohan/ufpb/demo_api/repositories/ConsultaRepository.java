package com.frederycklohan.ufpb.demo_api.repositories;

import com.frederycklohan.ufpb.demo_api.models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta,Long> {
    Consulta getReferenceByIdChave(long idChave);
}
