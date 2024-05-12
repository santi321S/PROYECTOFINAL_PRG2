package co.edu.unbosque.controller;

import co.edu.unbosque.entidades.Emisora;
import co.edu.unbosque.entidades.Parrillaprogramacion;
import co.edu.unbosque.service.EmisoraService;
import co.edu.unbosque.service.ParrillaService;
import co.edu.unbosque.utils.Funciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PrincipalController {

    @Autowired
    EmisoraService emisoraService;

    @Autowired
    ParrillaService parrillaService;

    @GetMapping("/")
    public String index(Model model) {
        Funciones ff = new Funciones();
        List<Emisora> listaemisora = emisoraService.listaEmisoras();
        List<Parrillaprogramacion> listaParrilla = parrillaService.filtrardiaYemisora(ff.obtenerNombreDiaActual(), ff.obtenerPrimerIdEmisora(listaemisora));
        model.addAttribute("listaEmisoras", listaemisora);
        model.addAttribute("primerAudio", ff.getFirstSong(listaParrilla));
        model.addAttribute("listaPistas", ff.getListSongs(listaParrilla));
        model.addAttribute("emisora", new Emisora());
        return "index";
    }

    @PostMapping("/cambioEmisora")
    public String cambioEmisora(@ModelAttribute Emisora emisora, Model model) {
        Funciones ff = new Funciones();
        List<Emisora> listaEmisora = emisoraService.listaEmisoras();
        List<Parrillaprogramacion> listaParrilla = parrillaService.filtrardiaYemisora(ff.obtenerNombreDiaActual(), emisora.getId());
        model.addAttribute("listaEmisoras", listaEmisora);
        model.addAttribute("primerAudio", ff.getFirstSong(listaParrilla));
        model.addAttribute("listaPistas", ff.getListSongs(listaParrilla));
        return "index";
    }
}
