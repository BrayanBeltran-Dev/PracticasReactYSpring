package mx.edu.utez.restaurantespractica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "restaurantes")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String tipoCocina;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private int anioApertura;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ubicacion_id")
    private DetalleUbicacion detalle;

    public Restaurante() {
    }

    public Restaurante(Long id, String nombre, String tipoCocina, String telefono, int anioApertura, DetalleUbicacion detalle) {
        this.id = id;
        this.nombre = nombre;
        this.tipoCocina = tipoCocina;
        this.telefono = telefono;
        this.anioApertura = anioApertura;
        this.detalle = detalle;
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

    public DetalleUbicacion getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleUbicacion detalle) {
        this.detalle = detalle;
    }
}
