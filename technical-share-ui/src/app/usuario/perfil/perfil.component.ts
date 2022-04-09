
import { UsuarioService } from './../services/usuario.service';
import { UsuarioCompleto } from './../model/usuario-completo';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';


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


  constructor(
    private usuarioService : UsuarioService,
    private router : Router,
    private route: ActivatedRoute

  ) {

    let idRotaAtiva = this.route.snapshot.params['id'];

    usuarioService.buscarUsuario(idRotaAtiva).subscribe((resp : UsuarioCompleto)=>{

      this.usuarioCompleto = resp

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


}
