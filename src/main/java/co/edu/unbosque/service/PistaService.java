package co.edu.unbosque.service;

import co.edu.unbosque.entidades.Pistamusical;
import co.edu.unbosque.repository.PistamusicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class PistaService {

    @Autowired
    private PistamusicalRepository pistamusicalRepository;

    public Pistamusical crearPista(Pistamusical pistamusical, MultipartFile archivo) {
        pistamusical.setArchivoMp3(subirArchivo(archivo));
        return pistamusicalRepository.save(pistamusical);
    }

    public List<Pistamusical> listaPistas() {
        return pistamusicalRepository.findAll();
    }

    public Optional<Pistamusical> pistasId(Integer id) {
        return pistamusicalRepository.findById(id);
    }

    public void eliminarId(Integer id) {
        eliminarArchivo(pistasId(id).get().getArchivoMp3());
        pistamusicalRepository.deleteById(id);
    }

    public Pistamusical actualizarPista(Integer id, Pistamusical pistaAjustada) {
        Optional<Pistamusical> pista = pistamusicalRepository.findById(id);
        if (pista.isEmpty()) {
            return new Pistamusical();
        }
        Pistamusical existe = pista.get();
        existe.setNombreCancion(pistaAjustada.getNombreCancion());
        existe.setNombreArtista(pistaAjustada.getNombreArtista());
        existe.setGeneroMusical(pistaAjustada.getGeneroMusical());
        existe.setArchivoMp3(pistaAjustada.getArchivoMp3());
        return pistamusicalRepository.save(existe);
    }

    public String subirArchivo(MultipartFile archivo) {
        if (!archivo.isEmpty()) {
            try {
                Path ruta = Paths.get("src/main/resources/static/audios", archivo.getOriginalFilename());
                archivo.transferTo(new File(ruta.toAbsolutePath().toString()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "/audios/" + archivo.getOriginalFilename();
    }

    public void eliminarArchivo(String ruta) {
        Path rutaPath = Paths.get("src/main/resources/static",ruta).toAbsolutePath();
        try {
            Files.deleteIfExists(rutaPath);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
