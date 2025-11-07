import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { UsuarioInterface } from '../interfaces/usuario-interface';
import { UsuariosService } from '../services/usuarios-service';

@Component({
  selector: 'app-tabla-admin-usuarios',
  imports: [CommonModule, RouterLink, RouterLinkActive],
  templateUrl: './tabla-admin-usuarios.html',
  styleUrl: './tabla-admin-usuarios.css'
})
export class TablaAdminUsuarios {
  usuarios: UsuarioInterface[] = [];

  constructor(private usuariosService: UsuariosService) { }

  ngOnInit() {
    this.usuariosService.obtenerUsuarios().subscribe({
      next: (usuarios) => (this.usuarios = usuarios),
      error: (error) => console.log(error),
    });
  }

  eliminarUsuario(idUsuario: number) {
    this.usuariosService.eliminarUsuario(idUsuario).subscribe({
      next: () => {
        // Eliminamos el producto del array local para que desaparezca de la vista.
        this.usuarios = this.usuarios.filter(p => p.id != idUsuario);
      },
      error: (error) => console.log(error)
    });
  }
}
