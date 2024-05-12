package co.edu.unbosque.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "pistamusical")
public class Pistamusical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pista_musical", nullable = false)
    private Integer id;

    @Column(name = "genero_musical", nullable = false, length = 100)
    private String generoMusical;

    @Column(name = "nombre_cancion", nullable = false)
    private String nombreCancion;

    @Column(name = "nombre_artista", nullable = false)
    private String nombreArtista;

    @Column(name = "archivo_MP3", nullable = false)
    private String archivoMp3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getArchivoMp3() {
        return archivoMp3;
    }

    public void setArchivoMp3(String archivoMp3) {
        this.archivoMp3 = archivoMp3;
    }

}