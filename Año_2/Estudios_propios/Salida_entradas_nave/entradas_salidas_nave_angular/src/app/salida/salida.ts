import { Component } from '@angular/core';
import { Header } from '../header/header';
import { SalidaInterface } from '../interfaces/salida-interface';
import { SalidasService } from '../services/salidas-service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-salida',
  imports: [Header],
  templateUrl: './salida.html',
  styleUrl: './salida.css'
})
export class Salida {
  salida: SalidaInterface = {
    id: 0,
    nombre: '',
    ubicacion: '',
    visibilidad: '',
    descripcion: '',
    imagen1: '',
    imagen2: ''
  };

  constructor(private salidasService: SalidasService, private routerId: ActivatedRoute) { }

  ngOnInit() {
    let id = Number(this.routerId.snapshot.paramMap.get('id'));

    this.salidasService.obtenerSalida(id).subscribe({
      next: (salida) => {
        this.salida = salida;
      },
      error: (error) => console.log(error)
    });
  }
}
