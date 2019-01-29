import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {HeaderComponent} from '../components/header/header.component';
import {AngularMaterialModule} from "./angular-material/angular-material.module";
import {AppRoutingModule} from "./app-routing/app-routing.module";
import {MainNavigationComponent} from "../components/main-navigation/main-navigation.component";
import {AppComponent} from "../app.component";
import {IndexComponent} from '../components/index/index.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {LoginComponent} from '../components/login/login.component';
import {RegistrationComponent} from '../components/registration/registration.component';
import {AuthService} from "../services/auth/auth.service";
import {HttpClientModule} from "@angular/common/http";
import {SlideshowModule} from "ng-simple-slideshow";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    MainNavigationComponent,
    IndexComponent,
    LoginComponent,
    RegistrationComponent
  ],
  imports: [
    BrowserModule,
    AngularMaterialModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    SlideshowModule
  ],
  providers: [
    AuthService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
