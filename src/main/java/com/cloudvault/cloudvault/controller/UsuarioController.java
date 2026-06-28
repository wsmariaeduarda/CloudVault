package com.cloudvault.cloudvault.controller;

import com.cloudvault.cloudvault.model.Usuario;
import com.cloudvault.cloudvault.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String salvar(Usuario usuario) {
        usuarioService.salvar(usuario);
        return "redirect:/login";
    }

   @PostMapping("/login")
        public String login(Usuario usuario) {
        Usuario encontrado = usuarioService.buscarPorEmail(usuario.getEmail());
         if (encontrado != null && encontrado.getSenha().equals(usuario.getSenha())) {
        return "redirect:/home";
    }
    return "redirect:/login";
    }
}