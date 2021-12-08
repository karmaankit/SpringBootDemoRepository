package com.nit.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.model.Employee;

@RestController
public class EmployeeController {

	@GetMapping("/showA")
	public String showA() {
		return "Hello-String";
	}
	
	@GetMapping("/showB")
	public Employee showB() {
		return new Employee(22,"Ankit",3.8);
	}
	
	@GetMapping("/showC")
	public List<Employee> showC(){
		return Arrays.asList(new Employee(23,"Arun",3.9),
				new Employee(23,"jay",7.9),
				new Employee(23,"sunil",2.6),
				new Employee(23,"lali",10.9));
	}
	
	@GetMapping("/showD")
	public Map<String, Employee> showD(){ 
	Map<String,Employee> map=new HashMap<>();
	map.put("e1",new Employee(22,"Ankit",6.3));
	map.put("e2",new Employee(23,"kunal",2.3));
	map.put("e3",new Employee(24,"roshni",5.2));
	map.put("e4",new Employee(25,"manish",2.8));
	map.put("e5",new Employee(26,"joy",4.2));
	return map;

	}}
