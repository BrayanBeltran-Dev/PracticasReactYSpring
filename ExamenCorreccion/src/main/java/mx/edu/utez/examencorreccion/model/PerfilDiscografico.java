package mx.edu.utez.examencorreccion.model;

import jakarta.persistence.*;

@Entity
@Table(name = "perfil_discografico")
public class PerfilDiscografico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String disquera;

    @Column(nullable = false)
    private int albumsProducidos;

    @Column(nullable = false)
    private int premiosGanados;

    @Column(nullable = false)
    private Boolean enActivo;

    @OneToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;

    public PerfilDiscografico() {
    }

    public PerfilDiscografico(Long id, String disquera, int albumsProducidos, int premiosGanados, Boolean enActivo, Artista artista) {
        this.id = id;
        this.disquera = disquera;
        this.albumsProducidos = albumsProducidos;
        this.premiosGanados = premiosGanados;
        this.enActivo = enActivo;
        this.artista = artista;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
}
