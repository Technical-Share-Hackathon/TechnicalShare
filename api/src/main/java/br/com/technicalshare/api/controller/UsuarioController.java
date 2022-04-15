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
import br.com.technicalshare.api.repository.UsuarioRepository;
import br.com.technicalshare.api.service.AuthService;
import br.com.technicalshare.api.service.UsuarioService;
import br.com.technicalshare.api.specification.SpecificationHard;
import br.com.technicalshare.api.specification.SpecificationSoft;
import br.com.technicalshare.api.specification.SpecificationUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;


import java.util.Optional;


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

    @GetMapping
    public ResponseEntity<Page<UsuarioDtoSimples>> listarTodosOsUsuarios(
            @PageableDefault(sort = "nome", direction = Sort.Direction.ASC,page = 0, size = 4) Pageable paginacao){
        Page<Usuario> listaDeUsuarios = usuarioRepository.findAll(paginacao);

        Page<UsuarioDtoSimples> usuarioDtoSimples = listaDeUsuarios.map(UsuarioDtoSimples::new);

        return ResponseEntity.ok(usuarioDtoSimples);
    }

    @GetMapping("/sugerir/{interesse}")
    public ResponseEntity<Page<UsuarioDtoSimples>> listarUsuariosSugeridos(@PathVariable String interesse,
            @PageableDefault(sort = "nome", direction = Sort.Direction.ASC,page = 0, size = 3) Pageable paginacao){

        Page<Usuario> usuariosRecomendadosPorInteresse = this.usuarioRepository.findAll(Specification.where(
                SpecificationHard.primeiraHard(interesse)
                        .or(SpecificationHard.segundaHard(interesse))
                        .or(SpecificationHard.terceiraHard(interesse))
                        .or(SpecificationHard.quartaHard(interesse))
                        .or(SpecificationHard.quintaHard(interesse))
                        .or(SpecificationSoft.primeiraSoft(interesse))
                        .or(SpecificationSoft.segundaSoft(interesse))
                        .or(SpecificationSoft.terceiraSoft(interesse))
                        .or(SpecificationSoft.quartaSoft(interesse))
                        .or(SpecificationSoft.quintaSoft(interesse))
        ), paginacao);

        Page<UsuarioDtoSimples> usuarioDtoSimples = usuariosRecomendadosPorInteresse.map(UsuarioDtoSimples::new);

        return ResponseEntity.ok(usuarioDtoSimples);
    }


    @GetMapping("/pesquisar/{filtro}")
    public ResponseEntity<Page<UsuarioDtoSimples>> listarUsuariosQualquerFiltro(@PathVariable String filtro,
            @PageableDefault(sort = "nome", direction = Sort.Direction.ASC,page = 0, size = 4) Pageable paginacao){

        Page<Usuario> usuariosPorFiltro = this.usuarioRepository.findAll(
                    Specification.where(SpecificationUsuario.nomeParecidoCom(filtro)
                        .or(SpecificationUsuario.emailParecidoCom(filtro))
                        .or(SpecificationUsuario.profissaoParecidaCom(filtro))
                        .or(SpecificationSoft.primeiraSoft(filtro))
                        .or(SpecificationSoft.segundaSoft(filtro))
                        .or(SpecificationSoft.terceiraSoft(filtro))
                        .or(SpecificationSoft.quartaSoft(filtro))
                        .or(SpecificationSoft.quintaSoft(filtro))
                        .or(SpecificationHard.primeiraHard(filtro))
                        .or(SpecificationHard.segundaHard(filtro))
                        .or(SpecificationHard.terceiraHard(filtro))
                        .or(SpecificationHard.quartaHard(filtro))
                        .or(SpecificationHard.quintaHard(filtro))) , paginacao);

        Page<UsuarioDtoSimples> usuarioDtoSimplesPagina = usuariosPorFiltro.map(UsuarioDtoSimples::new);

        return  ResponseEntity.ok(usuarioDtoSimplesPagina);
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

        if(!this.authService.validarSenha(usuario.get(), usuarioFormLogin.getSenha())) {
            throw new SenhaInvalidaException("Senha incorreta");
        }

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
