import { UsuarioListagem } from './../model/usuario-listagem';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, first, tap } from 'rxjs';

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
}
