package mx.edu.utez.restaurantespractica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RestauranteResponseDTO {

    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El tipo es obligatorio")
    private String tipoCocina;

    @NotBlank(message = "El telefono es obligatorio")
    private String telefono;

    @NotNull(message = "Se requiere el telefono")
    private int anioApertura;

    public RestauranteResponseDTO() {
    }

    public RestauranteResponseDTO(Long id, String nombre, String tipoCocina, String telefono, int anioApertura) {
        this.id = id;
        this.nombre = nombre;
        this.tipoCocina = tipoCocina;
        this.telefono = telefono;
        this.anioApertura = anioApertura;
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

    public String getTipoCocina() {
        return tipoCocina;
    }

    public void setTipoCocina(String tipoCocina) {
        this.tipoCocina = tipoCocina;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getAnioApertura() {
        return anioApertura;
    }

    public void setAnioApertura(int anioApertura) {
        this.anioApertura = anioApertura;
    }
}
