import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { PoBreadcrumb, PoDynamicViewField, PoModalComponent } from '@po-ui/ng-components';
import {
  PoPageDynamicTableActions,
  PoPageDynamicTableCustomTableAction
} from '@po-ui/ng-templates';
import { PontoTuristicoService, PontoTuristico } from '../service/ponto-turistico.service';

@Component({
  selector: 'app-pontos-turisticos',
  templateUrl: './pontos-turisticos.component.html',
  styleUrls: ['./pontos-turisticos.component.css']
})
export class PontosTuristicosComponent implements OnInit {
  @ViewChild('DetailModal') DetailModal!: PoModalComponent;
  @ViewChild('optionsForm', { static: true }) form!: NgForm;

  pontos: PontoTuristico[] = [];
  detailed: any;
  comentarioDetail: string = '';
  actionsRight: any = [];
  quickSearchWidth = 3;

  readonly serviceApi = 'http://localhost:8080/ponto-turistico';

  constructor(private service: PontoTuristicoService) {}

  ngOnInit(): void {
    this.carregarPontos();
  }

  carregarPontos(): void {
    this.service.getAll().subscribe(dados => {
      this.pontos = dados;
    });
  }

  confirmComentario(): void {
    console.log('Comentário confirmado:', this.comentarioDetail);

    // Aqui você pode salvar o comentário no backend se quiser
    // Ex: this.service.salvarComentario(this.detailed.id, this.comentarioDetail).subscribe(...)

    this.comentarioDetail = '';
    this.DetailModal.close();
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
    { value: 'Brasil', label: 'Brasil' },
    { value: 'Argentina', label: 'Argentina' },
    { value: 'França', label: 'França' },
    { value: 'Itália', label: 'Itália' }
    // Adicione mais se quiser
  ];

  readonly estacaoOptions = [
    { value: 'Primavera', label: 'Primavera' },
    { value: 'Verão', label: 'Verão' },
    { value: 'Outono', label: 'Outono' },
    { value: 'Inverno', label: 'Inverno' },
  ];

  readonly fields = [
    { property: 'nome', label: 'Ponto Turístico', filter: true, gridColumns: 12 },
    { property: 'pais', label: 'País', filter: true, options: this.paisOptions, gridColumns: 6 },
    { property: 'cidade', label: 'Cidade', filter: true, gridColumns: 6 },
    { property: 'estacao', label: 'Estação do ano', filter: true, options: this.estacaoOptions, gridColumns: 6 },
    { property: 'resumo', label: 'Resumo', }
  ];

  readonly detailFields: Array<PoDynamicViewField> = [
    { property: 'nome', label: 'Ponto Turístico', gridLgColumns: 24, },
    { property: 'pais', label: 'País', gridLgColumns: 6 },
    { property: 'cidade', label: 'Cidade', gridLgColumns: 6 },
    { property: 'estacao', label: 'Melhor estação do ano', tag: true, gridLgColumns: 6 },
    { property: 'resumo', label: 'Resumo',gridLgColumns: 24 },
  ];

  readonly tableCustomActions: Array<PoPageDynamicTableCustomTableAction> = [
    {
      label: 'Detalhes',
      action: this.onClickDetail.bind(this),
      icon: 'po-icon-info'
    }
  ];

  private onClickDetail(ponto: PontoTuristico): void {
    this.detailed = ponto;
    this.DetailModal.open();
  }
}
