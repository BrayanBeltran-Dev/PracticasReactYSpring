package mx.edu.utez.examencorreccion.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ArtistaRequestDTO {

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

    @NotBlank(message = "La disquera es obligatoria")
    private String disquera;

    private int albumsProducidos;

    private int premiosGanados;

    private Boolean enActivo;

    public ArtistaRequestDTO() {
    }

    public ArtistaRequestDTO(String nombre, String nacionalidad, String generoMusical, int anioDebut, String disquera, int albumsProducidos, int premiosGanados, Boolean enActivo) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.generoMusical = generoMusical;
        this.anioDebut = anioDebut;
        this.disquera = disquera;
        this.albumsProducidos = albumsProducidos;
        this.premiosGanados = premiosGanados;
        this.enActivo = enActivo;
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

    public String getDisquera() {
        return disquera;
    }

    public void setDisquera(String disquera) {
        this.disquera = disquera;
    }

    public int getAlbumsProducidos() {
        return albumsProducidos;
    }

    public void setAlbumsProducidos(int albumsProducidos) {
        this.albumsProducidos = albumsProducidos;
    }

    public int getPremiosGanados() {
        return premiosGanados;
    }

    public void setPremiosGanados(int premiosGanados) {
        this.premiosGanados = premiosGanados;
    }

    public Boolean getEnActivo() {
        return enActivo;
    }

    public void setEnActivo(Boolean enActivo) {
        this.enActivo = enActivo;
    }
}
