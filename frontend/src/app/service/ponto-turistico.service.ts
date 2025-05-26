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

  constructor(private http: HttpClient) { }

  getAll(): Observable<PontoTuristico[]> {
    return this.http.get<PontoTuristico[]>(this.API);
  }

  create(ponto: PontoTuristico): Observable<PontoTuristico> {
    return this.http.post<PontoTuristico>(this.API, ponto);
  }
  obterPorPonto(pontoId: number): Observable<any[]> {
    return this.http.get<any[]>(`http://localhost:8080/comentarios/ponto/${pontoId}`);
  }

  criar(comentario: any): Observable<any> {
    return this.http.post<any>('http://localhost:8080/comentarios', comentario);
  }
}
