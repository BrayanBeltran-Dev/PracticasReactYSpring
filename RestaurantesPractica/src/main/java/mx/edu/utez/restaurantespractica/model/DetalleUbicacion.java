package mx.edu.utez.restaurantespractica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_ubicacion")
public class DetalleUbicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String calle;

    @Column(nullable = false)
    private String ciudad;

    @Column(nullable = false)
    private int codigoPostal;

    @Column(nullable = false)
    private int capacidadMesas;

    @OneToOne(mappedBy = "detalle")
    private Restaurante restaurante;

    public DetalleUbicacion() {
    }

    public DetalleUbicacion(Long id, String calle, String ciudad, int codigoPostal, int capacidadMesas, Restaurante restaurante) {
        this.id = id;
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.capacidadMesas = capacidadMesas;
        this.restaurante = restaurante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
}

