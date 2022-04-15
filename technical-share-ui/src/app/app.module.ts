import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { PerfilComponent } from './perfil/perfil.component';
import { PesquisaUsuariosComponent } from './pesquisa-usuarios/pesquisa-usuarios.component';
import { FormsModule } from '@angular/forms';
import { BarraProgessoPipe } from './barra-progesso.pipe';


@NgModule({
  declarations: [
    AppComponent,
    PerfilComponent,
    PesquisaUsuariosComponent,
    BarraProgessoPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule, 
    FormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
