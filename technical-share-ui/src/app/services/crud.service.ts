import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoginUser } from '../usuario/model/login-user'
import { UsuarioCompleto } from '../usuario/model/usuario-completo';
import { first, Observable, tap } from 'rxjs';
import { Pagina } from '../usuario/model/pagina';

@Injectable({
  providedIn: 'root'
})
export class CrudService {
  SERVER_URL = 'http://localhost:8080/api/usuarios';

  constructor(private http: HttpClient) { }

  public logarUsuario(usuarioLogin: LoginUser): Observable<UsuarioCompleto> {
    return this.http.post<UsuarioCompleto>(`${this.SERVER_URL}/logar`, usuarioLogin)
    .pipe(
      first(), 
        tap(usuarioCompleto => console.log(usuarioCompleto))
    )
  }

  listarUsuariosPaginadosPorQualquerFiltro(filtro : string, numeroPagina : number): Observable<Pagina>{
    return this.http.get<Pagina>(`${this.SERVER_URL}/pesquisar/${filtro}?page=${numeroPagina}`)
    .pipe(
      first(),
      tap(pagina => console.log(pagina))
    )
  }

  listarUsuariosPaginadosFiltro(filtro : string, numeroPagina : number): Observable<Pagina>{
    return this.http.get<Pagina>(`${this.SERVER_URL}/pesquisar/${filtro}?page=${numeroPagina}&size=1`)
    .pipe(
      first(),
      tap(pagina => console.log(pagina))
    )
  }

  listar(numeroPagina : number): Observable<Pagina> {
    return this.http.get<Pagina>(`${this.SERVER_URL}?page=${numeroPagina}`)
    .pipe(
      first(),
      tap(usuarios => console.log(usuarios))
    );
  }

  listarUsuariosPorInteresse(interesse : string, pagina : number) : Observable<Pagina>{
    return this.http.get<Pagina>(`${this.SERVER_URL}/sugerir/${interesse}?page=${pagina}`)
    .pipe(
      first(),
      tap(usuarios => console.log(usuarios))
    );
  }

  atualizarUsuario(idUsuario: number, usuarioCompleto: UsuarioCompleto): Observable<UsuarioCompleto>{
    return this.http.put<UsuarioCompleto>(`${this.SERVER_URL}/atualizar/${idUsuario}`, usuarioCompleto)
    .pipe(
      first(),
      tap(usuarioCompleto => console.log(usuarioCompleto))
    )

  }

  buscarUsuario(idUsuario: number): Observable<UsuarioCompleto> {
    return this.http.get<UsuarioCompleto>(`${this.SERVER_URL}/${idUsuario}`)
    .pipe(
      first(),
      tap(usuarioCompleto => console.log(usuarioCompleto))
    );
  }
}

