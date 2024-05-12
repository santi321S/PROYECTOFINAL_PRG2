package co.edu.unbosque.service;

import co.edu.unbosque.entidades.Emisora;
import co.edu.unbosque.repository.EmisoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmisoraService {

    @Autowired
    private EmisoraRepository emisoraRepository;

    public Emisora crearEmisora(Emisora emisora) {
        return emisoraRepository.save(emisora);
    }

    public List<Emisora> listaEmisoras() {
        return emisoraRepository.findAll();
    }

    public Optional<Emisora> emisorasId(Integer id) {
        return emisoraRepository.findById(id);
    }

    public void eliminarId(Integer id) {
        emisoraRepository.deleteById(id);
    }

    public Emisora actualizarEmisora(Integer id, Emisora emisoraAjustada) {
        Optional<Emisora> emisora = emisoraRepository.findById(id);
        if (emisora.isEmpty()) {
            return new Emisora();
        }
        Emisora existe = emisora.get();
        existe.setNombreEmisora(emisoraAjustada.getNombreEmisora());
        existe.setModoTransmision(emisoraAjustada.getModoTransmision());
        existe.setTipoMusica(emisoraAjustada.getTipoMusica());
        return emisoraRepository.save(emisoraAjustada);
    }

}
