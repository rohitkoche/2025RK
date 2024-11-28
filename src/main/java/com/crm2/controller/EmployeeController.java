package com.crm2.controller;

import com.crm2.Payload.EmployeeDto;
import com.crm2.entity.Employee;
import com.crm2.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //http://localhost:8080/api/v1/employee/add
    @PostMapping("/add")
//    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto dto) {
//       EmployeeDto  employeeDto =  employeeService.addEmployee(dto);
//        return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
    // for validation
    public ResponseEntity<?> addEmployee(@Valid @RequestBody EmployeeDto dto, BindingResult result) {
        if(result.hasErrors()){
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        EmployeeDto  employeeDto =  employeeService.addEmployee(dto);
        return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/v1/employee?id=1
    @DeleteMapping
    public ResponseEntity<String> deleteEmployee(@RequestParam Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("deleted",HttpStatus.OK);
    }

    //http://localhost:8080/api/v1/employee?id=2
    @PutMapping
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto dto , @RequestParam Long id) {
        EmployeeDto  employeeDto =  employeeService.updateEmployee(dto,id);

        return new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity<List<EmployeeDto>> getEmployees() {
//       List<EmployeeDto> employeesDto =  employeeService.getEmployee();
//        return new ResponseEntity<>(employeesDto,HttpStatus.OK);
//    }
    
    //For Pagination
    //http://localhost:8080/api/v1/employee?pageNo=0&pageSize=5&sortBy=email&sortDir=desc
    @GetMapping
    public ResponseEntity<List<EmployeeDto>>getEmployees(
            @RequestParam(name = "pageNo",defaultValue = "0",required = false)int pageNo,
            @RequestParam(name = "pageSize",defaultValue = "5",required = false)int pageSize,
            @RequestParam(name = "sortBy",defaultValue = "name",required = false)String sortBy,
            @RequestParam(name = "sortDir",defaultValue = "dsc",required = false)String sortDir
            ){
        List<EmployeeDto> employeeDto = employeeService.getEmployee(pageNo, pageSize,sortBy,sortDir);
        return new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }
    
    //http://localhost:8080/api/v1/employee/employeeId/{empId}
    @GetMapping("/employeeId/{empId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable long empId) {
      EmployeeDto dto =  employeeService.getEmployeeById(empId);
      return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}