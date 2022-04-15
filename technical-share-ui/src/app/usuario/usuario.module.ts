import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UsuarioRoutingModugle } from './usuario-routing.module';
import { ListarUsuarioComponent } from './listar-usuario/listar-usuario.component';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from '../home/home.component';
import { PesquisaUsuariosComponent } from '../pesquisa-usuarios/pesquisa-usuarios.component';


@NgModule({
  declarations: [
    ListarUsuarioComponent,
    LoginComponent,
    HomeComponent,
  ],
  imports: [
    CommonModule,
    UsuarioRoutingModugle,
    FormsModule
  ]
})
export class UsuarioModule { }
