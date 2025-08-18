package com.frederycklohan.ufpb.demo_api.models;

import com.frederycklohan.ufpb.demo_api.EspecializaçãoMedico.Especializacao;
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
    private Especializacao especializacao;

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

    public Especializacao getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(Especializacao especializacao) {
        this.especializacao = especializacao;
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

    @Override
    public String toString() {
        return "Medico{" +
                "idMedico=" + idMedico +
                ", nome='" + nome + '\'' +
                ", especializacao=" + especializacao +
                ", crm=" + crm +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}