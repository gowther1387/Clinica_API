package com.frederycklohan.ufpb.demo_api.DTO;


import com.frederycklohan.ufpb.demo_api.models.Paciente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDTO {

    private UUID idPaciente;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String telefone;

    public PacienteDTO (Paciente paciente){
        BeanUtils.copyProperties(paciente, this);
    }

    public PacienteDTO(){

    }
}
