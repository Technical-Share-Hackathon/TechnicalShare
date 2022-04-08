import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UsuarioRoutingModugle } from './usuario-routing.module';
import { ListarUsuarioComponent } from './listar-usuario/listar-usuario.component';
import { LoginComponent } from './login/login.component';


@NgModule({
  declarations: [
    ListarUsuarioComponent,
    LoginComponent
  ],
  imports: [
    CommonModule,
    UsuarioRoutingModugle
  ]
})
export class UsuarioModule { }
