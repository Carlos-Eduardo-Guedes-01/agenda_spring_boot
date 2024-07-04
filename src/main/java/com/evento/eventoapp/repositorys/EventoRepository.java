package com.evento.eventoapp.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evento.eventoapp.models.Eventos;

public interface EventoRepository extends JpaRepository<Eventos, Long> {

    // Você pode adicionar métodos de consulta personalizados aqui, se necessário
}
