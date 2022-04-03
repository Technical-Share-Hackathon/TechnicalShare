package br.com.technicalshare.api.controller;

import br.com.technicalshare.api.modelos.Usuario;
import br.com.technicalshare.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Usuario>> listaTodosOsUsuarios(){
        List<Usuario> listaDeUsuarios = usuarioRepository.findAll();
        System.out.println(listaDeUsuarios);
        return ResponseEntity.ok(listaDeUsuarios);
    }
}
