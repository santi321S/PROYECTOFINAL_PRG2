package co.edu.unbosque.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "parrillaprogramacion")
public class Parrillaprogramacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_programacion")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_pista_musical")
    private Pistamusical idPistaMusical;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_emisora")
    private Emisora idEmisora;

    @Column(name = "dia", length = 50)
    private String dia;

    @Column(name = "turno")
    private Integer turno;

    public Emisora getIdEmisora() {
        return idEmisora;
    }

    public void setIdEmisora(Emisora idEmisora) {
        this.idEmisora = idEmisora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pistamusical getIdPistaMusical() {
        return idPistaMusical;
    }

    public void setIdPistaMusical(Pistamusical idPistaMusical) {
        this.idPistaMusical = idPistaMusical;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Integer getTurno() {
        return turno;
    }

    public void setTurno(Integer turno) {
        this.turno = turno;
    }

}