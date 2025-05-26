import { Component, OnInit, ViewChild } from '@angular/core';
import { PontoTuristicoService, PontoTuristico } from '../service/ponto-turistico.service';
import { PoBreadcrumb, PoDynamicViewField, PoModalComponent } from '@po-ui/ng-components';
import {
  PoPageDynamicTableActions,
  PoPageDynamicTableCustomTableAction
} from '@po-ui/ng-templates';

@Component({
  selector: 'app-pontos-turisticos',
  templateUrl: './pontos-turisticos.component.html',
  styleUrls: ['./pontos-turisticos.component.css']
})
export class PontosTuristicosComponent implements OnInit {
  @ViewChild('DetailModal') DetailModal!: PoModalComponent;

  pontos: PontoTuristico[] = [];
  detailed: any;
  quickSearchWidth = 3;
  actionsRight = true;

  readonly serviceApi = 'http://localhost:8080/ponto-turistico?page=1&pageSize=10';

  constructor(private service: PontoTuristicoService) {}

  ngOnInit(): void {
    this.service.getAll().subscribe(dados => {
      this.pontos = dados;
    });
  }

  readonly actions: PoPageDynamicTableActions = {
    new: './ponto-turistico/cadastro',
    remove: true,
    removeAll: true
  };

  readonly breadcrumb: PoBreadcrumb = {
    items: [
      { label: 'Home', link: '/' },
      { label: 'Ponto Turístico' }
    ]
  };

  readonly paisOptions = [
     {
      "value": "Afeganistão",
      "label": "Afeganistão"
    },
    {
      "value": "África do Sul",
      "label": "África do Sul"
    },
    {
      "value": "Albânia",
      "label": "Albânia"
    },
    {
      "value": "Alemanha",
      "label": "Alemanha"
    },
    {
      "value": "Andorra",
      "label": "Andorra"
    },
    {
      "value": "Angola",
      "label": "Angola"
    },
    {
      "value": "Arábia Saudita",
      "label": "Arábia Saudita"
    },
    {
      "value": "Argentina",
      "label": "Argentina"
    },
    {
      "value": "Armênia",
      "label": "Armênia"
    },
    {
      "value": "Austrália",
      "label": "Austrália"
    },
    {
      "value": "Áustria",
      "label": "Áustria"
    },
    {
      "value": "Bahamas",
      "label": "Bahamas"
    },
    {
      "value": "Bangladesh",
      "label": "Bangladesh"
    },
    {
      "value": "Barbados",
      "label": "Barbados"
    },
    {
      "value": "Bélgica",
      "label": "Bélgica"
    },
    {
      "value": "Bolívia",
      "label": "Bolívia"
    },
    {
      "value": "Brasil",
      "label": "Brasil"
    },
    {
      "value": "Canadá",
      "label": "Canadá"
    },
    {
      "value": "Chile",
      "label": "Chile"
    },
    {
      "value": "China",
      "label": "China"
    },
    {
      "value": "Colômbia",
      "label": "Colômbia"
    },
    {
      "value": "Coreia do Sul",
      "label": "Coreia do Sul"
    },
    {
      "value": "Cuba",
      "label": "Cuba"
    },
    {
      "value": "Dinamarca",
      "label": "Dinamarca"
    },
    {
      "value": "Egito",
      "label": "Egito"
    },
    {
      "value": "Equador",
      "label": "Equador"
    },
    {
      "value": "Espanha",
      "label": "Espanha"
    },
    {
      "value": "Estados Unidos",
      "label": "Estados Unidos"
    },
    {
      "value": "França",
      "label": "França"
    },
    {
      "value": "Grécia",
      "label": "Grécia"
    },
    {
      "value": "Índia",
      "label": "Índia"
    },
    {
      "value": "Indonésia",
      "label": "Indonésia"
    },
    {
      "value": "Irã",
      "label": "Irã"
    },
    {
      "value": "Irlanda",
      "label": "Irlanda"
    },
    {
      "value": "Israel",
      "label": "Israel"
    },
    {
      "value": "Itália",
      "label": "Itália"
    },
    {
      "value": "Japão",
      "label": "Japão"
    },
    {
      "value": "México",
      "label": "México"
    },
    {
      "value": "Nigéria",
      "label": "Nigéria"
    },
    {
      "value": "Noruega",
      "label": "Noruega"
    },
    {
      "value": "Nova Zelândia",
      "label": "Nova Zelândia"
    },
    {
      "value": "Países Baixos",
      "label": "Países Baixos"
    },
    {
      "value": "Paraguai",
      "label": "Paraguai"
    },
    {
      "value": "Peru",
      "label": "Peru"
    },
    {
      "value": "Portugal",
      "label": "Portugal"
    },
    {
      "value": "Reino Unido",
      "label": "Reino Unido"
    },
    {
      "value": "Rússia",
      "label": "Rússia"
    },
    {
      "value": "Suécia",
      "label": "Suécia"
    },
    {
      "value": "Suíça",
      "label": "Suíça"
    },
    {
      "value": "Ucrânia",
      "label": "Ucrânia"
    },
    {
      "value": "Uruguai",
      "label": "Uruguai"
    },
    {
      "value": "Venezuela",
      "label": "Venezuela"
    }
  ];

  readonly estacaoOptions: Array<object> = [
    {
      "value": "Primavera",
      "label": "Primavera"
    },
    {
      "value": "Verão",
      "label": "Verão"
    },
    {
      "value": "Outono",
      "label": "Outono"
    },
    {
      "value": "Inverno",
      "label": "Inverno"
    },
  ];

  readonly fields = [
    { property: 'nome', label: 'Ponto Turístico', filter: true, gridColumns: 6 },
    { property: 'pais', label: 'País', filter: true, options: this.paisOptions, gridColumns: 6 },
    { property: 'cidade', label: 'Cidade', filter: true, gridColumns: 6 },
    { property: 'estacao', label: 'Estação', filter: true, options: this.estacaoOptions, gridColumns: 6 },
    { property: 'resumo', label: 'Resumo', gridColumns: 12 }
  ];

  readonly detailFields: Array<PoDynamicViewField> = [
    { property: 'nome', label: 'Ponto Turístico', gridLgColumns: 12, divider: 'Detalhes' },
    { property: 'pais', label: 'País', gridLgColumns: 6 },
    { property: 'cidade', label: 'Cidade', gridLgColumns: 6 },
    { property: 'estacao', label: 'Melhor estação do ano', tag: true, gridLgColumns: 4 },
    { property: 'resumo', label: 'Resumo', gridLgColumns: 8 }
  ];

  readonly tableCustomActions: Array<PoPageDynamicTableCustomTableAction> = [
    {
      label: 'Detalhar',
      action: this.onClickDetail.bind(this),
      icon: 'po-icon-info'
    }
  ];

  private onClickDetail(ponto: any): void {
    this.detailed = ponto;
    this.DetailModal.open();
  }
}
