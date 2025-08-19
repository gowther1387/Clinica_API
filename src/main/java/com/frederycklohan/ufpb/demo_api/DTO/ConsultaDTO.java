package com.frederycklohan.ufpb.demo_api.DTO;

import ch.qos.logback.core.status.Status;
import com.frederycklohan.ufpb.demo_api.StatusConsulta.StatusConsulta;

import java.time.LocalDate;

public class ConsultaDTO {
    private String medico;
    private LocalDate dataHora;
    private StatusConsulta statusConsulta;
}
