import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CrudService } from '../services/crud.service';
import { Pagina } from '../usuario/model/pagina';
import { UsuarioListagem } from '../usuario/model/usuario-listagem';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  usuariosSugeridos : UsuarioListagem[] = []

  paginaUsuariosSugeridos : Pagina = new Pagina
  totalPaginasUsuariosSugeridos : number = 0
  numeroDaPaginaSugeridos : number = 0;
  ultimaPaginaSugeridos : boolean = false

  interesseAtual : string ="";


  interesses : string[] = [
    "figma",
    "java",
    "typescrip",
    "angular",
    "Docker"
  ]

  usuariosSugeridosPorProfissao: UsuarioListagem[] = []
  paginaUsuariosPorProfissao : Pagina = new Pagina
  totalPaginasUsuariosPorProfissao: number = 0
  ultimaPaginaProfissao: boolean = false
  numeroDapaginaUsuariosProfissao : number = 0

  profissao : string = "UX"

  buscaDoUsuario: string = ""

  constructor(
    private usuarioService: CrudService,
    private router : Router
  ) {

      this.usuarioService.listarUsuariosPaginadosPorQualquerFiltro(this.profissao, 0)
      .subscribe((resp : Pagina) =>{

        this.paginaUsuariosPorProfissao = resp
        this.totalPaginasUsuariosPorProfissao = resp.totalPages
        this.ultimaPaginaProfissao = resp.last
        this.numeroDapaginaUsuariosProfissao = resp.number

        this.usuariosSugeridosPorProfissao = resp.content

      })

  }

  ngOnInit(): void {

  }

  pesquisarUsuariosSugeridos(interesse : string){
    this.interesseAtual = interesse;
    this.usuarioService.listarUsuariosPorInteresse(interesse, 0)
    .subscribe((resp : Pagina)=>{

      this.paginaUsuariosSugeridos = resp
      this.numeroDaPaginaSugeridos = resp.number
      this.totalPaginasUsuariosSugeridos = resp.totalPages
      this.ultimaPaginaSugeridos = resp.last

      this.usuariosSugeridos = resp.content

    })
  }

  retrocederPagina(interesseAtual: string){

    if(this.numeroDaPaginaSugeridos !== 0){
      this.numeroDaPaginaSugeridos -= 1
    }

    this.usuarioService.listarUsuariosPorInteresse(interesseAtual, this.numeroDaPaginaSugeridos)
    .subscribe((resp : Pagina) =>{

      this.paginaUsuariosSugeridos = resp
      this.numeroDaPaginaSugeridos = resp.number

      this.usuariosSugeridos = resp.content
    })
  }

  avancarPagina(interesseAtual: string){

    if(this.ultimaPaginaSugeridos === true){
      this.numeroDaPaginaSugeridos = this.numeroDaPaginaSugeridos
    }else{
      this.numeroDaPaginaSugeridos += 1
    }

    this.usuarioService.listarUsuariosPorInteresse(interesseAtual, this.numeroDaPaginaSugeridos)
    .subscribe((resp : Pagina) =>{

      this.paginaUsuariosSugeridos = resp
      this.numeroDaPaginaSugeridos = resp.number
      this.ultimaPaginaSugeridos = resp.last

      this.usuariosSugeridos = resp.content

    })
  }

  avancarPaginaProfissao(){

    if(this.ultimaPaginaProfissao === true){
      this.numeroDapaginaUsuariosProfissao = this.numeroDapaginaUsuariosProfissao
    }else{
      this.numeroDapaginaUsuariosProfissao += 1
    }

    this.usuarioService.listarUsuariosPaginadosPorQualquerFiltro(this.profissao, this.numeroDapaginaUsuariosProfissao)
    .subscribe((resp : Pagina) =>{

      this.paginaUsuariosPorProfissao = resp
      this.numeroDapaginaUsuariosProfissao = resp.number
      this.ultimaPaginaProfissao = resp.last

      this.usuariosSugeridosPorProfissao = resp.content

      console.log(this.numeroDapaginaUsuariosProfissao)
    })
  }

  retrocederPaginaProfissao(){

    if(this.numeroDapaginaUsuariosProfissao !== 0){
      this.numeroDapaginaUsuariosProfissao -= 1
    }

    this.usuarioService.listarUsuariosPaginadosPorQualquerFiltro(this.profissao,
      this.numeroDapaginaUsuariosProfissao)
    .subscribe((resp : Pagina) =>{

      this.paginaUsuariosPorProfissao = resp
      this.numeroDapaginaUsuariosProfissao = resp.number

      this.usuariosSugeridosPorProfissao = resp.content
    })
  } 

  pesquisar(){
    this.router.navigate(['pesquisar', this.buscaDoUsuario]);
  }

}