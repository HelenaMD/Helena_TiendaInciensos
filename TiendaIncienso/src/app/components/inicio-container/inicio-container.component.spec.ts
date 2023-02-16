import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InicioContainerComponent } from './inicio-container.component';

describe('InicioContainerComponent', () => {
  let component: InicioContainerComponent;
  let fixture: ComponentFixture<InicioContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InicioContainerComponent ]
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
