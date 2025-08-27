package com.frederycklohan.ufpb.demo_api.repositories;

import com.frederycklohan.ufpb.demo_api.EspecializaçãoMedico.Especializacao;
import com.frederycklohan.ufpb.demo_api.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MedicoRepository extends JpaRepository<Medico, UUID> {
    Medico getReferenceByCrm(long Crm);
    List<Medico> findByEspecializacao(Especializacao especializacao);
}
