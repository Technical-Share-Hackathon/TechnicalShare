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

  interesseAtual : string ="";

  interesses : string[] = ["backend", "java", "typescrip","angular", "Docker"]

  indicePaginas: number[] = []

  constructor(
    private usuarioService: UsuarioService,
    private router : Router
  ) {



  }



  ngOnInit(): void {

  }

  pesquisarUsuariosSugerdos(interesse : string){
    this.interesseAtual = interesse;
    this.usuarioService.listarUsuariosPorInteresse(interesse, 0)
    .subscribe((resp : Pagina)=>{

      this.pagina = resp
      this.totalPaginas = resp.totalPages

      this.usuarios = resp.content

      this.indicePaginas = []

      for(let i = 1; i <= this.totalPaginas ; i++){
        this.indicePaginas.push(i)
      }
    })
  }

  trocarPagina(interesseAtual: string, pagina : number){
    this.usuarioService.listarUsuariosPorInteresse(interesseAtual, pagina - 1)
    .subscribe((resp : Pagina) =>{

      this.pagina = resp
      this.totalPaginas = resp.totalPages

      this.usuarios = resp.content

    })
  }


}
