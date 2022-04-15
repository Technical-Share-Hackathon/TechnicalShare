import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'barraProgesso'
})
export class BarraProgessoPipe implements PipeTransform {

  transform(value: number): string {
    switch (value) {
      case 1: return "umTerco";
      case 2: return "doisTercos";
      case 3: return "tresTercos"
    }
    return ""
  }

}
