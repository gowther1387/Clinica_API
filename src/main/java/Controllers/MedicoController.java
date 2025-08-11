package Controllers;


import EspecializaçãoMedico.Especializacao;
import models.Medico;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.MedicoCadastro;

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


}
