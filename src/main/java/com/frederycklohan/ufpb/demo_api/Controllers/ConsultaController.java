package com.frederycklohan.ufpb.demo_api.Controllers;

import com.frederycklohan.ufpb.demo_api.models.Consulta;
import com.frederycklohan.ufpb.demo_api.models.Medico;
import com.frederycklohan.ufpb.demo_api.services.ConsultaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Consulta")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping("/cdstConsulta")
    public Consulta cadastrarConsulta(@RequestBody Consulta c){
        return consultaService.cadastrarConsulta(c);
    }

    @GetMapping(path = "/findConsulta/{idChave}")
    public Consulta consultarConsulta(@PathVariable Long idChave){
        return consultaService.procurarConsultaPorId(idChave);
    }

    @GetMapping(path = "/findConsulta/{idMedico}")
    List<Medico> ListaDeConsultasDoMedico(@PathVariable long idMedico){
        return consultaService.procurarConsultaPorMedico(idMedico);
    }

    @PutMapping(path = "/attConsulta/{idChave}")
    public Consulta atualizarConsulta(@PathVariable Long idChave, @RequestBody Consulta c){
        return consultaService.atualizarConsulta(c);
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(path = "/dltConsulta/{idChave}")
    public void deletarConsulta(@PathVariable long idChave){
        consultaService.deletarConsulta(idChave);
    }

}
