package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.IdGeneratorType;

@Entity
@Table(name = "consulta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String dataHora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "medico_crm", nullable = false)
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private boolean consultaMarcada = true;


    private String motivoDoCancelamento;

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
