import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditCardComponent } from './edit-card/edit-card.component';
import { ViewCardComponent } from './view-card/view-card.component';

const routes: Routes = [{
  path:'',component:EditCardComponent
},{
  path:'view',component:ViewCardComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
