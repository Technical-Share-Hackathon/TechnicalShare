import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  perfis = [
    {name: "Marcelo Silva", cargo: "Product Designer"},
    {name: "Marcelo Silva", cargo: "Product Designer"},
    {name: "Marcelo Silva", cargo: "Product Designer"},
    {name: "Marcelo Silva", cargo: "Product Designer"},
    {name: "Marcelo Silva", cargo: "Product Designer"}   
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
