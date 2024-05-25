package com.evento.eventoapp.formEventoController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.evento.eventoapp.models.Eventos;

@Controller
public class FormEvento {

    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping("/CadEvento")
    public String formEvento(Model model) {
        model.addAttribute("dataAtual", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        return "evento/formEvento";
    }

    @PostMapping("/salvar")
    public String salvar(@RequestParam String nome, @RequestParam String local, @RequestParam String data,
            @RequestParam String horario, RedirectAttributes redirectAttributes) {
        try {
            Date dataEvento = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            Date dataAtual = new Date();

            if (dataEvento.before(dataAtual)) {
                redirectAttributes.addFlashAttribute("error", "A data do evento não pode ser uma data que já passou.");
                return "redirect:/CadEvento";
            }

            Eventos evento = new Eventos(nome, local, data, horario);
            eventoRepository.save(evento);
            redirectAttributes.addFlashAttribute("adiciona", evento.getNome());
            return "redirect:/";
        } catch (ParseException e) {
            redirectAttributes.addFlashAttribute("error", "Formato de data inválido.");
            return "redirect:/CadEvento";
        }
    }
}