package com.evento.eventoapp.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evento.eventoapp.models.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

    // Você pode adicionar métodos de consulta personalizados aqui, se necessário
}
