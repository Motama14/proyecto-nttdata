export interface Animal {
  id: number;
  nombre: string;
  especie: string;
  habitat: string;
  edad: number;
  estadoSalud: string;
  fechaIngreso: string;
  cuidadorId: number;
  nombreCuidador: string;
}

export interface AnimalCreateRequest {
  nombre: string;
  especie: string;
  habitat: string;
  edad: number;
  estadoSalud: string;
  fechaIngreso: string;
  cuidadorId: number;
}
