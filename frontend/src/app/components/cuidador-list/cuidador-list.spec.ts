import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CuidadorList } from './cuidador-list';

describe('CuidadorList', () => {
  let component: CuidadorList;
  let fixture: ComponentFixture<CuidadorList>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CuidadorList]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CuidadorList);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
