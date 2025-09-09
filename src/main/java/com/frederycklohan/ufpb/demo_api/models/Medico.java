package com.frederycklohan.ufpb.demo_api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.frederycklohan.ufpb.demo_api.EspecializaçãoMedico.Especializacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Collection;
import java.util.Objects;
import java.util.UUID;


@Entity
@Table(name = "medico", schema = "public")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idMedico;


    @NotBlank
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private Especializacao especializacao;

    @NotNull
    @Column(name = "crm", nullable = false)
    private long crm;

    @NotBlank
    @Column(name = "telefone", length = 20, nullable = false)
    private String telefone;

    @Email
    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "medico")
    private Collection<Consulta> consulta;

    public UUID getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(UUID idMedico) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medico medico = (Medico) o;
        return idMedico != null && idMedico.equals(medico.idMedico);
    }
    @Override
    public int hashCode() {
        return Objects.hash(idMedico);
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