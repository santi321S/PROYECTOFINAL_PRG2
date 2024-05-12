package co.edu.unbosque.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "emisora")
public class    Emisora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_emisora", nullable = false)
    private Integer id;

    @Column(name = "nombre_emisora", nullable = false)
    private String nombreEmisora;

    @Lob
    @Column(name = "modo_transmision", nullable = false)
    private String modoTransmision;

    @Column(name = "tipo_musica", nullable = false, length = 100)
    private String tipoMusica;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEmisora() {
        return nombreEmisora;
    }

    public void setNombreEmisora(String nombreEmisora) {
        this.nombreEmisora = nombreEmisora;
    }

    public String getModoTransmision() {
        return modoTransmision;
    }

    public void setModoTransmision(String modoTransmision) {
        this.modoTransmision = modoTransmision;
    }

    public String getTipoMusica() {
        return tipoMusica;
    }

    public void setTipoMusica(String tipoMusica) {
        this.tipoMusica = tipoMusica;
    }

}