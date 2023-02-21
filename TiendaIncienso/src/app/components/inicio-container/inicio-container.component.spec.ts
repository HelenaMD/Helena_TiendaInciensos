import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { ConexionService } from 'src/app/services/conexion.service';

import { InicioContainerComponent } from './inicio-container.component';

describe('InicioContainerComponent', () => {
  let component: InicioContainerComponent;
  let fixture: ComponentFixture<InicioContainerComponent>;
  let comunicaciones: ConexionService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InicioContainerComponent ],
      imports: [HttpClientTestingModule, RouterTestingModule, FormsModule]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InicioContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
