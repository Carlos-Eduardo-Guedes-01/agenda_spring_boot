package com.evento.eventoapp.editaController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.evento.eventoapp.models.Eventos;
import com.evento.eventoapp.repositorys.EventoRepository;

import java.util.Optional;

@Controller
public class EditaController {
    @Autowired
    private EventoRepository eventRepository;

    @PostMapping("/edita/{id}")
    public String atualizaEvento(@PathVariable Long id,
            @RequestParam String local,
            @RequestParam String data,
            @RequestParam String horario,
            @RequestParam String nome,
            Model model, RedirectAttributes redirectAttributes) {
        Optional<Eventos> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            // Evento encontrado, vamos atualizar os campos
            Eventos event = optionalEvent.get();
            event.setNome(nome);
            event.setLocal(local);
            event.setLocal(local);
            event.setData(data);
            event.setHorario(horario);
            eventRepository.save(event);
            redirectAttributes.addFlashAttribute("altera", event.getNome());
            model.addAttribute("evento", event);
            return "redirect:/";
        }
        return "/";
    }
}