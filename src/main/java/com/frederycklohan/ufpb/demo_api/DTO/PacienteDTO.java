package com.frederycklohan.ufpb.demo_api.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDTO {

    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String telefone;
}
