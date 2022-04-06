import { UsuarioLogin } from './../model/usuario-login';
import { UsuarioCompleto } from './../model/usuario-completo';
import { UsuarioService } from './../services/usuario.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-logar',
  templateUrl: './logar.component.html',
  styleUrls: ['./logar.component.scss']
})
export class LogarComponent implements OnInit {

  usuarioCompleto: UsuarioCompleto = new UsuarioCompleto;
  usuarioLogin : UsuarioLogin = new UsuarioLogin;

  constructor(private usuarioService : UsuarioService) {

  }

  ngOnInit(): void {
  }

  logar(){
      this.usuarioService.logar(this.usuarioLogin).subscribe((resp: UsuarioCompleto) =>{
        this.usuarioCompleto = resp;
    }, erro =>{
       console.log(erro)
    })
  }

}
