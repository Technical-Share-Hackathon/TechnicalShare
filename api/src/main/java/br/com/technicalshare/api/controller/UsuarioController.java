package br.com.technicalshare.api.controller;

import br.com.technicalshare.api.controller.dto.UsuarioDetalhadoDto;
import br.com.technicalshare.api.controller.dto.UsuarioDtoSimples;
import br.com.technicalshare.api.controller.form.UsuarioFormLogin;
import br.com.technicalshare.api.exception.EmailNaoExistenteException;
import br.com.technicalshare.api.exception.SenhaInvalidaException;
import br.com.technicalshare.api.models.Usuario;
import br.com.technicalshare.api.repository.UsuarioRepository;
import br.com.technicalshare.api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AuthService authService;

    @GetMapping
    public ResponseEntity<List<UsuarioDtoSimples>> listaTodosOsUsuarios(){
        List<Usuario> listaDeUsuarios = usuarioRepository.findAll();

        List<UsuarioDtoSimples> usuarioDtoSimples = listaDeUsuarios.stream()
                .map(usuario -> new UsuarioDtoSimples(usuario))
                .collect(Collectors.toList());

        return ResponseEntity.ok(usuarioDtoSimples);
    }

    @PostMapping("/logar")
    public ResponseEntity<UsuarioDetalhadoDto> logar(@RequestBody UsuarioFormLogin usuarioFormLogin){
        Optional<Usuario> usuario = usuarioRepository.findByEmail(usuarioFormLogin.getEmail());

        if (usuario.isEmpty()){
            throw new EmailNaoExistenteException("Email incorreto");
        }

        if(!authService.validarSenha(usuario.get(), usuarioFormLogin.getSenha())){
            throw new SenhaInvalidaException("Senha incorreta");
        };

        return ResponseEntity.ok(new UsuarioDetalhadoDto(usuario.get()));
    }
}
