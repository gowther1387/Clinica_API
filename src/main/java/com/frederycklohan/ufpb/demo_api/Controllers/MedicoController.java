package com.frederycklohan.ufpb.demo_api.Controllers;


import com.frederycklohan.ufpb.demo_api.EspecializaçãoMedico.Especializacao;
import com.frederycklohan.ufpb.demo_api.models.Medico;
import org.springframework.web.bind.annotation.*;
import com.frederycklohan.ufpb.demo_api.services.MedicoCadastro;

import java.util.List;

@RestController
@RequestMapping("api/medico")
public class MedicoController {


    private MedicoCadastro medicoCadastro;

    @GetMapping("/lstmedicos")
    List<Medico> listaDeMedicos(){
        return medicoCadastro.listaDeMedicos();
    }

    @GetMapping("/lstmedicos/{especialidade}")
    List<Medico> listaDeMedicosPorEspecialidade(Especializacao especializacao){
        return medicoCadastro.listaDeMedicosPorEspecialidade(especializacao);
    }

    @PostMapping
    public Medico cadastroMedico(@RequestBody Medico m){
        return medicoCadastro.cadastrarMedico(m);
    }

    @PutMapping("{crm}")
    public Medico atualizarMedico(@RequestBody Medico m){
        return medicoCadastro.atualizarMedico(m);
    }
}
