import { Component } from '@angular/core';
import { SalidaInterface } from '../interfaces/salida-interface';
import { SalidasService } from '../services/salidas-service';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-tabla-admin-salidas',
  imports: [CommonModule, RouterLink, RouterLinkActive],
  templateUrl: './tabla-admin-salidas.html',
  styleUrl: './tabla-admin-salidas.css'
})
export class TablaAdminSalidas {
salidas: SalidaInterface[] = [];

  constructor(private salidasService: SalidasService) { }

  ngOnInit() {
    this.salidasService.obtenerSalidas().subscribe({
      next: (salidas) => (this.salidas = salidas),
      error: (error) => console.log(error),
    });
  }

  eliminarSalida(idSalida: number) {
    this.salidasService.eliminarSalida(idSalida).subscribe({
      next: () => {
        // Eliminamos el producto del array local para que desaparezca de la vista.
        this.salidas = this.salidas.filter(p => p.id != idSalida);
      },
      error: (error) => console.log(error)
    });
  }
}
