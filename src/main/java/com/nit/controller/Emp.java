package com.nit.controller;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.model.Employee;
import com.nit.service.IEmployeeService;

@RestcController
public class Emp {

	@Autowired
	private IEmployeeService service;

	// 1 save student data
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Employee employee) {
		ResponseEntity<String> resp = null;
		try {
			Integer id = service.saveEmployee(employee);
			resp = new ResponseEntity<String>("Employee" + id + " created", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	// 2. fatch All Data
	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> resp = null;
		List<Employee> list = service.getAllEmployees();
		if (list == null || list.isEmpty()) {
			String message = "No Data Found!!";
			resp = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
		}
		return resp;
	}

	// 3.Delete Daata
	@DeleteMapping("/del/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
		ResponseEntity<String> resp = null;
		// check for Exist
		boolean present = service.isPresent(id);
		if (present) {
			// if exist
			service.deleteEmployee(id);
			resp = new ResponseEntity<String>("Deleted" + id + " successfully!", HttpStatus.OK);
		} else { // not exist
			resp = new ResponseEntity<String>("" + id + "Not Exist", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

	// 4. Updata Data
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Employee employee) {
		ResponseEntity<String> resp = null;

		// Check for id exist
		boolean present = service.isPresent(employee.getEmpId());
		if (present) { // if exist
			service.updateEmployee(employee);
			resp = new ResponseEntity<String>("UpDated Successfully!", HttpStatus.OK);
		} else { // Not Exist
			resp = new ResponseEntity<String>("Record " + employee.getEmpId() + "not Found", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

}
