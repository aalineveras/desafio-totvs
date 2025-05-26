import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import {
  PoModule,
  PoPageModule,
  PoModalModule,
  PoDynamicModule
} from '@po-ui/ng-components';

import {
  PoTemplatesModule,
  PoPageDynamicTableModule
} from '@po-ui/ng-templates';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { PaisesComponent } from './paises/paises.component';
import { CadastroPaisesComponent } from './paises/cadastro-paises/cadastro-paises.component';
import { PontosTuristicosComponent } from './pontos-turisticos/pontos-turisticos.component';
import { CadastroPontosTuristicosComponent } from './pontos-turisticos/cadastro-pontos-turisticos/cadastro-pontos-turisticos.component';
import { ComentariosComponent } from './comentarios/comentarios.component';
import { CadastroComentarioComponent } from './comentarios/cadastro-comentario/cadastro-comentario.component';

@NgModule({
  declarations: [
    AppComponent,
    PaisesComponent,
    CadastroPaisesComponent,
    PontosTuristicosComponent,
    CadastroPontosTuristicosComponent,
    ComentariosComponent,
    CadastroComentarioComponent
  ],
  imports: [
    BrowserModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    RouterModule, // apenas se precisar usar rotas diretamente aqui
    PoModule,
    PoPageModule,
    PoModalModule,
    PoDynamicModule,
    PoTemplatesModule,
    PoPageDynamicTableModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
