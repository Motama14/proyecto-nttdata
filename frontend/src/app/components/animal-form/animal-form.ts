import { Component, OnInit, inject, signal } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { Cuidador } from '../../models/cuidador.model';
import { AnimalApiService } from '../../services/animal-api.service';
import { CuidadorApiService } from '../../services/cuidador-api.service';

@Component({
  selector: 'app-animal-form',
  standalone: true,
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './animal-form.html'
})
export class AnimalFormComponent implements OnInit {
  readonly cuidadores = signal<Cuidador[]>([]);
  readonly guardando = signal(false);
  readonly mensajeError = signal<string | null>(null);
  readonly mensajeExito = signal<string | null>(null);

  readonly form = inject(FormBuilder).nonNullable.group({
    nombre: ['', [Validators.required, Validators.maxLength(80)]],
    especie: ['', [Validators.required, Validators.maxLength(80)]],
    habitat: ['', [Validators.maxLength(80)]],
    edad: [0, [Validators.required, Validators.min(0)]],
    estadoSalud: ['', [Validators.required, Validators.maxLength(120)]],
    fechaIngreso: ['', [Validators.required]],
    cuidadorId: [0, [Validators.required, Validators.min(1)]]
  });

  constructor(
    private readonly animalApiService: AnimalApiService,
    private readonly cuidadorApiService: CuidadorApiService,
    private readonly router: Router
  ) {}

  ngOnInit(): void {
    this.cuidadorApiService.getCuidadores().subscribe({
      next: (cuidadores) => this.cuidadores.set(cuidadores),
      error: () => this.mensajeError.set('No se han podido cargar los cuidadores.')
    });
  }

  guardar(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    this.guardando.set(true);
    this.mensajeError.set(null);
    this.mensajeExito.set(null);

    this.animalApiService.createAnimal(this.form.getRawValue()).subscribe({
      next: () => {
        this.mensajeExito.set('Animal creado correctamente.');
        this.guardando.set(false);
        this.router.navigate(['/cuidadores']);
      },
      error: () => {
        this.mensajeError.set('No se ha podido crear el animal. Revisa los datos introducidos.');
        this.guardando.set(false);
      }
    });
  }
}
