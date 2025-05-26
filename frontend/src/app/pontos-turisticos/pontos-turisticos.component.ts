import { Component, OnInit, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
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
  comentarios: any[] = [];
  mostrarCaixaComentario: boolean = false;

  actionsRight: any = [];
  quickSearchWidth = 3;

  readonly serviceApi = 'http://localhost:8080/ponto-turistico';
  private readonly urlComentarios = 'http://localhost:8080/comentario';

  constructor(private service: PontoTuristicoService, private http: HttpClient) { }

  ngOnInit(): void {
    this.carregarPontos();
  }

  carregarPontos(): void {
    this.service.getAll().subscribe(dados => {
      this.pontos = dados;
    });
  }

  novoComentario = {
    autor: '',
    texto: '',
    pontoTuristicoId: 0,
    data: new Date()
  };

  confirmComentario(): void {
    const comentario = {
      ...this.novoComentario,
      pontoTuristicoId: this.detailed.id,
      data: new Date()
    };

    this.http.post(this.urlComentarios, comentario).subscribe(() => {
      this.novoComentario.autor = '';
      this.novoComentario.texto = '';
      this.mostrarCaixaComentario = false;
      this.carregarComentarios(this.detailed.id);
    });
  }

  carregarComentarios(pontoId: number): void {
    this.http.get<any[]>(`${this.urlComentarios}/ponto/${pontoId}`)
      .subscribe(res => this.comentarios = res);
  }


  readonly actions: PoPageDynamicTableActions = {
    new: './ponto-turistico/cadastro'
  };

  readonly breadcrumb: PoBreadcrumb = {
    items: [
      { label: 'Home', link: '/' },
      { label: 'Ponto Turístico' }
    ]
  };

  readonly paisOptions: Array<{ value: string, label: string }> = [
    { value: 'Afeganistão', label: 'Afeganistão' },
    { value: 'África do Sul', label: 'África do Sul' },
    { value: 'Albânia', label: 'Albânia' },
    { value: 'Alemanha', label: 'Alemanha' },
    { value: 'Andorra', label: 'Andorra' },
    { value: 'Angola', label: 'Angola' },
    { value: 'Antígua e Barbuda', label: 'Antígua e Barbuda' },
    { value: 'Arábia Saudita', label: 'Arábia Saudita' },
    { value: 'Argélia', label: 'Argélia' },
    { value: 'Argentina', label: 'Argentina' },
    { value: 'Armênia', label: 'Armênia' },
    { value: 'Austrália', label: 'Austrália' },
    { value: 'Áustria', label: 'Áustria' },
    { value: 'Azerbaijão', label: 'Azerbaijão' },
    { value: 'Bahamas', label: 'Bahamas' },
    { value: 'Bangladesh', label: 'Bangladesh' },
    { value: 'Barbados', label: 'Barbados' },
    { value: 'Barém', label: 'Barém' },
    { value: 'Bélgica', label: 'Bélgica' },
    { value: 'Belize', label: 'Belize' },
    { value: 'Benin', label: 'Benin' },
    { value: 'Bielorrússia', label: 'Bielorrússia' },
    { value: 'Bolívia', label: 'Bolívia' },
    { value: 'Bósnia e Herzegovina', label: 'Bósnia e Herzegovina' },
    { value: 'Botsuana', label: 'Botsuana' },
    { value: 'Brasil', label: 'Brasil' },
    { value: 'Brunei', label: 'Brunei' },
    { value: 'Bulgária', label: 'Bulgária' },
    { value: 'Burkina Faso', label: 'Burkina Faso' },
    { value: 'Burundi', label: 'Burundi' },
    { value: 'Butão', label: 'Butão' },
    { value: 'Cabo Verde', label: 'Cabo Verde' },
    { value: 'Camarões', label: 'Camarões' },
    { value: 'Camboja', label: 'Camboja' },
    { value: 'Canadá', label: 'Canadá' },
    { value: 'Catar', label: 'Catar' },
    { value: 'Cazaquistão', label: 'Cazaquistão' },
    { value: 'Chade', label: 'Chade' },
    { value: 'Chile', label: 'Chile' },
    { value: 'China', label: 'China' },
    { value: 'Chipre', label: 'Chipre' },
    { value: 'Colômbia', label: 'Colômbia' },
    { value: 'Comores', label: 'Comores' },
    { value: 'Congo-Brazzaville', label: 'Congo-Brazzaville' },
    { value: 'Congo-Kinshasa', label: 'Congo-Kinshasa' },
    { value: 'Coreia do Norte', label: 'Coreia do Norte' },
    { value: 'Coreia do Sul', label: 'Coreia do Sul' },
    { value: 'Costa do Marfim', label: 'Costa do Marfim' },
    { value: 'Costa Rica', label: 'Costa Rica' },
    { value: 'Croácia', label: 'Croácia' },
    { value: 'Cuba', label: 'Cuba' },
    { value: 'Dinamarca', label: 'Dinamarca' },
    { value: 'Djibuti', label: 'Djibuti' },
    { value: 'Dominica', label: 'Dominica' },
    { value: 'Egito', label: 'Egito' },
    { value: 'El Salvador', label: 'El Salvador' },
    { value: 'Emirados Árabes Unidos', label: 'Emirados Árabes Unidos' },
    { value: 'Equador', label: 'Equador' },
    { value: 'Eritreia', label: 'Eritreia' },
    { value: 'Eslováquia', label: 'Eslováquia' },
    { value: 'Eslovênia', label: 'Eslovênia' },
    { value: 'Espanha', label: 'Espanha' },
    { value: 'Estados Unidos', label: 'Estados Unidos' },
    { value: 'Estônia', label: 'Estônia' },
    { value: 'Etiópia', label: 'Etiópia' },
    { value: 'Fiji', label: 'Fiji' },
    { value: 'Filipinas', label: 'Filipinas' },
    { value: 'Finlândia', label: 'Finlândia' },
    { value: 'França', label: 'França' },
    { value: 'Gabão', label: 'Gabão' },
    { value: 'Gâmbia', label: 'Gâmbia' },
    { value: 'Gana', label: 'Gana' },
    { value: 'Geórgia', label: 'Geórgia' },
    { value: 'Grécia', label: 'Grécia' },
    { value: 'Guatemala', label: 'Guatemala' },
    { value: 'Guiana', label: 'Guiana' },
    { value: 'Guiné', label: 'Guiné' },
    { value: 'Guiné-Bissau', label: 'Guiné-Bissau' },
    { value: 'Guiné Equatorial', label: 'Guiné Equatorial' },
    { value: 'Haiti', label: 'Haiti' },
    { value: 'Holanda', label: 'Holanda' },
    { value: 'Honduras', label: 'Honduras' },
    { value: 'Hungria', label: 'Hungria' },
    { value: 'Islândia', label: 'Islândia' },
    { value: 'Índia', label: 'Índia' },
    { value: 'Indonésia', label: 'Indonésia' },
    { value: 'Irã', label: 'Irã' },
    { value: 'Iraque', label: 'Iraque' },
    { value: 'Irlanda', label: 'Irlanda' },
    { value: 'Israel', label: 'Israel' },
    { value: 'Itália', label: 'Itália' },
    { value: 'Jamaica', label: 'Jamaica' },
    { value: 'Japão', label: 'Japão' },
    { value: 'Jordânia', label: 'Jordânia' },
    { value: 'Kuwait', label: 'Kuwait' },
    { value: 'Líbano', label: 'Líbano' },
    { value: 'Líbia', label: 'Líbia' },
    { value: 'Liechtenstein', label: 'Liechtenstein' },
    { value: 'Lituânia', label: 'Lituânia' },
    { value: 'Luxemburgo', label: 'Luxemburgo' },
    { value: 'Malásia', label: 'Malásia' },
    { value: 'Malawi', label: 'Malawi' },
    { value: 'Maldivas', label: 'Maldivas' },
    { value: 'Mali', label: 'Mali' },
    { value: 'Malta', label: 'Malta' },
    { value: 'Marrocos', label: 'Marrocos' },
    { value: 'México', label: 'México' },
    { value: 'Moçambique', label: 'Moçambique' },
    { value: 'Mônaco', label: 'Mônaco' },
    { value: 'Nepal', label: 'Nepal' },
    { value: 'Nicarágua', label: 'Nicarágua' },
    { value: 'Nigéria', label: 'Nigéria' },
    { value: 'Noruega', label: 'Noruega' },
    { value: 'Nova Zelândia', label: 'Nova Zelândia' },
    { value: 'Omã', label: 'Omã' },
    { value: 'Países Baixos', label: 'Países Baixos' },
    { value: 'Paquistão', label: 'Paquistão' },
    { value: 'Paraguai', label: 'Paraguai' },
    { value: 'Peru', label: 'Peru' },
    { value: 'Polônia', label: 'Polônia' },
    { value: 'Portugal', label: 'Portugal' },
    { value: 'Quênia', label: 'Quênia' },
    { value: 'Reino Unido', label: 'Reino Unido' },
    { value: 'República Dominicana', label: 'República Dominicana' },
    { value: 'Romênia', label: 'Romênia' },
    { value: 'Rússia', label: 'Rússia' },
    { value: 'São Tomé e Príncipe', label: 'São Tomé e Príncipe' },
    { value: 'Senegal', label: 'Senegal' },
    { value: 'Sérvia', label: 'Sérvia' },
    { value: 'Singapura', label: 'Singapura' },
    { value: 'Síria', label: 'Síria' },
    { value: 'Somália', label: 'Somália' },
    { value: 'Sri Lanka', label: 'Sri Lanka' },
    { value: 'Suécia', label: 'Suécia' },
    { value: 'Suíça', label: 'Suíça' },
    { value: 'Suriname', label: 'Suriname' },
    { value: 'Tailândia', label: 'Tailândia' },
    { value: 'Taiwan', label: 'Taiwan' },
    { value: 'Tanzânia', label: 'Tanzânia' },
    { value: 'Tunísia', label: 'Tunísia' },
    { value: 'Turquia', label: 'Turquia' },
    { value: 'Ucrânia', label: 'Ucrânia' },
    { value: 'Uganda', label: 'Uganda' },
    { value: 'Uruguai', label: 'Uruguai' },
    { value: 'Vaticano', label: 'Vaticano' },
    { value: 'Venezuela', label: 'Venezuela' },
    { value: 'Vietnã', label: 'Vietnã' },
    { value: 'Zâmbia', label: 'Zâmbia' },
    { value: 'Zimbábue', label: 'Zimbábue' }
  ];

  readonly estacaoOptions: Array<object> = [
    { value: 'Primavera', label: 'Primavera' },
    { value: 'Verão', label: 'Verão' },
    { value: 'Outono', label: 'Outono' },
    { value: 'Inverno', label: 'Inverno' },
  ];

  readonly fields = [
    { property: 'nome', label: 'Ponto Turístico', gridColumns: 12 },
    { property: 'pais', label: 'País', options: this.paisOptions, gridColumns: 6 },
    { property: 'cidade', label: 'Cidade', gridColumns: 6 },
    { property: 'estacao', label: 'Estação do ano', options: this.estacaoOptions, gridColumns: 6 },
  ];

  readonly detailFields: Array<PoDynamicViewField> = [
    { property: 'nome', label: 'Ponto Turístico' },
    { property: 'pais', label: 'País' },
    { property: 'cidade', label: 'Cidade' },
    { property: 'estacao', label: 'Melhor estação do ano', tag: true },
    { property: 'resumo', label: 'Resumo' },
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
    this.mostrarCaixaComentario = false;
    this.comentarioDetail = '';
    this.DetailModal.open();
    this.carregarComentarios(ponto.id);
  }
}
