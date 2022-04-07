import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],

  styles: [
    `  @media only screen and (max-width: 1025px) {  .div{  color:red;  } }   `
  ]
})
export class AppComponent {
   title = 'angular app';
}
