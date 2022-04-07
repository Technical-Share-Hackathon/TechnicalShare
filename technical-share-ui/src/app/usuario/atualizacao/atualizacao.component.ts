import { UsuarioCompleto } from './../model/usuario-completo';
import { UsuarioService } from './../services/usuario.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-atualizacao',
  templateUrl: './atualizacao.component.html',
  styleUrls: ['./atualizacao.component.scss']
})
export class AtualizacaoComponent implements OnInit {

  usuarioCompleto : UsuarioCompleto = new UsuarioCompleto;

  interessesFiltrados : string[] = []

  hardSkillsFiltrados : string[] = []

  softSkillsFiltrados : string[] = []

  constructor(
    private usuarioService : UsuarioService,
    private route: ActivatedRoute
  ) {
    
    let idRotaAtiva = this.route.snapshot.params['id'];

    this.usuarioService.buscarUsuario(idRotaAtiva).subscribe((resp: UsuarioCompleto)=>{
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
