import { Component } from '@angular/core';

import { OnInit } from '@angular/core';

import { ActivatedRoute } from '@angular/router';

import { EmployeeService } from '../employee.service';


@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {
id: any;
employee: any


isDisabled = true; // Initialisé à 'true' pour que les champs soient désactivés au début

constructor(private route:ActivatedRoute, private employeeService:EmployeeService){}

  ngOnInit() {

    this.id = this.route.snapshot.paramMap.get('id');
    this.employeeService.getEmployeesDetails(this.id).subscribe((datas) => {
      console.log(datas);
      debugger;
      this.employee=datas
    })
  }
}
