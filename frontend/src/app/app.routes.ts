import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { CuidadorListComponent } from './components/cuidador-list/cuidador-list.component';
import { CuidadorDetailComponent } from './components/cuidador-detail/cuidador-detail.component';
import { CuidadorFormComponent } from './components/cuidador-form/cuidador-form.component';
import { AnimalFormComponent } from './components/animal-form/animal-form.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'cuidadores', component: CuidadorListComponent },
  { path: 'cuidadores/nuevo', component: CuidadorFormComponent },
  { path: 'cuidadores/:id', component: CuidadorDetailComponent },
  { path: 'animales/nuevo', component: AnimalFormComponent },
  { path: '**', redirectTo: '' }
];
