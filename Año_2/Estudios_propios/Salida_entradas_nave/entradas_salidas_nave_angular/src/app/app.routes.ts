import { Routes } from '@angular/router';
import { Inicio } from './inicio/inicio';
import { Salida } from './salida/salida';
import { Admin } from './admin/admin';
import { AnadirSalida } from './anadir-salida/anadir-salida';
import { ModificarSalida } from './modificar-salida/modificar-salida';
import { Login } from './login/login';
import { RegistroUsuarios } from './registro-usuarios/registro-usuarios';
import { TablaAdminSalidas } from './tabla-admin-salidas/tabla-admin-salidas';
import { TablaAdminUsuarios } from './tabla-admin-usuarios/tabla-admin-usuarios';

export const routes: Routes = [
    { path: '', title: 'login', component: Login },
    { path: 'registroUsuarios', title: 'registroUsuarios', component: RegistroUsuarios },

    { path: 'inicio', title: 'inicio', component: Inicio },
    { path: 'salida/:id', title: 'salida', component: Salida },

    {
        path: 'admin', component: Admin, children: [
            { path: 'salidas', component: TablaAdminSalidas },
            { path: 'usuarios', component: TablaAdminUsuarios },
            { path: '', redirectTo: 'salidas', pathMatch: 'full' }
        ]
    },
    { path: 'anadirSalida', title: 'anadirSalida', component: AnadirSalida },
    { path: 'modificarSalida/:id', title: 'modificarSalida', component: ModificarSalida },
];
