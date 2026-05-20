import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CuidadorForm } from './cuidador-form';

describe('CuidadorForm', () => {
  let component: CuidadorForm;
  let fixture: ComponentFixture<CuidadorForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CuidadorForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CuidadorForm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
