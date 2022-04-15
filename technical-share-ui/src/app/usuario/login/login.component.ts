import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CrudService } from 'src/app/services/crud.service';
import { LoginUser } from '../model/login-user';
import { UsuarioCompleto } from '../model/usuario-completo';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  usuarioLogin: LoginUser = new LoginUser();
  usuarioCompleto: UsuarioCompleto = new UsuarioCompleto();

  constructor(
    
    private servicoDoUsuario: CrudService,
    private router: Router
  ){}

  ngOnInit(): void {
  }

  fazerLogin() {
    this.servicoDoUsuario.logarUsuario(this.usuarioLogin).subscribe((result: UsuarioCompleto) => {
      this.usuarioCompleto = result
  
      this.router.navigate(['home']);
    }, erro => {
      alert('Usuário inválido');
    }
    )
  }

}
