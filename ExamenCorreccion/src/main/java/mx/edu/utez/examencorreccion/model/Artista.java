package mx.edu.utez.examencorreccion.model;

import jakarta.persistence.*;

@Entity
@Table(name = "artistas")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String nacionalidad;

    @Column(nullable = false)
    private String generoMusical;

    @Column(nullable = false)
    private int anioDebut;

    @OneToOne(mappedBy = "artista", cascade = CascadeType.ALL)
    private PerfilDiscografico perfil;

    public Artista() {
    }

    public Artista(Long id, String nombre, String nacionalidad, String generoMusical, int anioDebut, PerfilDiscografico perfil) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.generoMusical = generoMusical;
        this.anioDebut = anioDebut;
        this.perfil = perfil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public int getAnioDebut() {
        return anioDebut;
    }

    public void setAnioDebut(int anioDebut) {
        this.anioDebut = anioDebut;
    }

    public PerfilDiscografico getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilDiscografico perfil) {
        this.perfil = perfil;
    }
}
