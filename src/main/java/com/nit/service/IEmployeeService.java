package com.nit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nit.model.Employee;

@Service
public interface IEmployeeService {

	public Integer saveEmployee(Employee e);
	public void updateEmployee(Employee e);
	public void deleteEmployee(Integer id);
	public Optional<Employee> getOneEmployee(Integer id);
	public List<Employee> getAllEmployees();
	public boolean isPresent(Integer id);
}
