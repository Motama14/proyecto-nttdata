import { computed, Injectable, signal } from '@angular/core';
import { forkJoin } from 'rxjs';
import { Animal } from '../models/animal.model';
import { Cuidador } from '../models/cuidador.model';
import { CuidadorApiService } from './cuidador-api.service';

@Injectable({ providedIn: 'root' })
export class ZooStoreService {
  readonly cuidadores = signal<Cuidador[]>([]);
  readonly cuidadorSeleccionado = signal<Cuidador | null>(null);
  readonly animalesDelCuidador = signal<Animal[]>([]);
  readonly cargando = signal(false);
  readonly mensajeError = signal<string | null>(null);

  readonly totalCuidadores = computed(() => this.cuidadores().length);
  readonly totalAnimalesDelCuidador = computed(() => this.animalesDelCuidador().length);

  constructor(private readonly cuidadorApiService: CuidadorApiService) {}

  cargarCuidadores(): void {
    this.cargando.set(true);
    this.mensajeError.set(null);

    this.cuidadorApiService.getCuidadores().subscribe({
      next: (cuidadores) => {
        this.cuidadores.set(cuidadores);
        this.cargando.set(false);
      },
      error: () => {
        this.mensajeError.set('No se han podido cargar los cuidadores. Revisa que el backend esté encendido.');
        this.cargando.set(false);
      }
    });
  }

  cargarDetalleCuidador(id: number): void {
    this.cargando.set(true);
    this.mensajeError.set(null);

    forkJoin({
      cuidador: this.cuidadorApiService.getCuidador(id),
      animales: this.cuidadorApiService.getAnimalesDeCuidador(id)
    }).subscribe({
      next: ({ cuidador, animales }) => {
        this.cuidadorSeleccionado.set(cuidador);
        this.animalesDelCuidador.set(animales);
        this.cargando.set(false);
      },
      error: () => {
        this.mensajeError.set('No se ha podido cargar el detalle del cuidador.');
        this.cargando.set(false);
      }
    });
  }

  limpiarDetalle(): void {
    this.cuidadorSeleccionado.set(null);
    this.animalesDelCuidador.set([]);
  }
}
