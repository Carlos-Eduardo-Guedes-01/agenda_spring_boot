package com.evento.eventoapp.detailsController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.evento.eventoapp.formEventoController.EventoRepository;
import com.evento.eventoapp.models.Eventos;

@Controller
public class DetailsController {

    @Autowired
    private EventoRepository eventRepository;

    @GetMapping("/details/{id}")
    public String detalhaEvento(@PathVariable Long id, Model model) {
        Optional<Eventos> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            Eventos event = optionalEvent.get();
            model.addAttribute("evento", event);
            return "details/details";
        } else {
            return "redirect: /error";
        }
    }
}