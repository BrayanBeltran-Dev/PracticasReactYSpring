package mx.edu.utez.practica3examen.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class VideojuegoRequestDTO {

    @NotBlank(message = "El titulo es obligatorio")
    private String titulo;

    @NotBlank(message = "El genero es obligatorio")
    private String genero;

    @NotBlank(message = "La plataforma es obligatoria")
    private String plataforma;

    @NotNull(message = "Se requiere el anio de lanzamiento")
    private int anioLanzamiento;

    @NotBlank(message = "El estudio es obligatorio")
    private String estudio;

    @NotNull(message = "Se requiere la duracion")
    private int duracionHoras;

    @NotNull(message = "Se requiere el maximo de jugadores")
    private int jugadoresMaximos;

    @NotBlank(message = "El idioma es obligatorio")
    private String idioma;

    public VideojuegoRequestDTO() {
    }

    public VideojuegoRequestDTO(String titulo, String genero, String plataforma, int anioLanzamiento, String estudio, int duracionHoras, int jugadoresMaximos, String idioma) {
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.anioLanzamiento = anioLanzamiento;
        this.estudio = estudio;
        this.duracionHoras = duracionHoras;
        this.jugadoresMaximos = jugadoresMaximos;
        this.idioma = idioma;
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

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
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
}
