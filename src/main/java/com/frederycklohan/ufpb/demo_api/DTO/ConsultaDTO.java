package com.frederycklohan.ufpb.demo_api.DTO;

import com.frederycklohan.ufpb.demo_api.StatusConsulta.StatusConsulta;
import com.frederycklohan.ufpb.demo_api.models.Medico;
import com.frederycklohan.ufpb.demo_api.models.Paciente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaDTO {
    private MedicoDTO medico;
    private Set<PacienteDTO> pacientes;
    private LocalDate dataHora;
    private StatusConsulta statusConsulta;
}
