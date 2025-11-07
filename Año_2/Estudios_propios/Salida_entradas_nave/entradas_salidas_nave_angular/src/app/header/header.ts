import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { SalidaInterface } from '../interfaces/salida-interface';
import { SalidasService } from '../services/salidas-service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterLink, RouterLinkActive, CommonModule],
  templateUrl: './header.html',
  styleUrls: ['./header.css']
})
export class Header {
  salidas: SalidaInterface[] = [];

  constructor(private salidasService: SalidasService) { }

  ngOnInit() {
    this.salidasService.obtenerSalidas().subscribe({
      next: (salidas) => (this.salidas = salidas),
      error: (error) => console.log(error),
    });
  }
}
