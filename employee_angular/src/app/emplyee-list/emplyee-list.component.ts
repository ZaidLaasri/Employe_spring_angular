import { Component } from '@angular/core';

import { EmployeeService } from '../employee.service';

import { OnInit } from '@angular/core';

import { Location } from '@angular/common';

import { Router } from '@angular/router';



@Component({
  selector: 'app-emplyee-list',
  templateUrl: './emplyee-list.component.html',
  styleUrls: ['./emplyee-list.component.css'],
  providers: [EmployeeService]
})
export class EmplyeeListComponent implements OnInit {

    employees: any;
    employee={
      id:"",
      firstName:"",
      lastName:"",
      emailAddress:""
    };


    constructor(private employeeService: EmployeeService, private location: Location, private router: Router) {}

  ngOnInit() {
    debugger
    console.log("On inite ......");
      this.employeeService.getEmployees().subscribe((datas) => {
        console.log(datas);
        debugger;
        this.employees=datas
      })
  }

  deleteEmployee(id: any){
    let ifconfirm = confirm("Are you sure you want to delete this user ?");
    if(ifconfirm){
      this.employeeService.deleteEmployee(id).subscribe(
        response => {
          // Ici, vous pouvez gérer la réponse, par exemple afficher un message de succès.
          
          // Puis, recharger la page
          window.location.reload();
        },
        error => {
          // Gérez les erreurs, par exemple afficher un message d'erreur.
        })
    };
  }
  employeeDetails(id: any){
    this.router.navigate(['/employee', id]);
  }
}
