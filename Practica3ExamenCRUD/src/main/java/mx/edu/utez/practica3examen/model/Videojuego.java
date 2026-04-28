package mx.edu.utez.practica3examen.model;

import jakarta.persistence.*;

@Entity
@Table(name = "videojuegos")
public class Videojuego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private String plataforma;

    @Column(nullable = false)
    private int anioLanzamiento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detalle_id")
    private DetalleDesarrollo detalle;

    public Videojuego() {
    }

    public Videojuego(Long id, String titulo, String genero, String plataforma, int anioLanzamiento, DetalleDesarrollo detalle) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.anioLanzamiento = anioLanzamiento;
        this.detalle = detalle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public DetalleDesarrollo getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleDesarrollo detalle) {
        this.detalle = detalle;
    }
}
