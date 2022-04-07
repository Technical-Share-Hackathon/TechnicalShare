import { UsuarioService } from './../services/usuario.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-recomendacoes',
  templateUrl: './recomendacoes.component.html',
  styleUrls: ['./recomendacoes.component.scss']
})
export class RecomendacoesComponent implements OnInit {

  constructor(
    private usuarioService: UsuarioService

  ) { }

  ngOnInit(): void {
  }

}
