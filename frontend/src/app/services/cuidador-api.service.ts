import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Animal } from '../models/animal.model';
import { Cuidador, CuidadorCreateRequest } from '../models/cuidador.model';

@Injectable({ providedIn: 'root' })
export class CuidadorApiService {
  private readonly apiUrl = 'http://localhost:8080/api/cuidadores';

  constructor(private readonly http: HttpClient) {}

  getCuidadores(): Observable<Cuidador[]> {
    return this.http.get<Cuidador[]>(this.apiUrl);
  }

  getCuidador(id: number): Observable<Cuidador> {
    return this.http.get<Cuidador>(`${this.apiUrl}/${id}`);
  }

  getAnimalesDeCuidador(id: number): Observable<Animal[]> {
    return this.http.get<Animal[]>(`${this.apiUrl}/${id}/animales`);
  }

  createCuidador(request: CuidadorCreateRequest): Observable<Cuidador> {
    return this.http.post<Cuidador>(this.apiUrl, request);
  }

  updateCuidador(id: number, request: CuidadorCreateRequest): Observable<Cuidador> {
    return this.http.put<Cuidador>(`${this.apiUrl}/${id}`, request);
  }

  deleteCuidador(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
