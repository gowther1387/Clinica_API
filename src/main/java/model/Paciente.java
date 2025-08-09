package model;


import jakarta.persistence.*;

@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "idade")
    private String idade;

    @Column(name = "rg")
    private String rg;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;


}
