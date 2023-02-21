import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CategoriaCardComponent } from '../categoria-card/categoria-card.component';
import { HttpClientTestingModule } from '@angular/common/http/testing';

import { CatMaincontainerComponent } from './cat-maincontainer.component';

describe('CatMaincontainerComponent', () => {
  let component: CatMaincontainerComponent;
  let fixture: ComponentFixture<CatMaincontainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CatMaincontainerComponent, CategoriaCardComponent ],
      imports: [HttpClientTestingModule]
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
