package com.frederycklohan.ufpb.demo_api.models;

import jakarta.persistence.*;
import com.frederycklohan.ufpb.demo_api.StatusConsulta.StatusConsulta;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "paciente", nullable = false)
    private Paciente paciente;

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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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
                ", paciente=" + paciente +
                ", statusConsulta=" + statusConsulta +
                '}';
    }
}