import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatePacientComponent } from './create-pacient.component';

describe('CreatePacientComponent', () => {
  let component: CreatePacientComponent;
  let fixture: ComponentFixture<CreatePacientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreatePacientComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreatePacientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
