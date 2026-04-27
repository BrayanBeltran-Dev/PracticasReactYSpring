package mx.edu.utez.examencorreccion.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ArtistaResponseDTO {

    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "La nacionalidad es obligatoria")
    private String nacionalidad;

    @NotBlank(message = "El genero musical es obligatorio")
    private String generoMusical;

    @NotNull(message = "Se requiere el anio debut")
    @Min(value = 1500)
    @Max(value = 2026)
    private int anioDebut;

    public ArtistaResponseDTO() {
    }

    public ArtistaResponseDTO(Long id, String nombre, String nacionalidad, String generoMusical, int anioDebut) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.generoMusical = generoMusical;
        this.anioDebut = anioDebut;
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
}
