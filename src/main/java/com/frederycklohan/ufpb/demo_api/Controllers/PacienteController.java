package com.frederycklohan.ufpb.demo_api.Controllers;

import com.frederycklohan.ufpb.demo_api.models.Paciente;
import com.frederycklohan.ufpb.demo_api.repositories.PacienteRepository;
import com.frederycklohan.ufpb.demo_api.services.PacienteCadastro;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/paciente")
public class PacienteController {


    private final PacienteCadastro pacienteCadastro;

    public PacienteController(PacienteCadastro pacienteCadastro){
        this.pacienteCadastro = pacienteCadastro;
    }

    @PostMapping("/cdstPaciente")
    public Paciente cadastrarPaciente(@RequestBody Paciente p) {
        return pacienteCadastro.cadastrarPaciente(p);
    }

    @GetMapping(path = "/findPaciente/{cpf}")
    public Paciente procurarPacientePorCpf(@PathVariable String cpf) {
        return pacienteCadastro.procurarPacientePorCpf(cpf);
    }

    @GetMapping("/findAll")
    public List<Paciente> listaPacientes(){
           return pacienteCadastro.listaTodosPacientes();
    }

    @GetMapping( path ="/paciente/{rg}")
    public Paciente procurarPacientePorRg(@PathVariable String rg) {
        return pacienteCadastro.procurarPacientePorRg(rg);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(path = "/dltPaciente/{idPaciente}")
    public void deletarPaciente( @PathVariable UUID idPaciente) {
        pacienteCadastro.deletarPaciente(idPaciente);
    }


}
