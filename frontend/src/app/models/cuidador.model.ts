export interface Cuidador {
  id: number;
  nombre: string;
  apellidos: string;
  email: string;
  telefono: string;
  especialidad: string;
  turno: string;
  fechaAlta: string;
  numeroAnimales: number;
}

export interface CuidadorCreateRequest {
  nombre: string;
  apellidos: string;
  email: string;
  telefono: string;
  especialidad: string;
  turno: string;
  fechaAlta: string;
}
