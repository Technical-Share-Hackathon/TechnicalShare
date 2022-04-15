import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PerfilComponent } from './perfil/perfil.component';
import { PesquisaUsuariosComponent } from './pesquisa-usuarios/pesquisa-usuarios.component';


const routes: Routes = [
  { path: '', pathMatch: 'full' ,redirectTo: 'usuarios'},
  { path: 'home', component: HomeComponent},
  { path: 'perfil/:id', component: PerfilComponent},
  { path: 'pesquisar/:pesquisa', component: PesquisaUsuariosComponent},


  {
    path: 'usuarios',
    loadChildren: () => import('./usuario/usuario.module').then(m => m.UsuarioModule)
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
