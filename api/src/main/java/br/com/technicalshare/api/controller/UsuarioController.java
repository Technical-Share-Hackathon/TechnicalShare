package br.com.technicalshare.api.controller;

import br.com.technicalshare.api.controller.dto.UsuarioDetalhadoDto;
import br.com.technicalshare.api.controller.dto.UsuarioDtoSimples;
import br.com.technicalshare.api.exception.SemPermissaoException;
import br.com.technicalshare.api.controller.form.UsuarioFormAtualizacao;
import br.com.technicalshare.api.controller.form.UsuarioFormLogin;
import br.com.technicalshare.api.exception.EmailNaoExistenteException;
import br.com.technicalshare.api.exception.SenhaInvalidaException;
import br.com.technicalshare.api.exception.UsuarioNaoExistenteException;
import br.com.technicalshare.api.models.Usuario;
import br.com.technicalshare.api.repository.InteressesRepository;
import br.com.technicalshare.api.repository.UsuarioRepository;
import br.com.technicalshare.api.service.AuthService;
import br.com.technicalshare.api.service.UsuarioService;
import br.com.technicalshare.api.specification.SpecificationInteresse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private InteressesRepository interessesRepository;

    @GetMapping
    public ResponseEntity<List<UsuarioDtoSimples>> listarTodosOsUsuarios(){
        List<Usuario> listaDeUsuarios = usuarioRepository.findAll();

        List<UsuarioDtoSimples> usuarioDtoSimples = listaDeUsuarios.stream()
                .map(usuario -> new UsuarioDtoSimples(usuario))
                .collect(Collectors.toList());

        return ResponseEntity.ok(usuarioDtoSimples);
    }

    @GetMapping("/sugerir/{interesse}")
    public ResponseEntity<List<UsuarioDtoSimples>> listarUsuariosSugeridos(@PathVariable String interesse){

        List<Usuario> usuariosRecomendadosPorInteresse = usuarioRepository.findAll(Specification.where(
                SpecificationInteresse.primeiroInteresse(interesse)
                        .or(SpecificationInteresse.segundoInteresse(interesse))
                        .or(SpecificationInteresse.terceiraInteresse(interesse))
                        .or(SpecificationInteresse.quartoInteresse(interesse))
                        .or(SpecificationInteresse.quintoInteresse(interesse))
        ));

        List<UsuarioDtoSimples> usuarioDtoSimples = usuariosRecomendadosPorInteresse.stream().map(
                usuario -> new UsuarioDtoSimples(usuario)).limit(3).collect(Collectors.toList());

        return ResponseEntity.ok(usuarioDtoSimples);
    }


    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioDetalhadoDto> listarUsuario(@PathVariable Long idUsuario){
        Optional<Usuario> usuario = this.usuarioRepository.findById(idUsuario);

       if(usuario.isEmpty()){
           return ResponseEntity.notFound().build();
       }

       return ResponseEntity.ok(new UsuarioDetalhadoDto(usuario.get()));
    }

    @PostMapping("/logar")
    public ResponseEntity<UsuarioDetalhadoDto> logar(@RequestBody UsuarioFormLogin usuarioFormLogin){
        Optional<Usuario> usuario = this.usuarioRepository.findByEmail(usuarioFormLogin.getEmail());

        if (usuario.isEmpty()){
            throw new EmailNaoExistenteException("Email incorreto");
        }

        if(!this.authService.validarSenha(usuario.get(), usuarioFormLogin.getSenha())){
            throw new SenhaInvalidaException("Senha incorreta");
        };

        return ResponseEntity.ok(new UsuarioDetalhadoDto(usuario.get()));
    }

    @PutMapping("/atualizar/{idUsuario}")
    public ResponseEntity<UsuarioDetalhadoDto> atualizarUsuario(@PathVariable Long idUsuario,
                                                                @RequestBody UsuarioFormAtualizacao userForm){

        Optional<Usuario> usuario = this.usuarioRepository.findById(idUsuario);

        if(usuario.isEmpty()){
            throw new UsuarioNaoExistenteException("Usuário não existe no sistema");
        }

        if(idUsuario != userForm.getId()){
            throw new SemPermissaoException("Você não pode fazer isso");
        }

        Usuario usuarioAtualizado = this.usuarioService.atualizarDados(usuario.get(), userForm);

        return ResponseEntity.ok(new UsuarioDetalhadoDto(usuarioAtualizado));
    }
}
