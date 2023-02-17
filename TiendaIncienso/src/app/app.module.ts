import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BarranavComponent } from './components/barranav/barranav.component';
import { CatMaincontainerComponent } from './components/cat-maincontainer/cat-maincontainer.component';
import { CategoriaCardComponent } from './components/categoria-card/categoria-card.component';
import { InicioContainerComponent } from './components/inicio-container/inicio-container.component';
import { FormAniadirCatComponent } from './components/form-aniadir-cat/form-aniadir-cat.component';

@NgModule({
  declarations: [
    AppComponent,
    BarranavComponent,
    CatMaincontainerComponent,
    CategoriaCardComponent,
    InicioContainerComponent,
    FormAniadirCatComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
