package com.evento.eventoapp.cadidaturaController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.evento.eventoapp.models.Eventos;
import com.evento.eventoapp.models.Usuarios;
import com.evento.eventoapp.repositorys.EventoRepository;
import com.evento.eventoapp.repositorys.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class CandidaturaController {

    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private UsuariosRepository userRepository;

    @GetMapping("/candidatura")
    public String mostraEventos(Model model) {
        Iterable<Eventos> eventos = eventoRepository.findAll();
        model.addAttribute("eventos", eventos);
        return "candidatar/candidatura";
    }

    @PostMapping("/candidatar")
    public String candidatura(@Validated @RequestParam String nome, @RequestParam String email,
            @RequestParam String dataNascimento, @RequestParam String senha, @RequestParam Long id, Model model) {

        try {
            Usuarios user = new Usuarios(nome, email, senha, dataNascimento);
            model.addAttribute("Usuario", user);

            return "redirect:/";
        } catch (Exception e) {
            return "redirect:/candidatura";
        }
    }

}
