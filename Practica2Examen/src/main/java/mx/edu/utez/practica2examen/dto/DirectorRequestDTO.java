package mx.edu.utez.practica2examen.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DirectorRequestDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "La nacionalidad es obligatoria")
    private String nacionalidad;

    @NotBlank(message = "El titulo es obligatorio")
    private String titulo;

    @NotNull(message = "El anio es obligatorio")
    private int anio;

    @NotBlank(message = "El genero es obligatorio")
    private String genero;

    public DirectorRequestDTO() {
    }

    public DirectorRequestDTO(String nombre, String nacionalidad, String titulo, int anio, String genero) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.titulo = titulo;
        this.anio = anio;
        this.genero = genero;
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
}
