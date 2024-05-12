package co.edu.unbosque.controller;

import co.edu.unbosque.entidades.Pistamusical;
import co.edu.unbosque.service.PistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PistaController {

    @Autowired
    private PistaService pistaService;

    @GetMapping("/pi/crear")
    public String index(Model model) {
        model.addAttribute("pista", new Pistamusical());
        return "/pista/crear";
    }

    @PostMapping("/pi/guardar")
    public String guardarPista(@ModelAttribute("pista") Pistamusical pistamusical,
                               @RequestParam("archivo") MultipartFile archivo) {

        pistaService.crearPista(pistamusical, archivo);
        return "redirect:/pista/list";
    }

    @PostMapping("/pi/editar/{id}")
    public String atualizarPista(@PathVariable Integer id, @ModelAttribute("pista") Pistamusical pistamusical) {
        pistaService.actualizarPista(id, pistamusical);
        return "redirect:/pista/list";
    }

    @GetMapping("/pi/eliminar/{id}")
    public String eliminarPista(@PathVariable Integer id) {
        pistaService.eliminarId(id);
        return "redirect:/pista/list";
    }

    @GetMapping("/pista/list")
    public String listaPistas(Model model) {
        model.addAttribute("listapistas", pistaService.listaPistas());
        return "pista/list";
    }

    @GetMapping("/pi/buscar/{id}")
    public String buscarPista(@PathVariable Integer id, Model model) {
        model.addAttribute("pista", pistaService.pistasId(id).get());
        return "pista/editar";
    }
}
