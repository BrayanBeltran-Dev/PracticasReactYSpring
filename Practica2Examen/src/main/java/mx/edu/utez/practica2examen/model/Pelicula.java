package mx.edu.utez.practica2examen.model;

import jakarta.persistence.*;

@Entity
@Table(name = "peliculas")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private int anio;

    @Column(nullable = false)
    private String genero;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;

    public Pelicula() {
    }

    public Pelicula(Long id, String titulo, int anio, String genero, Director director) {
        this.id = id;
        this.titulo = titulo;
        this.anio = anio;
        this.genero = genero;
        this.director = director;
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

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
