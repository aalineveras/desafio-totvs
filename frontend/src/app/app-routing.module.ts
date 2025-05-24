import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroComentarioComponent } from './comentarios/cadastro-comentario/cadastro-comentario.component';
import { CadastroPaisesComponent } from './paises/cadastro-paises/cadastro-paises.component';
import { PaisesComponent } from './paises/paises.component';
import { CadastroPontosTuristicosComponent } from './pontos-turisticos/cadastro-pontos-turisticos/cadastro-pontos-turisticos.component';
import { PontosTuristicosComponent } from './pontos-turisticos/pontos-turisticos.component';
import { PoPageDynamicTableModule } from '@po-ui/ng-templates';
import { PoPageDynamicTableComponent } from '@po-ui/ng-templates';

const routes: Routes = [
  {
    path: 'pais',
    children: [
      {
        path: '',
        pathMatch: 'full',
        component: PaisesComponent
      },
      {
        path: 'cadastro',
        children: [
          {
            path: ':idPais',
            component: CadastroPaisesComponent,
            data: { tipoCadastroPais: '' }
          },
          {
            path: '',
            pathMatch: 'full',
            component: CadastroPaisesComponent,
            data: { tipoCadastroPais: 'new' }
          }
        ]
      }
    ]
  },
  {
    path: 'ponto-turistico',
    children: [
      {
        path: '',
        pathMatch: 'full',
        component: PontosTuristicosComponent,
      },
      {
        path: 'cadastro',
        pathMatch: 'full',
        children:[
          {
            path: '',
            pathMatch: 'full',
            component: CadastroPontosTuristicosComponent,
            data: { tipoCadastroPontoTuristico: 'new' }
          },
          {
            path: ':idPontoTuristico',
            component: CadastroPontosTuristicosComponent,
            data: { tipoCadastroPontoTuristico: 'view' },
            children: [
              {
                path: 'comentario',
                children: [
                  {
                    path: '',
                    pathMatch: 'full',
                    component: CadastroComentarioComponent,
                    data: { tipoCadastroComentario: 'new' }
                  },
                  {
                    path: ':idComentario',
                    component: CadastroComentarioComponent,
                    data: { tipoCadastroComentario: 'view' }
                  }
                ]
              }
            ]
          }
        ]
      }
    ]
  },
  {
    path: 'sample-po-page-dynamic-table-hotels',
    component: PoPageDynamicTableComponent
  },
  {
  path: 'people',
  component: PoPageDynamicTableComponent,
  data: {
    serviceApi: 'http://localhost:3000/v1/people', // endpoint dos dados
    serviceMetadataApi: 'http://localhost:3000/v1/metadata', // endpoint dos metadados utilizando o método HTTP Get
    serviceLoadApi: 'http://localhost:3000/load-metadata' // endpoint de customizações dos metadados utilizando o método HTTP Post
  }
 },
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
