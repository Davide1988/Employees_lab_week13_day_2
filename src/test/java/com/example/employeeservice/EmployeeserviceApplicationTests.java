package com.example.employeeservice;

import com.example.employeeservice.model.Department;
import com.example.employeeservice.model.Employee;
import com.example.employeeservice.model.Project;
import com.example.employeeservice.repository.DepartmentRepository;
import com.example.employeeservice.repository.EmployeeRepository;
import com.example.employeeservice.repository.ProjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeserviceApplicationTests {


	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createDepartmentAndEmployee(){

		Department department = new Department("IT");
		departmentRepository.save(department);

		Project project = new Project("Google",2);
		projectRepository.save(project);


		Employee employee = new Employee("Albert", 32, 400, "abababba@bala.com", department);
		employeeRepository.save(employee);

		project.addEmployee(employee);
		projectRepository.save(project);

	}



}
