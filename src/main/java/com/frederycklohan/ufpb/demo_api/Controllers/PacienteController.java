package com.frederycklohan.ufpb.demo_api.Controllers;

import com.frederycklohan.ufpb.demo_api.models.Paciente;
import com.frederycklohan.ufpb.demo_api.repositories.PacienteRepository;
import com.frederycklohan.ufpb.demo_api.services.PacienteCadastro;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paciente")
public class PacienteController {


    private  PacienteCadastro pacienteCadastro;



    @PostMapping("/cdstPaciente")
    public Paciente cadastrarPaciente(@RequestBody Paciente p) {
        return pacienteCadastro.cadastrarPaciente(p);
    }

    @GetMapping("/paciente/{cpf}")
    public Paciente procurarPacientePorCpf(@PathVariable String cpf) {
        return pacienteCadastro.procurarPacientePorCpf(cpf);
    }

    @GetMapping("/paciente/{rg}")
    public Paciente procurarPacientePorRg(@PathVariable String rg) {
        return pacienteCadastro.procurarPacientePorRg(rg);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/dltPaciente/{id}")
    public void deletarPaciente( @PathVariable long idPaciente) {
        pacienteCadastro.deletarPaciente(idPaciente);
    }


}
