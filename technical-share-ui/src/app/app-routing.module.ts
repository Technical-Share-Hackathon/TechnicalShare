import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component'
import { PerfilComponent } from './perfil/perfil.component';


const routes: Routes = [
  { path: '', pathMatch: 'full' ,redirectTo: 'usuarios'},
  { path: 'home', component: HomeComponent},
  { path: 'perfil', component: PerfilComponent},
  
  
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
