import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CatMaincontainerComponent } from './cat-maincontainer.component';

describe('CatMaincontainerComponent', () => {
  let component: CatMaincontainerComponent;
  let fixture: ComponentFixture<CatMaincontainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CatMaincontainerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CatMaincontainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
