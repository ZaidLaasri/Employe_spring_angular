import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { EmplyeeListComponent } from './emplyee-list/emplyee-list.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';

const routes: Routes = [
  { path: '', component: EmplyeeListComponent },
  {path:'employee/:id', component:EmployeeDetailsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
