import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {LoginData} from "./loginData";
import {AuthService} from "../../services/auth/auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  hide: boolean = true;
  loginForm: FormGroup;
  loginData: LoginData;

  usernameControl: FormControl = new FormControl('', [
    Validators.required,
    Validators.maxLength(15)
  ]);
  passwordControl: FormControl = new FormControl('', [
    Validators.required,
    Validators.minLength(4),
    Validators.maxLength(16)
  ]);

  constructor(private formBuilder: FormBuilder,
              private authService: AuthService) {
  }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: this.usernameControl,
      password: this.passwordControl
    });
  }

  login = () => {
    this.loginData = this.loginForm.value;
    this.authService.signIn(this.loginData).subscribe();
  }
}
