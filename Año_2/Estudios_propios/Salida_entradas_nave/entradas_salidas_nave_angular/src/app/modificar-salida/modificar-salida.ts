import { Component } from '@angular/core';
import { Header } from '../header/header';
import { SalidaInterface } from '../interfaces/salida-interface';
import { SalidasService } from '../services/salidas-service';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-modificar-salida',
  imports: [Header, ReactiveFormsModule, CommonModule, RouterLink, RouterLinkActive],
  templateUrl: './modificar-salida.html',
  styleUrl: './modificar-salida.css'
})
export class ModificarSalida {
  formulario: FormGroup;

  salida: SalidaInterface = {
    id: 0,
    nombre: '',
    ubicacion: '',
    visibilidad: '',
    descripcion: '',
    imagen1: '',
    imagen2: ''
  };

  constructor(private salidasService: SalidasService, private routerId: ActivatedRoute, private builder: FormBuilder, private router: Router) {
    this.formulario = builder.group({
      nombre: ['', [Validators.required, Validators.minLength(3)]],
      ubicacion: ['', [Validators.required, Validators.minLength(3)]],
      visibilidad: ['', [Validators.required, Validators.minLength(3)]],
      descripcion: ['', [Validators.required, Validators.minLength(3)]],
      imagen1: ['', [Validators.required]],
      imagen2: ['', [Validators.required]]
    });
  }

  ngOnInit() {
    let id = Number(this.routerId.snapshot.paramMap.get('id'));

    this.salidasService.obtenerSalida(id).subscribe({
      next: (salida) => {
        this.salida = salida;

        this.formulario.patchValue({
          nombre: this.salida.nombre,
          ubicacion: this.salida.ubicacion,
          visibilidad: this.salida.visibilidad,
          descripcion: this.salida.descripcion
        });
      },
      error: (error) => console.log(error)
    });
  }

  rexistrar(evento: Event) {
    evento.preventDefault();

    // Comprobamos si el formulario cumple todas las validaciones.
    if (this.formulario.valid) {
      let id = Number(this.routerId.snapshot.paramMap.get('id'));

      let nuevaSalida: SalidaInterface = {
        id: id,
        nombre: this.formulario.value.nombre,
        ubicacion: this.formulario.value.ubicacion,
        visibilidad: this.formulario.value.visibilidad,
        descripcion: this.formulario.value.descripcion,
        imagen1: this.formulario.value.imagen1,
        imagen2: this.formulario.value.imagen2
      }

      this.salidasService.modificarSalida(nuevaSalida).subscribe({
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
