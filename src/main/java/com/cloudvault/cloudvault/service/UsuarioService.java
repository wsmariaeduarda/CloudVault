package com.cloudvault.cloudvault.service;

import com.cloudvault.cloudvault.model.Usuario;
import com.cloudvault.cloudvault.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void salvar (Usuario usuario) {
        usuarioRepository.save(usuario);
    }
    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}
