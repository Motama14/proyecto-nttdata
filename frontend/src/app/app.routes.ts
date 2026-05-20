import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home';
import { CuidadorListComponent } from './components/cuidador-list/cuidador-list';
import { CuidadorDetailComponent } from './components/cuidador-detail/cuidador-detail';
import { CuidadorFormComponent } from './components/cuidador-form/cuidador-form';
import { AnimalFormComponent } from './components/animal-form/animal-form';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'cuidadores', component: CuidadorListComponent },
  { path: 'cuidadores/nuevo', component: CuidadorFormComponent },
  { path: 'cuidadores/:id', component: CuidadorDetailComponent },
  { path: 'animales/nuevo', component: AnimalFormComponent },
  { path: '**', redirectTo: '' }
];
