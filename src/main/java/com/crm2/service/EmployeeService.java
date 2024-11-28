package com.crm2.service;

import com.crm2.Payload.EmployeeDto;
import com.crm2.entity.Employee;
import com.crm2.exception.ResourceNotFound;
import com.crm2.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
private EmployeeRepository employeeRepository;
private ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }
    public EmployeeDto addEmployee(EmployeeDto dto) {
        Employee employee = mapToEntity(dto);
        Employee emp = employeeRepository.save(employee);
        EmployeeDto employeeDto = mapToDto(emp);

        // employeeDto.setDate(new Date());

        return employeeDto;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public EmployeeDto updateEmployee(EmployeeDto dto, Long id) {
//       Optional<Employee> opEmp = employeeRepository.findById(id);
//       Employee employee = opEmp.get();
//       employee.setName(dto.getName());
//       employee.setEmailId(dto.getEmailId());
//       employee.setMobile(dto.getMobile());
        Employee employee = mapToEntity(dto);
        employee.setId(id);
       Employee updatedEmployee = employeeRepository.save(employee);
       EmployeeDto employeeDto = mapToDto(updatedEmployee);
       return employeeDto;
    }

//    public List<EmployeeDto> getEmployee() {
//
//         List<Employee> employees =  employeeRepository.findAll();
//        List<EmployeeDto> dto =   employees.stream().map(e->mapToDto(e)).collect(Collectors.toList());
//        return dto;
// }

    //For Pagination
    public List<EmployeeDto> getEmployee(int pageNo,int pageSize,String sortBy,String sortDir) {
      Sort sort =  sortDir.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();//here we use ternary operator(:)
       Pageable pageable = PageRequest.of(pageNo, pageSize, sort);//Sort.by(sortBy) helps or it convert String to Sort object
        Page<Employee> employees = employeeRepository.findAll(pageable);
        List<EmployeeDto> dto = employees.stream().map(e -> mapToDto(e)).collect(Collectors.toList());
        return dto;
    }
    //converting entity to Dto
  EmployeeDto  mapToDto(Employee employee) {
        EmployeeDto dto = modelMapper.map(employee , EmployeeDto.class);
//      EmployeeDto dto = new EmployeeDto();
//      dto.setId(employee.getId());
//      dto.setName(employee.getName());
//      dto.setEmailId(employee.getEmailId());
//      dto.setMobile(employee.getMobile());
      return dto;

  }
      //converting Dto to Entity
      Employee  mapToEntity(EmployeeDto dto){
        Employee emp =modelMapper.map(dto, Employee.class);
//          Employee emp = new Employee();
//         emp.setId(dto.getId());
//          emp.setName(dto.getName());
//          emp.setEmailId(dto.getEmailId());
//          emp.setMobile(dto.getMobile());
          return emp;

    }

    public EmployeeDto getEmployeeById(long empId) {
        //find by employee Id
//       Optional<Employee> opEmp =  employeeRepository.findById(empId);
//      Employee employee =  opEmp.get();
//      return mapToDto(employee);

        // Exception handling
      Employee employee =   employeeRepository.findById(empId).orElseThrow(
                ()->new ResourceNotFound("Employee not found with id:"+empId)
        );
     EmployeeDto dto =   mapToDto(employee);
     return dto;
    }
}

