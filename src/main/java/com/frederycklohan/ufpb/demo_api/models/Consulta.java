package com.frederycklohan.ufpb.demo_api.models;

import jakarta.persistence.*;
import com.frederycklohan.ufpb.demo_api.StatusConsulta.StatusConsulta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdChave")
    private long idChave;

    @Column(nullable = false)
    private LocalDate dataHora;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "medico", nullable = false)
    private Medico medico;

    @ManyToMany()
    @JoinTable(
                name = "consulta_paciente",
                joinColumns = @JoinColumn(name = "idChave"),
                inverseJoinColumns = @JoinColumn(name = "idPaciente")
    )
    private Set<Paciente> pacientes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusConsulta statusConsulta;

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    public long getIdChave() {
        return idChave;
    }

    public void setIdChave(long idChave) {
        this.idChave = idChave;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Set<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(Set<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public StatusConsulta getStatusConsulta() {
        return statusConsulta;
    }

    public void setStatusConsulta(StatusConsulta statusConsulta) {
        this.statusConsulta = statusConsulta;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "idChave=" + idChave +
                ", dataHora=" + dataHora +
                ", medico=" + medico +
                ", pacientes=" + pacientes +
                ", statusConsulta=" + statusConsulta +
                '}';
    }
}