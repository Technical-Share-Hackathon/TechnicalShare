import { LogarComponent } from './logar/logar.component';
import { ListarUsuarioComponent } from './listar-usuario/listar-usuario.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path:'', component: ListarUsuarioComponent},
  {path:'logar', component: LogarComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsuarioRoutingModule { }
