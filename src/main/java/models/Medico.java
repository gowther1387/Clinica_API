package models;

import EspecializaçãoMedico.Especializacao;
import jakarta.persistence.*;


@Entity
@Table(name = "medicos")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idMedico;

    @Column(name = "nome")
    private String nome;

    @Enumerated(EnumType.STRING)
    private Especializacao area;

    @Column(name = "crm")
    private long crm;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    public long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(long idMedico) {
        this.idMedico = idMedico;
    }

    public Especializacao getArea() {
        return area;
    }

    public void setArea(Especializacao area) {
        this.area = area;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCrm() {
        return crm;
    }

    public void setCrm(long crm) {
        this.crm = crm;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}