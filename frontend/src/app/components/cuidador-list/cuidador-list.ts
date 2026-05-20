import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { ZooStoreService } from '../../services/zoo-store.service';

@Component({
  selector: 'app-cuidador-list',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './cuidador-list.html'
})
export class CuidadorListComponent implements OnInit {
  constructor(public readonly store: ZooStoreService) {}

  ngOnInit(): void {
    this.store.cargarCuidadores();
  }
}
