import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CatMaincontainerComponent } from './components/cat-maincontainer/cat-maincontainer.component';
import { CategoriaCardComponent } from './components/categoria-card/categoria-card.component';
import { FormAniadirCatComponent } from './components/form-aniadir-cat/form-aniadir-cat.component';
import { InicioContainerComponent } from './components/inicio-container/inicio-container.component';

const routes: Routes = [
  {path:'formcat/:act/:id', component:FormAniadirCatComponent},
  {path:'formcat/:act', component:FormAniadirCatComponent},
  {path:'categoria', component:CatMaincontainerComponent},
  {path:'inicio', component:InicioContainerComponent},
  {path:'', redirectTo:'/inicio', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
