package br.com.technicalshare.api.controller;

import br.com.technicalshare.api.controller.dto.UsuarioDtoSimples;
import br.com.technicalshare.api.modelos.Usuario;
import br.com.technicalshare.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<UsuarioDtoSimples>> listaTodosOsUsuarios(){
        List<Usuario> listaDeUsuarios = usuarioRepository.findAll();

        List<UsuarioDtoSimples> usuarioDtoSimples = listaDeUsuarios.stream()
                .map(usuario -> new UsuarioDtoSimples(usuario))
                .collect(Collectors.toList());

        return ResponseEntity.ok(usuarioDtoSimples);
    }
}
