package co.edu.unbosque.service;

import co.edu.unbosque.entidades.Parrillaprogramacion;
import co.edu.unbosque.repository.ParrillaprogramacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParrillaService {

    @Autowired
    private ParrillaprogramacionRepository parrillaprogramacionRepository;

    public Parrillaprogramacion crearParrilla(Parrillaprogramacion parrilla) {
        return parrillaprogramacionRepository.save(parrilla);
    }

    public List<Parrillaprogramacion> listaParrilla() {
        return parrillaprogramacionRepository.findAll();
    }

    public Optional<Parrillaprogramacion> parrillaId(Integer id) {
        return parrillaprogramacionRepository.findById(id);
    }

    public void eliminarId(Integer id) {
        parrillaprogramacionRepository.deleteById(id);
    }

    public Parrillaprogramacion actualizarParrilla(Integer id, Parrillaprogramacion parrillaAjustada) {
        Optional<Parrillaprogramacion> parrilla = parrillaprogramacionRepository.findById(id);
        if (parrilla.isEmpty()) {
            return new Parrillaprogramacion();
        }
        Parrillaprogramacion existe = parrilla.get();
        existe.setDia(parrillaAjustada.getDia());
        existe.setTurno(parrillaAjustada.getTurno());
        return parrillaprogramacionRepository.save(existe);
    }

    public List<Parrillaprogramacion> filtrardiaYemisora(String texto, Integer idEmisora){
        return parrillaprogramacionRepository.filtrardiaYemisora(texto, idEmisora);
    }
}
