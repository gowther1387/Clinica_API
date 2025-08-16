package com.frederycklohan.ufpb.demo_api.Controllers;


import com.frederycklohan.ufpb.demo_api.EspecializaçãoMedico.Especializacao;
import com.frederycklohan.ufpb.demo_api.models.Medico;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.frederycklohan.ufpb.demo_api.services.MedicoCadastro;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class MedicoController {


    private final MedicoCadastro medicoCadastro;

    public MedicoController(MedicoCadastro medicoCadastro) {
        this.medicoCadastro = medicoCadastro;
    }

    @PostMapping
    public Medico cadastroMedico(@RequestBody Medico m){
        return medicoCadastro.cadastrarMedico(m);
    }

    @GetMapping("/lstmedicos")
    List<Medico> listaDeMedicos(){
        return medicoCadastro.listaDeMedicos();
    }

    @GetMapping(path = "/lstmedicos/{especializacao}")
    List<Medico> listaDeMedicosPorEspecialidade(@PathVariable Especializacao especializacao){
        return medicoCadastro.listaDeMedicosPorEspecialidade(especializacao);
    }

    @GetMapping(path = "/findmedico/{crm}")
    Medico findMedicoPorCrm(@PathVariable long crm){
        return medicoCadastro.ProcurarMedicoPorCrm(crm);
    }

    @PutMapping(path = "/att/{crm}")
    public Medico atualizarMedico(@PathVariable long crm ,@RequestBody Medico m){
        return medicoCadastro.atualizarMedico(m);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(path = "/dltmedico/{idMedico}")
    public void deletarMedico(@PathVariable long idMedico){
        medicoCadastro.deletarMedico(idMedico);
    }
}
