import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UsuarioRoutingModule } from './usuario-routing.module';
import { ListarUsuarioComponent } from './listar-usuario/listar-usuario.component';
import { LogarComponent } from './logar/logar.component';
import { PerfilComponent } from './perfil/perfil.component';
import { AtualizacaoComponent } from './atualizacao/atualizacao.component';
import { RecomendacoesComponent } from './recomendacoes/recomendacoes.component';
import { ListagemPesquisaComponent } from './listagem-pesquisa/listagem-pesquisa.component';



@NgModule({
  declarations: [
    ListarUsuarioComponent,
    LogarComponent,
    PerfilComponent,
    AtualizacaoComponent,
    RecomendacoesComponent,
    ListagemPesquisaComponent
  ],
  imports: [
    CommonModule,
    UsuarioRoutingModule,
    FormsModule,
  ]
})
export class UsuarioModule { }
