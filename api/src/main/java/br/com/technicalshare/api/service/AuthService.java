package br.com.technicalshare.api.service;

import br.com.technicalshare.api.models.Usuario;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public boolean validarSenha(Usuario usuario, String senha) {
        if(usuario.getSenha().equals(senha)){
            return true;
        }
        return false;
    }
}
