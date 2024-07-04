package com.evento.eventoapp.indexControlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.evento.eventoapp.models.Eventos;
import com.evento.eventoapp.repositorys.EventoRepository;

import org.springframework.ui.Model;

@Controller
public class IndexController {

    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Eventos> eventos = eventoRepository.findAll();
        model.addAttribute("eventos", eventos);
        // model.addAttribute("eventos", events);
        return "index/index";
    }
}
