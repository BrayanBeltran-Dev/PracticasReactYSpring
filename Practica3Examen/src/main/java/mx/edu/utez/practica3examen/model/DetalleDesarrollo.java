package mx.edu.utez.practica3examen.model;

import jakarta.persistence.*;

@Entity
@Table(name = "detalles_desarrollo")
public class DetalleDesarrollo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String estudio;

    @Column(nullable = false)
    private int duracioHoras;

    @Column(nullable = false)
    private int jugadoresMaximos;

    @Column(nullable = false)
    private String idioma;

    @OneToOne(mappedBy = "detalle")
    private Videojuego videojuego;

    public DetalleDesarrollo() {
    }

    public DetalleDesarrollo(Long id, String estudio, int duracioHoras, int jugadoresMaximos, String idioma, Videojuego videojuego) {
        this.id = id;
        this.estudio = estudio;
        this.duracioHoras = duracioHoras;
        this.jugadoresMaximos = jugadoresMaximos;
        this.idioma = idioma;
        this.videojuego = videojuego;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public int getDuracioHoras() {
        return duracioHoras;
    }

    public void setDuracioHoras(int duracioHoras) {
        this.duracioHoras = duracioHoras;
    }

    public int getJugadoresMaximos() {
        return jugadoresMaximos;
    }

    public void setJugadoresMaximos(int jugadoresMaximos) {
        this.jugadoresMaximos = jugadoresMaximos;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Videojuego getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(Videojuego videojuego) {
        this.videojuego = videojuego;
    }
}
