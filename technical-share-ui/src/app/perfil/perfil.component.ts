import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CrudService } from '../services/crud.service';
import { Experiencias } from '../usuario/model/experiencias';
import { UsuarioCompleto } from '../usuario/model/usuario-completo';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.scss']
})
export class PerfilComponent implements OnInit {

  usuarioCompleto : UsuarioCompleto = new UsuarioCompleto;

  interessesFiltrados : string[] = []

  hardSkillsFiltrados : string[] = []

  softSkillsFiltrados : string[] = []

  experiencias: Experiencias[] = []

  constructor( 
    private usuarioService : CrudService,
    private router : Router,
    private route: ActivatedRoute
  ){
    let idRotaAtiva = this.route.snapshot.params['id'];

    usuarioService.buscarUsuario(idRotaAtiva).subscribe((resp : UsuarioCompleto)=>{

      this.usuarioCompleto = resp

      this.experiencias = resp.experiencias

      this.interessesFiltrados =  Object.values(this.usuarioCompleto.areaDeInteresse)
      .filter(prop => prop != null && prop != "" &&  typeof prop !== "number" )

      this.hardSkillsFiltrados =  Object.values(this.usuarioCompleto.hardSkills)
      .filter(prop => prop != null && prop != "" &&  typeof prop !== "number" )

      this.softSkillsFiltrados =  Object.values(this.usuarioCompleto.softSkills)
      .filter(prop => prop != null && prop != "" &&  typeof prop !== "number" )

     })

    }

  ngOnInit(): void {
  }
  
   redirecionar(){
     window.open(this.usuarioCompleto.linksDisponiveis.linkTeams, '_blank')
   }

   redirecionarWpp(){
    window.open(this.usuarioCompleto.linksDisponiveis.linkWhats, '_blank')
  }

}
