package com.evento.eventoapp.deleteController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import com.evento.eventoapp.formEventoController.EventoRepository;
import com.evento.eventoapp.models.Eventos;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DeleteController {
    @Autowired
    private EventoRepository eventRepository;

    @GetMapping("/evento/{id}")
    public String deletar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        Optional<Eventos> eventoOptional = eventRepository.findById(id);
        if (eventoOptional.isPresent()) {
            Eventos event = eventoOptional.get();
            try {
                eventRepository.delete(event);
                redirectAttributes.addFlashAttribute("remove", event.getNome());
                return "redirect:/";
            } catch (Exception e) {
                // Se ocorrer um erro durante a deleção, retorna uma mensagem de erro
                String mensagem = "Não foi possível remover o evento, tente novamente!";
                redirectAttributes.addFlashAttribute("mensagem", mensagem);
                return "redirect:/";
            }

        }
        return "redirect:/";
    }
}
