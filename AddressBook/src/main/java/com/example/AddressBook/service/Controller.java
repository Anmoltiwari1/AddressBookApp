package com.example.AddressBook.service;

import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AddressBook.model.ContactPerson;

@RestController
@RequestMapping("/contacts")
public class Controller {
	
	@Autowired
	private AddressBook addressBook;

	@PostMapping("/add")
	public String addPerson(@RequestBody ContactPerson Person) {
		
		addressBook.addPerson(
				Person.getFirstName(), 
				Person.getLastName(), 
				Person.getAddress(), 
				Person.getCity(), 
				Person.getState(), 
				Person.getZip(), 
				Person.getPhoneNumber(), 
				Person.getEmail()
				);
		return "Person added";
	}
	
	@DeleteMapping("/{firstName}/{lastName}")
	public String deletePerson(@PathVariable String firstName,@PathVariable String lastName) {
		
		addressBook.deletePerson(firstName,lastName);		
		return "Person Deleted";
	}
	
	@GetMapping("/person/{firstName}/{lastName}")
	public String getperson(@PathVariable String firstName,@PathVariable String lastName) {
		
		return addressBook.displayDetails(firstName, lastName);
	}
}
