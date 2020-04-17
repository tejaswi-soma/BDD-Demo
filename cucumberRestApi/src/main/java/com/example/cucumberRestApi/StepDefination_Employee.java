package com.example.cucumberRestApi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import java.util.ArrayList;
import java.util.List;
import org.springframework.web.client.RestTemplate;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination_Employee {

	private RestTemplate restTemplate = new RestTemplate();
	private String defaultUrl = "http://localhost" + ":" + 8082;

	List<Employee> response = new ArrayList<>();
	String url = defaultUrl + "/employees/";

	@When("The client calls employee end point")
	public void the_client_calls_employee_end_point() throws Exception {

		response = restTemplate.getForObject(url, List.class);
		assertNotNull(response);
	}

	@Then("The client receives answer as emp_id {}, first_name {}, last_name {} and email {}")
	public void the_client_receives_answer_as(Long id, String firstName, String lastName, String email) {

		String url = defaultUrl + "/employees/" + id;

		Employee emp = restTemplate.getForObject(url, Employee.class);

		assertEquals(id, emp.getId());
		assertEquals(firstName, emp.getFirstName());
		assertEquals(lastName, emp.getLastName());
		assertEquals(email, emp.getEmail());

	}

	
}
