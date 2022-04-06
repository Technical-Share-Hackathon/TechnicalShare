import { HardSkills } from './../model/hard-skills';
import { AreasDeInteresse } from './../model/areas-de-interesse';
import { UsuarioService } from './../services/usuario.service';
import { UsuarioCompleto } from './../model/usuario-completo';
import { Component, OnInit } from '@angular/core';


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

  constructor(private usuarioService : UsuarioService) {
    usuarioService.buscarUsuario(1).subscribe((resp : UsuarioCompleto)=>{
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
