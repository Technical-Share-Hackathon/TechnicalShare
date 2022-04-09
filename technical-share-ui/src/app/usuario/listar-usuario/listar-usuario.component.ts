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

  usuariosSugeridos : UsuarioListagem[] = []

  paginaUsuariosSugeridos : Pagina = new Pagina
  totalPaginasUsuariosSugeridos : number = 0
  interesses : string[] = ["backend", "java", "typescrip","angular", "Docker"]
  indicePaginasSugeridos: number[] = []

  interesseAtual : string ="";



  usuariosPesquisados : UsuarioListagem[] = []
  paginaUsuariosPesquisados : Pagina = new Pagina
  totalPaginasUsuariosPesquisados : number = 0
  indicePaginasPesquisados: number[] = []

  filtro : string = ""

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

      this.paginaUsuariosSugeridos = resp
      this.totalPaginasUsuariosSugeridos = resp.totalPages

      this.usuariosSugeridos = resp.content

      this.indicePaginasSugeridos = []

      for(let i = 1; i <= this.totalPaginasUsuariosSugeridos ; i++){
        this.indicePaginasSugeridos.push(i)
      }
    })
  }

  trocarPagina(interesseAtual: string, pagina : number){
    this.usuarioService.listarUsuariosPorInteresse(interesseAtual, pagina - 1)
    .subscribe((resp : Pagina) =>{

      this.paginaUsuariosSugeridos = resp
      this.totalPaginasUsuariosSugeridos = resp.totalPages

      this.usuariosSugeridos = resp.content

    })
  }

  pesquisar( filtro: string ){
    this.usuarioService.listarUsuariosPaginadosPorQualquerFiltro(filtro, 0)
    .subscribe((resp : Pagina) =>{

      this.paginaUsuariosPesquisados = resp
      this.totalPaginasUsuariosPesquisados = resp.totalPages

      this.usuariosPesquisados = resp.content

      this.indicePaginasPesquisados = []

      for(let i = 1; i <= this.totalPaginasUsuariosPesquisados ; i++){
        this.indicePaginasPesquisados.push(i)
      }

    })
  }

  trocarPaginaPesquisa(interesseAtual: string, pagina : number){
    this.usuarioService.listarUsuariosPorInteresse(interesseAtual, pagina - 1)
    .subscribe((resp : Pagina) =>{

      this.paginaUsuariosPesquisados = resp
      this.totalPaginasUsuariosPesquisados = resp.totalPages

      this.usuariosPesquisados = resp.content

    })
  }


}
