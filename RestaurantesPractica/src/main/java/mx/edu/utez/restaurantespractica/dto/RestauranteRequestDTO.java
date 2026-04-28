package mx.edu.utez.restaurantespractica.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RestauranteRequestDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El tipo es obligatorio")
    private String tipoCocina;

    @NotBlank(message = "El telefono es obligatorio")
    private String telefono;

    @NotNull(message = "Se requiere el telefono")
    private int anioApertura;

    @NotBlank(message = "La calle es obligatoria")
    private String calle;

    @NotBlank(message = "La ciudad es obligatoria")
    private String ciudad;

    @NotNull(message = "Se requiere el codigo postal")
    private int codigoPostal;

    @NotNull(message = "Se requiere la capacidad")
    private int capacidadMesas;

    public RestauranteRequestDTO() {
    }

    public RestauranteRequestDTO(String nombre, String tipoCocina, String telefono, int anioApertura, String calle, String ciudad, int codigoPostal, int capacidadMesas) {
        this.nombre = nombre;
        this.tipoCocina = tipoCocina;
        this.telefono = telefono;
        this.anioApertura = anioApertura;
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.capacidadMesas = capacidadMesas;
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

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getCapacidadMesas() {
        return capacidadMesas;
    }

    public void setCapacidadMesas(int capacidadMesas) {
        this.capacidadMesas = capacidadMesas;
    }
}
