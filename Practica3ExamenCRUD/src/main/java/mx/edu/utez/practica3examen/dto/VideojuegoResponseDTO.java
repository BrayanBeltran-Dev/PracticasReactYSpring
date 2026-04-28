package mx.edu.utez.practica3examen.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class VideojuegoResponseDTO {

    private Long id;

    @NotBlank(message = "El titulo es obligatorio")
    private String titulo;

    @NotBlank(message = "El genero es obligatorio")
    private String genero;

    @NotBlank(message = "La plataforma es obligatoria")
    private String plataforma;

    @NotNull(message = "Se requiere el anio de lanzamiento")
    private int anioLanzamiento;

    public VideojuegoResponseDTO() {
    }

    public VideojuegoResponseDTO(Long id, String titulo, String genero, String plataforma, int anioLanzamiento) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.anioLanzamiento = anioLanzamiento;
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
}
