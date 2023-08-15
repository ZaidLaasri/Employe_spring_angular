package net.guides.springboot2.springboot2jpacrudexample.service;


import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import net.guides.springboot2.springboot2jpacrudexample.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {

    @Autowired
    private EmployeRepository employeeRepository;


    public List<Employee> getAllEmployees() {
        List<Employee> emps = new ArrayList<>();
         employeeRepository.findAll().forEach(emp -> {
            emps.add(emp);
        });
         return  emps;
    }



    public Employee getEmployeeById(Long id) {
        Optional<Employee> employeeOpt = employeeRepository.findById(id);
        if (employeeOpt.isPresent()) {
            return employeeOpt.get();
        } else {
            throw new RuntimeException("Employee not found with ID: " + id);
        }
    }

    public Employee createEmploye(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmploye(Long id, Employee updatedEmployee) {
        if (employeeRepository.existsById(id)) {
            updatedEmployee.setId(id);
            return employeeRepository.save(updatedEmployee);
        } else {
            throw new RuntimeException("Employee not found with ID: " + id);
        }
    }

    public void deleteEmploye(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Employee not found with ID: " + id);
        }
    }



}
