import { Component, inject, signal } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { CuidadorApiService } from '../../services/cuidador-api.service';

@Component({
  selector: 'app-cuidador-form',
  standalone: true,
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: 'cuidador-form.html'
})
export class CuidadorFormComponent {
  readonly guardando = signal(false);
  readonly mensajeError = signal<string | null>(null);
  readonly mensajeExito = signal<string | null>(null);

  readonly form = inject(FormBuilder).nonNullable.group({
    nombre: ['', [Validators.required, Validators.maxLength(80)]],
    apellidos: ['', [Validators.required, Validators.maxLength(120)]],
    email: ['', [Validators.required, Validators.email, Validators.maxLength(120)]],
    telefono: ['', [Validators.maxLength(20)]],
    especialidad: ['', [Validators.required, Validators.maxLength(80)]],
    turno: ['', [Validators.required]],
    fechaAlta: ['', [Validators.required]]
  });

  constructor(
    private readonly cuidadorApiService: CuidadorApiService,
    private readonly router: Router
  ) {}

  guardar(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    this.guardando.set(true);
    this.mensajeError.set(null);
    this.mensajeExito.set(null);

    this.cuidadorApiService.createCuidador(this.form.getRawValue()).subscribe({
      next: () => {
        this.mensajeExito.set('Cuidador creado correctamente.');
        this.guardando.set(false);
        this.router.navigate(['/cuidadores']);
      },
      error: () => {
        this.mensajeError.set('No se ha podido crear el cuidador. Revisa los datos introducidos.');
        this.guardando.set(false);
      }
    });
  }
}
