package com.example.demo.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.payload.ApiResponse;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;


@Service
public class EmployeeServiceImplement implements  EmployeeService{
	
	@Autowired
	EmployeeRepository  empRespository;

	@Override
	public ResponseEntity<ApiResponse<EmployeeEntity>> CreateEmployee( EmployeeEntity employee) {
		EmployeeEntity newemployee = new EmployeeEntity();
		
		 newemployee.setName(employee.getName());
		 newemployee.setGender(employee.getGender());
		 newemployee .setAddress(employee.getAddress());
		 newemployee.setCity(employee.getCity());
		 newemployee .setDob(employee.getDob());
		 newemployee .setPassword(employee.getPassword());
		 newemployee .setState(employee.getState());
		 newemployee.setLoginId(employee.getLoginId());
		
		 EmployeeEntity savedEmployee=   empRespository.save(newemployee);
		 
		 return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>("Ok","success","EmployeeCreatedSuccesfully",savedEmployee));
		
	}

	@Override
	public ResponseEntity<ApiResponse<List<EmployeeEntity>>> getAllEmployee() {
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>("Ok","success","EmployeeFetchedSuccesfully",empRespository.findAll()));
		
	}

	@Override
	public ResponseEntity<ApiResponse<EmployeeEntity>> getByEmpId(Long id) {
	
		return  ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>("Ok","success","EmployeeFetchedSuccesfully",empRespository.findById(id).get()));
		
	}

	@Override
	public ResponseEntity<ApiResponse<EmployeeEntity>> updateById(Long id, EmployeeEntity employee) {
		
		Optional<EmployeeEntity> AvailableEmployee = empRespository.findById(id);
		
		if (!AvailableEmployee.isPresent()) {
			
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>("404" ,"Not success","Check Employee id again",null));
			}
		
		EmployeeEntity existingEmployee = AvailableEmployee.get();
		
		 existingEmployee.setName(employee.getName());
		 existingEmployee.setGender(employee.getGender());
		 existingEmployee.setAddress(employee.getAddress());
		 existingEmployee.setCity(employee.getCity());
		 existingEmployee.setDob(employee.getDob());
		 existingEmployee.setPassword(employee.getPassword());
		 existingEmployee.setState(employee.getState());
		 existingEmployee.setLoginId(employee.getLoginId());
		 EmployeeEntity savedEmployee=   empRespository.save(existingEmployee);
		 
		
		return  ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>("Ok","success","EmployeeDataFetchedSuccesfully",savedEmployee));
		
		
	}

	@Override
	public ResponseEntity<ApiResponse<String>> deleteById(Long id) {
		
     Optional<EmployeeEntity> AvailableEmployee = empRespository.findById(id);
		
		if (!AvailableEmployee.isPresent()) {
			
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>("404" ,"Not success","Check Employee id again",null));
			}
		
		empRespository.deleteById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>("ok","success","EmployeeDeletedSuccesfully","employee with "+id+" is deleted succesfully"));
		
	}

	@Override
	public ResponseEntity<ApiResponse<String>> login(String loginId, String password) {
	    Optional<EmployeeEntity> employeeOpt = empRespository.findByLoginId(loginId);
	    
	    // Print the loginId for debugging
	    System.out.println("Login ID: " + loginId);

	    if (employeeOpt.isPresent()) {
	        EmployeeEntity employee = employeeOpt.get();
	        
	        // Assuming passwords are stored hashed. Use passwordEncoder to match.
	        if (employee.getPassword().equals(password)) { 
	            String employeeName = employee.getName(); 
	            
	            System.out.println(employeeName);
	            
	            return ResponseEntity.status(HttpStatus.OK)
	                .body(new ApiResponse<>("200", null, employee.getId().toString(), employee.getId().toString()));
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED) // Change to UNAUTHORIZED
	                .body(new ApiResponse<>("401", "Not success", "Wrong password", null));
	        }
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	            .body(new ApiResponse<>("404", "Not success", "Employee not found", null));
	    }
	}

	@Override
	public ResponseEntity<ApiResponse<String>> loginn(EmployeeEntity emp) {
		// TODO Auto-generated method stub
		 Optional<EmployeeEntity> employeeOpt = empRespository.findByLoginId(emp.getLoginId());
		    


		    if (employeeOpt.isPresent()) {
		        EmployeeEntity employee = employeeOpt.get();
		        
		        // Assuming passwords are stored hashed. Use passwordEncoder to match.
		        if (employee.getPassword().equals(emp.getPassword())) { 
		            String employeeName = employee.getName(); 
		            
		            System.out.println(employeeName);
		            
		            return ResponseEntity.status(HttpStatus.OK)
		                .body(new ApiResponse<>("200", null, employee.getId().toString(), employee.getId().toString()));
		        } else {
		            return ResponseEntity.status(HttpStatus.UNAUTHORIZED) // Change to UNAUTHORIZED
		                .body(new ApiResponse<>("401", "Not success", "Wrong password", null));
		        }
		    } else {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND)
		            .body(new ApiResponse<>("404", "Not success", "Employee not found", null));
		    }
	}

	@Override
	public ResponseEntity<ApiResponse<List<EmployeeEntity>>> getEmpNotById(Long id) {
		// TODO Auto-generated method stub
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>("Ok","success","EmployeeFetchedSuccesfully",empRespository.findByIdNot(id)));
		
	}


}
