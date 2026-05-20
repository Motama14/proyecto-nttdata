import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CuidadorDetail } from './cuidador-detail';

describe('CuidadorDetail', () => {
  let component: CuidadorDetail;
  let fixture: ComponentFixture<CuidadorDetail>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CuidadorDetail]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CuidadorDetail);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
