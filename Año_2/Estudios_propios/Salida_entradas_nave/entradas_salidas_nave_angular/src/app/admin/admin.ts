import { Component } from '@angular/core';
import { Header } from '../header/header';
import { MenuAdmin } from '../menu-admin/menu-admin';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';


@Component({
  selector: 'app-admin',
  standalone: true,
  imports: [Header, MenuAdmin, CommonModule, RouterModule],
  templateUrl: './admin.html',
  styleUrls: ['./admin.css']
})
export class Admin {

}
