import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';
import { BarranavComponent } from './components/barranav/barranav.component';
import { CatMaincontainerComponent } from './components/cat-maincontainer/cat-maincontainer.component';
import { CategoriaCardComponent } from './components/categoria-card/categoria-card.component';
import { InicioContainerComponent } from './components/inicio-container/inicio-container.component';
import { FormAniadirCatComponent } from './components/form-aniadir-cat/form-aniadir-cat.component';

describe('AppComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RouterTestingModule],
      declarations: [
        AppComponent,
        BarranavComponent,
        CatMaincontainerComponent,
        CategoriaCardComponent,
        InicioContainerComponent,
        FormAniadirCatComponent
      ],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'TiendaIncienso'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('TiendaIncienso');
  });

  // it('should render title', () => {
  //   const fixture = TestBed.createComponent(AppComponent);
  //   fixture.detectChanges();
  //   const compiled = fixture.nativeElement as HTMLElement;
  //   expect(compiled.querySelector('.content span')?.textContent).toContain('TiendaIncienso app is running!');
  // });
});
