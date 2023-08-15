package net.guides.springboot2.springboot2jpacrudexample.controller;

import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import net.guides.springboot2.springboot2jpacrudexample.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class EmployeController {

    @Autowired
    private EmployeService employeService;


    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        try {
            Employee employee = employeService.getEmployeeById(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeService.createEmploye(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        try {
            Employee employee = employeService.updateEmploye(id, updatedEmployee);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        try {
            employeService.deleteEmploye(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
