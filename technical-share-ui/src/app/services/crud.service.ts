import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoginUser } from '../usuario/model/login-user'
import { UsuarioCompleto } from '../usuario/model/usuario-completo';
import { first, Observable, tap } from 'rxjs';

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
}

