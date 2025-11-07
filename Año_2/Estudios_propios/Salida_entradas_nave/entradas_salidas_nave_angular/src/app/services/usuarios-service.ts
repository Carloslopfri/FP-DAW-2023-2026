import { Injectable } from '@angular/core';
import { UsuarioInterface } from '../interfaces/usuario-interface';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {
  apiURL: string = 'http://localhost:5000/usuarios';

  constructor(private cliente: HttpClient, private router: Router) { }

  // Creamos la función para obtener todas los usuarios.
  obtenerUsuarios(): Observable<UsuarioInterface[]> {
    return this.cliente.get<UsuarioInterface[]>(this.apiURL);
  }

  // Eliminamos el usuario de la API al que pertenezca la id.
  eliminarUsuario(id: number): Observable<UsuarioInterface> {
    return this.cliente.delete<UsuarioInterface>(this.apiURL + '/' + id);
  }

  // Creamos la función para añadir un usuario.
  añadirUsuario(usuario: UsuarioInterface): Observable<UsuarioInterface> {
    return this.cliente.post<UsuarioInterface>(this.apiURL, usuario);
  }

  // Creamos la función de modificar un usuario en concreto.
  modificarUsuario(usuarioModificado: UsuarioInterface): Observable<UsuarioInterface> {
    return this.cliente.put<UsuarioInterface>(this.apiURL + '/' + usuarioModificado.id, usuarioModificado);
  }
}
