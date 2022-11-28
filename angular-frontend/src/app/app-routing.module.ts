import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreatePacientComponent } from './create-pacient/create-pacient.component';
import { PacientListComponent } from './pacient-list/pacient-list.component';
import { UpdatePacientComponent } from './update-pacient/update-pacient.component';
import { PacientDetailsComponent } from './pacient-details/pacient-details.component';


const routes: Routes = [
  {path: 'pacients', component: PacientListComponent},
  {path: '', redirectTo: 'pacients', pathMatch: 'full'},
  {path: 'create-pacient', component: CreatePacientComponent},
  {path: 'update-pacient/:id', component: UpdatePacientComponent},
  {path: 'pacient-details/:id', component: PacientDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
