import { UsuarioService } from './../services/usuario.service';
import { UsuarioListagem } from './../model/usuario-listagem';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pagina } from '../model/pagina';

@Component({
  selector: 'app-listar-usuario',
  templateUrl: './listar-usuario.component.html',
  styleUrls: ['./listar-usuario.component.scss']
})
export class ListarUsuarioComponent implements OnInit {

  usuarios : UsuarioListagem[] = []

  pagina : Pagina = new Pagina
  totalPaginas : number = 0

  indicePaginas: number[] = []

  constructor(
    private usuarioService: UsuarioService,
    private router : Router
  ) {

    usuarioService.listar(0)
    .subscribe((resp : Pagina) =>{

      this.pagina = resp
      this.totalPaginas = resp.totalPages
  
      this.usuarios = resp.content

      for(let i = 1; i <= this.totalPaginas ; i++){
        this.indicePaginas.push(i)
      }

      console.log(this.indicePaginas)
    })
  }



  ngOnInit(): void {

  }

  trocarPagina(pagina : number){
    this.usuarioService.listar(pagina - 1)
    .subscribe((resp : Pagina) =>{

      this.pagina = resp

      this.usuarios = resp.content

    })
  }


}
