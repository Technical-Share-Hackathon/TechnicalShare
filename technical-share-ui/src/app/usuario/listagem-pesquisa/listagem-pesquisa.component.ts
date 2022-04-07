import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pagina } from '../model/pagina';
import { UsuarioListagem } from '../model/usuario-listagem';
import { UsuarioService } from '../services/usuario.service';

@Component({
  selector: 'app-listagem-pesquisa',
  templateUrl: './listagem-pesquisa.component.html',
  styleUrls: ['./listagem-pesquisa.component.scss']
})
export class ListagemPesquisaComponent implements OnInit {

  usuarios : UsuarioListagem[] = []

  pagina : Pagina = new Pagina
  totalPaginas : number = 0
  indicePaginas: number[] = []

  filtro : string = ""


  constructor(
    private usuarioService: UsuarioService,
    private router : Router
  ) {}

  ngOnInit(): void {

  }

  pesquisar(filtro : string){

      this.usuarioService.listarUsuariosPaginadosPorQualquerFiltro(filtro, 0)
      .subscribe((resp : Pagina) =>{

        this.pagina = resp
        this.totalPaginas = resp.totalPages

        this.usuarios = resp.content

        this.indicePaginas = []

        for(let i = 1; i <= this.totalPaginas ; i++){
          this.indicePaginas.push(i)
        }

        console.log(this.indicePaginas)
      })
  }



  trocarPagina(filtro : string, pagina : number){

    this.usuarioService.listarUsuariosPaginadosPorQualquerFiltro(filtro, pagina - 1)
    .subscribe((resp : Pagina) =>{

      this.pagina = resp
      this.totalPaginas = resp.totalPages

      this.usuarios = resp.content
      
    })
  }

}
