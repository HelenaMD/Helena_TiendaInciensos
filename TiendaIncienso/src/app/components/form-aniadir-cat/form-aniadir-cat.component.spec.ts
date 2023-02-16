import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormAniadirCatComponent } from './form-aniadir-cat.component';

describe('FormAniadirCatComponent', () => {
  let component: FormAniadirCatComponent;
  let fixture: ComponentFixture<FormAniadirCatComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormAniadirCatComponent ]
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
