import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CadastroComentarioComponent } from './comentarios/cadastro-comentario/cadastro-comentario.component';
import { CadastroPaisesComponent } from './paises/cadastro-paises/cadastro-paises.component';
import { PaisesComponent } from './paises/paises.component';
import { CadastroPontosTuristicosComponent } from './pontos-turisticos/cadastro-pontos-turisticos/cadastro-pontos-turisticos.component';
import { PontosTuristicosComponent } from './pontos-turisticos/pontos-turisticos.component';
import { PoPageDynamicTableComponent } from '@po-ui/ng-templates';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'ponto-turistico',
    pathMatch: 'full'
  },
  {
    path: 'pais',
    children: [
      {
        path: '',
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
        component: PontosTuristicosComponent
      },
      {
        path: 'cadastro',
        children: [
          {
            path: '',
            component: CadastroPontosTuristicosComponent,
            data: { tipoCadastroPontoTuristico: 'new' }
          },
          {
            path: ':idPontoTuristico',
            component: CadastroPontosTuristicosComponent,
            data: { tipoCadastroPontoTuristico: 'view' }
          }
        ]
      }
    ]
  },
  {
    path: 'comentario',
    children: [
      {
        path: '',
        component: CadastroComentarioComponent,
        data: { tipoCadastroComentario: 'new' }
      },
      {
        path: ':idComentario',
        component: CadastroComentarioComponent,
        data: { tipoCadastroComentario: 'view' }
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
      serviceApi: 'http://localhost:3000/v1/people',
      serviceMetadataApi: 'http://localhost:3000/v1/metadata',
      serviceLoadApi: 'http://localhost:3000/load-metadata'
    }
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
