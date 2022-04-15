import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CrudService } from '../services/crud.service';
import { Pagina } from '../usuario/model/pagina';
import { UsuarioListagem } from '../usuario/model/usuario-listagem';


@Component({
  selector: 'app-pesquisa-usuarios',
  templateUrl: './pesquisa-usuarios.component.html',
  styleUrls: ['./pesquisa-usuarios.component.scss']
})
export class PesquisaUsuariosComponent implements OnInit {
   
  paginaUsuarios: Pagina = new Pagina();
  totalPaginasUsuarios: number = 0;
  ultimaPagina: boolean = false;
  numeroDapaginaUsuarios: number = 0;
  usuarios: UsuarioListagem[] = [];
  indice: number[] = [];
  filtro: string = "";


  constructor(
    private usuarioService : CrudService,
    private router : Router,
    private route: ActivatedRoute
  ){
     this.filtro = this.route.snapshot.params['pesquisa'];

    this.usuarioService.listarUsuariosPaginadosFiltro(this.filtro, 0)
      .subscribe((resp : Pagina) =>{

        this.paginaUsuarios = resp
        this.totalPaginasUsuarios = resp.totalPages
        this.ultimaPagina = resp.last
        this.numeroDapaginaUsuarios = resp.number
        this.usuarios = resp.content
     
        for(let i = 1; i <= this.totalPaginasUsuarios; i++){
          this.indice.push(i)
        }
      })

  }

  ngOnInit(): void {
  }

  pesquisar(filtro : string){

    this.usuarioService.listarUsuariosPaginadosFiltro(filtro, 0)
    .subscribe((resp : Pagina) =>{

      this.paginaUsuarios = resp
      this.totalPaginasUsuarios = resp.totalPages

      this.usuarios = resp.content

      this.indice = []

      for(let i = 1; i <= this.totalPaginasUsuarios ; i++){
        this.indice.push(i)
      }

      console.log(this.indice)
    })
}

trocarPagina(pagina: number){

  this.usuarioService.listarUsuariosPaginadosFiltro(this.filtro, pagina - 1)
  .subscribe((resp : Pagina) =>{

    this.paginaUsuarios = resp
    this.totalPaginasUsuarios = resp.totalPages

    this.usuarios = resp.content

  })
}

}
