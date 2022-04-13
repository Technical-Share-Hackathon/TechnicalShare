import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UsuarioRoutingModugle } from './usuario-routing.module';
import { ListarUsuarioComponent } from './listar-usuario/listar-usuario.component';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    ListarUsuarioComponent,
    LoginComponent
  ],
  imports: [
    CommonModule,
    UsuarioRoutingModugle,
    FormsModule
  ]
})
export class UsuarioModule { }
