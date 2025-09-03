package com.frederycklohan.ufpb.demo_api.DTO;


import com.frederycklohan.ufpb.demo_api.models.Paciente;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoDTO {
    private UUID idMedico;
    private String nome;
    private String telefone;
    private String email;
}
