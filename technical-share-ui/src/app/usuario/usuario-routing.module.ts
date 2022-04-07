import { AtualizacaoComponent } from './atualizacao/atualizacao.component';
import { PerfilComponent } from './perfil/perfil.component';
import { LogarComponent } from './logar/logar.component';
import { ListarUsuarioComponent } from './listar-usuario/listar-usuario.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListagemPesquisaComponent } from './listagem-pesquisa/listagem-pesquisa.component';

const routes: Routes = [
  {path:'', component: ListarUsuarioComponent},
  {path:'logar', component: LogarComponent},
  {path:'pesquisar', component: ListagemPesquisaComponent},
  {path:'perfil/:id', component: PerfilComponent},
  {path:'atualizar/:id', component: AtualizacaoComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsuarioRoutingModule { }
