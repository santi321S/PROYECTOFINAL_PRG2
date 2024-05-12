package co.edu.unbosque.controller;

import co.edu.unbosque.entidades.Emisora;
import co.edu.unbosque.service.EmisoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmisoraController {

    @Autowired
    private EmisoraService emisoraService;

    @GetMapping("/em/crear")
    public String index(Model model) {
        model.addAttribute("emisora", new Emisora());
        return "/emisora/crear";
    }

    @PostMapping("/em/guardar")
    public String guardarEmisora(@ModelAttribute("emisora") Emisora emisora) {
        emisoraService.crearEmisora(emisora);
        return "redirect:/emisora/list";
    }

    @PostMapping("/em/editar/{id}")
    public String actualizarEmisora(@PathVariable Integer id, @ModelAttribute("emisora") Emisora emisora) {
        emisoraService.actualizarEmisora(id, emisora);
        return "redirect:/emisora/list";
    }

    @GetMapping("/em/eliminar/{id}")
    public String eliminarEmisora(@PathVariable Integer id) {
        emisoraService.eliminarId(id);
        return "redirect:/emisora/list";
    }

    @GetMapping("/emisora/list")
    public String listaEmisora(Model model) {
        model.addAttribute("listaemisoras", emisoraService.listaEmisoras());
        return "emisora/list";
    }

    @GetMapping("/em/buscar/{id}")
    public String buscarEmisora(@PathVariable Integer id, Model model) {
        model.addAttribute("emisora", emisoraService.emisorasId(id).get());
        return "emisora/editar";
    }
}
