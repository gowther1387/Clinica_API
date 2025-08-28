package com.frederycklohan.ufpb.demo_api.Controllers;

import com.frederycklohan.ufpb.demo_api.models.Consulta;
import com.frederycklohan.ufpb.demo_api.models.Medico;
import com.frederycklohan.ufpb.demo_api.models.Paciente;
import com.frederycklohan.ufpb.demo_api.services.ConsultaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/Consulta")
public class    ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping("/cdstConsulta")
    public Consulta cadastrarConsulta(@RequestBody Consulta c){
        return consultaService.cadastrarConsulta(c);
    }

    @GetMapping(path = "/findConsultas/{idChave}")
    public Consulta consultarConsulta(@PathVariable UUID idChave){
        return consultaService.procurarConsultaPorId(idChave);
    }

    @GetMapping(path = "/findPacientes/{idMedico}")
    List<Paciente> listaDepacientesDoMedico(@PathVariable UUID idMedico){
        return consultaService.procurarPacientesDoMedico(idMedico);
    }

    @PutMapping(path = "/attConsulta/{idChave}")
    public Consulta atualizarConsulta(@PathVariable UUID idChave, @RequestBody Consulta c){
        return consultaService.atualizarConsulta(c);
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(path = "/dltConsulta/{idChave}")
    public void deletarConsulta(@PathVariable UUID idChave){
        consultaService.deletarConsulta(idChave);
    }

}
