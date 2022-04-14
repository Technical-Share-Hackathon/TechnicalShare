package br.com.technicalshare.api.service;

import br.com.technicalshare.api.models.Usuario;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest
public class AuthServiceTest {

    Usuario usuarioMock;

    @Autowired
    AuthService authService;

    @BeforeEach
    public void setUp(){
        usuarioMock = new Usuario();
        usuarioMock.setSenha("senhaTeste");
    }

    @Test
    @DisplayName("Deve retornar falso ao validar uma senha incorreta")
    public void deveValidarSenhaInsucesso(){
        Assertions.assertThat(!authService.validarSenha(usuarioMock, "senhaDiferente"));
    }

    @Test
    @DisplayName("Deve retornar true ao validar uma senha correta")
    public void deveValidarSenhaSucesso(){
        Assertions.assertThat(!authService.validarSenha(usuarioMock, "senhaTeste"));
    }
}
