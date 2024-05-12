package co.edu.unbosque.controller;

import co.edu.unbosque.entidades.Parrillaprogramacion;
import co.edu.unbosque.service.EmisoraService;
import co.edu.unbosque.service.ParrillaService;
import co.edu.unbosque.service.PistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ParrillaController {

    @Autowired
    private ParrillaService parrillaService;

    @Autowired
    private EmisoraService emisoraService;

    @Autowired
    private PistaService pistaService;

    @GetMapping("/pa/crear")
    public String index(Model model) {
        model.addAttribute("parrilla", new Parrillaprogramacion());
        model.addAttribute("listaEmisoras", emisoraService.listaEmisoras());
        model.addAttribute("listaPistas", pistaService.listaPistas());
        return "/parrilla/crear";
    }

    @PostMapping("/pa/guardar")
    public String guardarParrilla(@ModelAttribute("parrilla") Parrillaprogramacion parrillaprogramacion) {
        parrillaService.crearParrilla(parrillaprogramacion);
        return "redirect:/parrilla/list";
    }

    @PostMapping("/pa/editar/{id}")
    public String actualizarParrilla(@PathVariable Integer id, @ModelAttribute("parrilla") Parrillaprogramacion parrillaprogramacion) {
        parrillaService.actualizarParrilla(id, parrillaprogramacion);
        return "redirect:/parrilla/list";
    }

    @GetMapping("/pa/eliminar/{id}")
    public String eliminarParrilla(@PathVariable Integer id) {
        parrillaService.eliminarId(id);
        return "redirect:/parrilla/list";
    }

    @GetMapping("/parrilla/list")
    public String listaParrilla(Model model) {
        model.addAttribute("listaparrillas", parrillaService.listaParrilla());
        return "parrilla/list";
    }

    @GetMapping("/pa/buscar/{id}")
    public String buscarParrilla(@PathVariable Integer id, Model model) {
        model.addAttribute("parrilla", parrillaService.parrillaId(id).get());
        model.addAttribute("listaEmisoras", emisoraService.listaEmisoras());
        model.addAttribute("listaPistas", pistaService.listaPistas());
        return "parrilla/editar";
    }

}
