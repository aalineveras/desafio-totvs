import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { PoNotificationService, PoBreadcrumb } from '@po-ui/ng-components';
import { HttpService } from 'src/app/service/http-service.service';

import { triggerFormValidators } from 'src/app/shared/util';

@Component({
  selector: 'app-cadastro-pontos-turisticos',
  templateUrl: './cadastro-pontos-turisticos.component.html',
})
export class CadastroPontosTuristicosComponent implements OnInit {
  idPontoTuristico: string;
  formPontoTuristico: FormGroup;
  title: string = 'Novo cadastro de Ponto Turístico';

  constructor(
    private formBuilder: FormBuilder,
    private poNotification: PoNotificationService,
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpService
  ) {
    this.formPontoTuristico = this.formBuilder.group({
      nome: ['', Validators.required],
      pais: ['', Validators.required],
      cidade: ['', Validators.required],
      estacao: ['', Validators.required],
      resumo: ['', Validators.required],
    });
  }

  readonly breadcrumb: PoBreadcrumb = {
    items: [
      { label: 'Home', link: '/' },
      { label: 'Ponto Turístico', link: '/' },
      { label: 'Novo Ponto Turístico', link: '/' },
    ],
  };

  readonly paisOptions: Array<object> = [
    { value: 'Brasil', label: 'Brasil' },
    { value: 'Argentina', label: 'Argentina' },
    { value: 'França', label: 'França' },
    { value: 'Itália', label: 'Itália' },
    { value: 'Estados Unidos', label: 'Estados Unidos' },
    // adicione outros conforme necessário
  ];

  readonly estacaoOptions: Array<object> = [
    { value: 'Primavera', label: 'Primavera' },
    { value: 'Verão', label: 'Verão' },
    { value: 'Outono', label: 'Outono' },
    { value: 'Inverno', label: 'Inverno' },
  ];

  ngOnInit(): void {
    this.idPontoTuristico = this.route.snapshot.paramMap.get('idPontoTuristico') || null;
    if (this.idPontoTuristico !== null) {
      this.buscaDadosPontoTuristico();
      this.title = 'Alteração do Ponto Turístico';
    }
  }

  salvar() {
    if (this.validarRegistro()) {
      if (this.idPontoTuristico === null) {
        this.enviarPost();
      } else {
        this.enviarPut();
      }
    } else {
      this.poNotification.error('Preencha todos os campos antes de salvar as alterações!');
    }
  }

  voltar() {
    this.router.navigate(['/ponto-turistico'], { relativeTo: this.route });
  }

  validarRegistro(): boolean {
    return this.formPontoTuristico.valid;
  }

  enviarPost() {
    this.http.post('ponto-turistico', this.formPontoTuristico.value).subscribe({
      next: () => {
        this.poNotification.success('Registro criado com sucesso!');
        this.voltar();
      },
      error: (erro) => {
        this.poNotification.error(erro);
      },
    });
  }

  enviarPut() {
    this.http.put('ponto-turistico/' + this.idPontoTuristico, this.formPontoTuristico.value).subscribe({
      next: () => {
        this.poNotification.success('Registro atualizado com sucesso!');
        this.voltar();
      },
      error: (erro) => {
        this.poNotification.error(erro);
      },
    });
  }

  buscaDadosPontoTuristico() {
    this.http.get('ponto-turistico/' + this.idPontoTuristico).subscribe({
      next: (resposta) => {
        this.formPontoTuristico.patchValue({
          nome: resposta.nome,
          pais: resposta.pais,
          cidade: resposta.cidade,
          estacao: resposta.estacao,
          resumo: resposta.resumo,
        });
      },
      error: (erro) => {
        this.poNotification.error(erro);
      },
    });
  }
}
