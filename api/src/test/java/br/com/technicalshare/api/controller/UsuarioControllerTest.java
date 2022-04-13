package br.com.technicalshare.api.controller;

import br.com.technicalshare.api.models.*;
import br.com.technicalshare.api.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UsuarioControllerTest {

    static String USUARIO_URI = "/api/usuarios";

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UsuarioRepository usuarioRepository;

    Usuario usuarioMock;

    @BeforeEach
    public void setUp(){
        LinksDisponiveis linksMock = new LinksDisponiveis();
        linksMock.setIdLinks(1L);
        linksMock.setLinkTeams("Link teste");
        linksMock.setLinkWhats("Link teste");

        Experiencia experienciaMock = new Experiencia();
        experienciaMock.setIdExperiencia(1L);
        experienciaMock.setInicio(LocalDate.of(2020, 1,22));
        experienciaMock.setTermino(LocalDate.of(2022, 1, 22));
        experienciaMock.setCargo("Desenvolvedor Java");
        experienciaMock.setEmpresa("Fcamara");
        experienciaMock.setDescricao("objeto de teste");


        HardSkills hardSkillsMock = new HardSkills();
        hardSkillsMock.setIdHardSkills(1L);
        hardSkillsMock.setPrimeiraHardSkill("Java");
        hardSkillsMock.setSegundaHardSkill("Spring");
        hardSkillsMock.setTerceiraHardSkill("Docker");
        hardSkillsMock.setQuartaHardSkill("Kubernets");
        hardSkillsMock.setQuintaHardSkill("AWS");

        SoftSkills softSkills= new SoftSkills();
        softSkills.setIdSoftSkills(1L);
        softSkills.setPrimeiraSoftSkill("Persistência");
        softSkills.setSegundaSoftSkill("Inteligência emocional");
        softSkills.setTerceiraSoftSkill("Trabalhar sob pressão");
        softSkills.setQuartaSoftSkill(" ");
        softSkills.setQuintaSoftSkill(" ");

        AreaDeInteresse areaDeInteresseMock = new AreaDeInteresse();
        areaDeInteresseMock.setIdInteresses(1L);
        areaDeInteresseMock.setPrimeiraAreaDeInteresse("Java");
        areaDeInteresseMock.setSegundaAreaDeInteresse("Figma");
        areaDeInteresseMock.setTerceiraAreaDeInteresse("Ux-Design");
        areaDeInteresseMock.setQuartaAreaDeInteresse("Spring");
        areaDeInteresseMock.setQuintaAreaDeInteresse("Docker");


        usuarioMock = new Usuario();

        usuarioMock.setId(1L);
        usuarioMock.setNivelSenioridade("Senior");
        usuarioMock.setResumo("teste");
        usuarioMock.setSquad("Brasil");
        usuarioMock.setEmail("lol@fcamara.com");
        usuarioMock.setSenha("1234");
        usuarioMock.setProfissaoAtual("Desenvolvedor");

        usuarioMock.setAreaDeInteresse(areaDeInteresseMock);
        usuarioMock.setExperiencias(Arrays.asList(experienciaMock));
        usuarioMock.setHardSkills(hardSkillsMock);
        usuarioMock.setSoftSkills(softSkills);

    }

    @Test
    @DisplayName("Request pagina de usuario sem critério")
    public void deveRetornarUmaPaginaDeUsuarios() throws Exception {

        Page<Usuario> paginaUsuarios = new PageImpl<>(Arrays.asList(usuarioMock));

        BDDMockito.given(usuarioRepository.findAll(any(PageRequest.class))).willReturn(paginaUsuarios);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(USUARIO_URI)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("content").isNotEmpty())
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("number").value(0));

    }
}
