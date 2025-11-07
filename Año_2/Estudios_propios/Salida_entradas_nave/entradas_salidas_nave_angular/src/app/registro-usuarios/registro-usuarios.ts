import { Component } from '@angular/core';
import { Header } from '../header/header';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';
import { UsuarioInterface } from '../interfaces/usuario-interface';
import { UsuariosService } from '../services/usuarios-service';

@Component({
  selector: 'app-registro-usuarios',
  imports: [Header, ReactiveFormsModule, CommonModule, RouterLink, RouterLinkActive],
  templateUrl: './registro-usuarios.html',
  styleUrl: './registro-usuarios.css'
})
export class RegistroUsuarios {
  formularioRegistro: FormGroup;

  constructor(private usuariosService: UsuariosService, private builder: FormBuilder, private router: Router) {
    this.formularioRegistro = builder.group({
      nombre: ['', [Validators.required, Validators.minLength(3)]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
    });
  }

  onRegister(evento: Event) {
    evento.preventDefault();

    if (this.formularioRegistro.valid) {
      let nuevoUsuario: UsuarioInterface = {
        id: 0,
        nombre: this.formularioRegistro.value.nombre,
        email: this.formularioRegistro.value.email,
        password: this.formularioRegistro.value.password,
        rol: "user"
      }

      this.usuariosService.añadirUsuario(nuevoUsuario).subscribe({
        next: () => this.router.navigate(['admin/usuarios']),
        error: (error) => console.log(error)
      });
    } else {
      // No caso de que o formulario sexa inválido, marcamos todos os campos como tocados para que se vexan as mensaxes de validación.
      this.formularioRegistro.markAllAsTouched();
    }
  }
}
