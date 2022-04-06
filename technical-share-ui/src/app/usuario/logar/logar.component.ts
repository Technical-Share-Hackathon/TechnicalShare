import { UsuarioLogin } from './../model/usuario-login';
import { UsuarioCompleto } from './../model/usuario-completo';
import { UsuarioService } from './../services/usuario.service';
import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logar',
  templateUrl: './logar.component.html',
  styleUrls: ['./logar.component.scss']
})
export class LogarComponent implements OnInit {

  usuarioCompleto: UsuarioCompleto = new UsuarioCompleto;
  usuarioLogin : UsuarioLogin = new UsuarioLogin;

  constructor(
    private usuarioService : UsuarioService,
    private router : Router
  ) {

  }

  ngOnInit(): void {
  }

  logar(){
      this.usuarioService.logar(this.usuarioLogin).subscribe((resp: UsuarioCompleto) =>{
        this.usuarioCompleto = resp;

        environment.idUsuarioLogado = this.usuarioCompleto.id
        environment.nomeUsuarioLogado = this.usuarioCompleto.nome
        environment.linkFotoUsuarioLogado = this.usuarioCompleto.linkFoto
        environment.profissaoAtualUsuarioLogado = this.usuarioCompleto.profissaoAtual
        environment.emailUsuarioLogado = this.usuarioCompleto.email
        environment.resumoUsuarioLogado = this.usuarioCompleto.resumo

        environment.idLinksDoUsuarioLogado = this.usuarioCompleto.linksDisponiveis.idLinks
        environment.linkWhatsUsuarioLogado = this.usuarioCompleto.linksDisponiveis.linkWhats
        environment.linkTeamsUsuarioLogado = this.usuarioCompleto.linksDisponiveis.linkTeams

        environment.idAreasDeInteresseDoUsuarioLogado = this.usuarioCompleto.areaDeInteresse.idInteresses
        environment.primeiraAreaDeInteresseDoUsuarioLogado = this.usuarioCompleto.areaDeInteresse.primeiraAreaDeInteresse
        environment.segundaAreaDeInteresseDoUsuarioLogado = this.usuarioCompleto.areaDeInteresse.segundaAreaDeInteresse
        environment.terceiraAreaDeInteresseDoUsuarioLogado = this.usuarioCompleto.areaDeInteresse.terceiraAreaDeInteresse
        environment.quartaAreaDeInteresseDoUsuarioLogado = this.usuarioCompleto.areaDeInteresse.quartaAreaDeInteresse
        environment.quintaAreaDeInteresseDoUsuarioLogado = this.usuarioCompleto.areaDeInteresse.quintaAreaDeInteresse

        environment.idSofSkillsDoUsuarioLogado = this.usuarioCompleto.softSkills.idSoftSkills
        environment.primeiraSoftSkillDoUsuarioLogado = this.usuarioCompleto.softSkills.primeiraSoftSkill
        environment.segundaSoftSkillDoUsuarioLogado = this.usuarioCompleto.softSkills.segundaSoftSkill
        environment.terceiraSoftSkillDoUsuarioLogado = this.usuarioCompleto.softSkills.terceiraSoftSkill
        environment.quartaSoftSkillDoUsuarioLogado = this.usuarioCompleto.softSkills.quartaSoftSkill
        environment.quintaSoftSkillDoUsuarioLogado = this.usuarioCompleto.softSkills.quintaSoftSkill

        environment.idHardSkillsUsuarioLogado = this.usuarioCompleto.hardSkills.idHardSkills
        environment.primeiraHardSkillDoUsuarioLogado = this.usuarioCompleto.hardSkills.primeiraHardSkill
        environment.segundaHardSkillDoUsuarioLogado = this.usuarioCompleto.hardSkills.segundaHardSkill
        environment.terceiraHardSkillDoUsuarioLogado = this.usuarioCompleto.hardSkills.terceiraHardSkill
        environment.quartaHardSkillDoUsuarioLogado = this.usuarioCompleto.hardSkills.quartaHardSkill
        environment.quintaHardSkillDoUsuarioLogado = this.usuarioCompleto.hardSkills.quintaHardSkill

        this.router.navigate(['usuarios/perfil']);

    }, erro =>{
       console.log(erro)
    })
  }

}
