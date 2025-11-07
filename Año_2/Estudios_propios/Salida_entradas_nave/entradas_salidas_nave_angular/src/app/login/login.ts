import { Component } from '@angular/core';
import { Header } from '../header/header';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [Header, ReactiveFormsModule, CommonModule, RouterLink, RouterLinkActive],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {
  formularioLogin: FormGroup;

  constructor(private builder: FormBuilder, private router: Router) {
    this.formularioLogin = builder.group({
      usuario: ['', [Validators.required]],
      password: ['', [Validators.required]]
    });
  }

  onLogin() {

  }
}
