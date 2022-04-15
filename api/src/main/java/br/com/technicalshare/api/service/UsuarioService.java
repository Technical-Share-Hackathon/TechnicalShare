package br.com.technicalshare.api.service;

import br.com.technicalshare.api.controller.form.UsuarioFormAtualizacao;
import br.com.technicalshare.api.models.Usuario;
import br.com.technicalshare.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario atualizarDados(Usuario usuario, UsuarioFormAtualizacao userForm) {

        usuario = userForm.converterParaEntidade(usuario);

        return this.usuarioRepository.save(usuario);
    }
}
