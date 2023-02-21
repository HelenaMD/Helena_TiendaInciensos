import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { ConexionService } from 'src/app/services/conexion.service';

import { FormAniadirCatComponent } from './form-aniadir-cat.component';

describe('FormAniadirCatComponent', () => {
  let component: FormAniadirCatComponent;
  let fixture: ComponentFixture<FormAniadirCatComponent>;
  let comunicaciones: ConexionService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormAniadirCatComponent ],
      imports: [HttpClientTestingModule, RouterTestingModule, FormsModule]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormAniadirCatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
