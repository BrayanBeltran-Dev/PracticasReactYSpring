package mx.edu.utez.examencorreccion.service;

import mx.edu.utez.examencorreccion.dto.ArtistaRequestDTO;
import mx.edu.utez.examencorreccion.model.Artista;
import mx.edu.utez.examencorreccion.model.PerfilDiscografico;
import mx.edu.utez.examencorreccion.repository.ArtistaRepository;
import mx.edu.utez.examencorreccion.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArtistaService {
    @Autowired
    private ArtistaRepository artistaRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    @Transactional
    public Artista registrar(ArtistaRequestDTO unartista){

        Artista artista = new Artista();
        artista.setNombre(unartista.getNombre());
        artista.setNacionalidad(unartista.getNacionalidad());
        artista.setGeneroMusical(unartista.getGeneroMusical());
        artista.setAnioDebut(unartista.getAnioDebut());

        PerfilDiscografico perfilDiscografico = new PerfilDiscografico();
        perfilDiscografico.setDisquera(unartista.getDisquera());
        perfilDiscografico.setAlbumsProducidos(unartista.getAlbumsProducidos());
        perfilDiscografico.setPremiosGanados(unartista.getPremiosGanados());
        perfilDiscografico.setEnActivo(unartista.getEnActivo());
        perfilDiscografico.setArtista(artista);

        artista.setPerfil(perfilDiscografico);

        return artistaRepository.save(artista);
    }
}
