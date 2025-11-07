import { Injectable } from '@angular/core';
import { SalidaInterface } from '../interfaces/salida-interface';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class SalidasService {
  apiURL: string = 'http://localhost:5000/salidas';

  constructor(private cliente: HttpClient, private router: Router) { }

  // Creamos la función para obtener todas las salidas.
  obtenerSalidas(): Observable<SalidaInterface[]> {
    return this.cliente.get<SalidaInterface[]>(this.apiURL);
  }

  // Creamos la función para obtener una salida en concreto.
  obtenerSalida(id: number): Observable<SalidaInterface> {
    return this.cliente.get<SalidaInterface>(this.apiURL + '/' + id);
  }

  // Eliminamos la salida de la API al que pertenezca la id.
  eliminarSalida(id: number): Observable<SalidaInterface> {
    return this.cliente.delete<SalidaInterface>(this.apiURL + '/' + id);
  }

  // Creamos la función para añadir una salida.
  añadirSalida(salida: SalidaInterface): Observable<SalidaInterface> {
    return this.cliente.post<SalidaInterface>(this.apiURL, salida);
  }

  // Creamos la función de modificar una salida en concreto
  modificarSalida(salidaModificada: SalidaInterface): Observable<SalidaInterface> {
    return this.cliente.put<SalidaInterface>(this.apiURL + '/' + salidaModificada.id, salidaModificada);
  }
}
