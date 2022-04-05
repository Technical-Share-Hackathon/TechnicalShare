import { UsuarioService } from './../services/usuario.service';
import { UsuarioListagem } from './../model/usuario-listagem';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-listar-usuario',
  templateUrl: './listar-usuario.component.html',
  styleUrls: ['./listar-usuario.component.scss']
})
export class ListarUsuarioComponent implements OnInit {

  usuarios : UsuarioListagem[] = []

  constructor(private usuarioService: UsuarioService) {
    
    usuarioService.listar().subscribe((resp : UsuarioListagem[]) =>{
      this.usuarios = resp
    })
  }

  ngOnInit(): void {
  }

}
