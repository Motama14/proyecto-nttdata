import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Animal, AnimalCreateRequest } from '../models/animal.model';

@Injectable({ providedIn: 'root' })
export class AnimalApiService {
  private readonly apiUrl = 'http://localhost:8080/api/animales';

  constructor(private readonly http: HttpClient) {}

  getAnimales(): Observable<Animal[]> {
    return this.http.get<Animal[]>(this.apiUrl);
  }

  getAnimal(id: number): Observable<Animal> {
    return this.http.get<Animal>(`${this.apiUrl}/${id}`);
  }

  createAnimal(request: AnimalCreateRequest): Observable<Animal> {
    return this.http.post<Animal>(this.apiUrl, request);
  }

  updateAnimal(id: number, request: AnimalCreateRequest): Observable<Animal> {
    return this.http.put<Animal>(`${this.apiUrl}/${id}`, request);
  }

  deleteAnimal(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
