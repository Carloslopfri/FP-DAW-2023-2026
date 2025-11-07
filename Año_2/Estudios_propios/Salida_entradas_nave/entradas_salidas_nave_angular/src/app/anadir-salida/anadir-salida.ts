import { Component } from '@angular/core';
import { Header } from '../header/header';
import { CommonModule } from '@angular/common';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { SalidasService } from '../services/salidas-service';
import { SalidaInterface } from '../interfaces/salida-interface';

@Component({
  selector: 'app-anadir-salida',
  imports: [Header, RouterLink, RouterLinkActive, ReactiveFormsModule, CommonModule],
  templateUrl: './anadir-salida.html',
  styleUrl: './anadir-salida.css'
})
export class AnadirSalida {
  formulario: FormGroup;

  salida = {
    nombre: '',
    ubicacion: '',
    visibilidad: '',
    descripcion: '',
    imagen1: '',
    imagen2: ''
  }

  constructor(private builder: FormBuilder, private salidasService: SalidasService, private router: Router) {
    this.formulario = builder.group({
      nombre: ['', [Validators.required, Validators.minLength(3)]],
      ubicacion: ['', [Validators.required, Validators.minLength(3)]],
      visibilidad: ['', [Validators.required, Validators.minLength(3)]],
      descripcion: ['', [Validators.required, Validators.minLength(3)]],
      imagen1: ['', [Validators.required]],
      imagen2: ['', [Validators.required]]
    });
  }

  rexistrar(evento: Event) {
    evento.preventDefault();
    // Comprobamos si el formulario cumple todas las validaciones.
    if (this.formulario.valid) {
      let nuevaSalida: SalidaInterface = {
        id: 0,
        nombre: this.formulario.value.nombre,
        ubicacion: this.formulario.value.ubicacion,
        visibilidad: this.formulario.value.visibilidad,
        descripcion: this.formulario.value.descripcion,
        imagen1: this.formulario.value.imagen1,
        imagen2: this.formulario.value.imagen2
      }

      this.salidasService.añadirSalida(nuevaSalida).subscribe({
        next: () => this.router.navigate(['admin']),
        error: (error) => console.log(error)
      });
    } else {
      // No caso de que o formulario sexa inválido, marcamos todos os campos como tocados para que se vexan as mensaxes de validación.
      this.formulario.markAllAsTouched();
    }
  }

  onFileChange(event: any, campo: string) {
    let file = event.target.files[0];
    if (file) {
      let fileName = file.name;
      let validExtensions = ['jpg', 'jpeg', 'png'];
      let ext = fileName.split('.').pop()?.toLowerCase();

      if (ext && validExtensions.includes(ext)) {
        this.formulario.patchValue({ [campo]: fileName });
      } else {
        this.formulario.patchValue({ [campo]: '' });
        alert('Solo se permiten archivos .jpg, .jpeg o .png');
      }
    }
  }


}
