import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface PontoTuristico {
  id?: number;
  nome: string;
  pais: string;
  cidade: string;
  estacao: string;
  resumo: string;
}

@Injectable({
  providedIn: 'root'
})
export class PontoTuristicoService {

  private readonly API = 'http://localhost:8080/ponto-turistico';

  constructor(private http: HttpClient) {}

  getAll(): Observable<PontoTuristico[]> {
    return this.http.get<PontoTuristico[]>(this.API);
  }

  create(ponto: PontoTuristico): Observable<PontoTuristico> {
    return this.http.post<PontoTuristico>(this.API, ponto);
  }

  // Outros métodos como update e delete podem ser adicionados depois
}
