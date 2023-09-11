import { Injectable } from '@angular/core';


import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  readonly API_URl = "http://localhost:8080/springboot-crud-rest/api/v1"

  readonly ENDPOINT_EMPLOYEES="/employees"

  constructor(private httpClient : HttpClient) { }

  getEmployees(){
    return this.httpClient.get(this.API_URl+this.ENDPOINT_EMPLOYEES)
  }

  deleteEmployee(id: any){
    return this.httpClient.delete(this.API_URl+this.ENDPOINT_EMPLOYEES+"/"+id);
  }

  getEmployeesDetails(id: any){
    return this.httpClient.get(this.API_URl+this.ENDPOINT_EMPLOYEES+"/"+id);
  }

}
