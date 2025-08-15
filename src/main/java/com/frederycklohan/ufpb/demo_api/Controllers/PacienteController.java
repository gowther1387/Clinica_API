package com.frederycklohan.ufpb.demo_api.Controllers;

import com.frederycklohan.ufpb.demo_api.models.Paciente;
import com.frederycklohan.ufpb.demo_api.services.PacienteCadastro;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paciente")
public class PacienteController {


    private  PacienteCadastro pacienteCadastro;


    @PostMapping
    public Paciente cadastrarPaciente(@RequestBody Paciente p) {
        return pacienteCadastro.cadastrarPaciente(p);
    }

    @GetMapping("/{cpf}")
    public Paciente procurarPacientePorCpf(@RequestBody Paciente p, @PathVariable String cpf) {
        return pacienteCadastro.procurarPacientePorCpf(p.getCpf());
    }

}
