import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { ZooStoreService } from '../../services/zoo-store.service';

@Component({
  selector: 'app-cuidador-detail',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './cuidador-detail.html'
})
export class CuidadorDetailComponent implements OnInit, OnDestroy {
  constructor(
    private readonly route: ActivatedRoute,
    public readonly store: ZooStoreService
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.store.cargarDetalleCuidador(id);
  }

  ngOnDestroy(): void {
    this.store.limpiarDetalle();
  }
}
