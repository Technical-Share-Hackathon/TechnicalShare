import { UsuarioListagem } from './../model/usuario-listagem';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, first, tap } from 'rxjs';
import { UsuarioLogin } from '../model/usuario-login';
import { UsuarioCompleto } from '../model/usuario-completo';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private readonly API = "http://localhost:8080/api/usuarios"

  constructor(private httpClient : HttpClient) {

  }

  listar(): Observable<UsuarioListagem[]> {
    return this.httpClient.get<UsuarioListagem[]>(this.API)
    .pipe(
      first(),
      tap(usuarios => console.log(usuarios))
    );
  }

  atualizarUsuario(idUsuario: number, usuarioCompleto: UsuarioCompleto): Observable<UsuarioCompleto>{
    return this.httpClient.put<UsuarioCompleto>(`${this.API}/atualizar/${idUsuario}`, usuarioCompleto)
    .pipe(
      first(),
      tap(usuarioCompleto => console.log(usuarioCompleto))
    )

  }

  buscarUsuario(idUsuario: number): Observable<UsuarioCompleto> {
    return this.httpClient.get<UsuarioCompleto>(`${this.API}/${idUsuario}`)
    .pipe(
      first(),
      tap(usuarioCompleto => console.log(usuarioCompleto))
    );
  }

  logar(usuarioLogin: UsuarioLogin): Observable<UsuarioCompleto> {
    return this.httpClient.post<UsuarioCompleto>(this.API+"/logar", usuarioLogin)
    .pipe(
      first(),
      tap(usuarioCompleto => console.log(usuarioCompleto))
    );
  }

}
