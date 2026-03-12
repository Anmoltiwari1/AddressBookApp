package com.example.AddressBook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AddressBook.model.ContactPerson;

@Service
public class AddressBook {

	List<ContactPerson> persons=new ArrayList<>();
	
	public void addPerson( String firstName, String lastName, String address, String city, String state, int zip, String phoneNumber, String email) {
		
		for(ContactPerson person:persons) {
			if(person.getFirstName().equalsIgnoreCase(firstName) && person.getLastName().equalsIgnoreCase(lastName)) {
				return;
		}
	}
		ContactPerson person1=new ContactPerson(firstName,lastName,address,city,state,zip,phoneNumber,email);
		persons.add(person1);
		System.out.println("Person added");
	}
	
	public void editPerson(String firstName,String lastName,String newCity,String newState,String newPhoneNumber,String newEmail) {
		
		for(ContactPerson person:persons) {
			if(person.getFirstName().equalsIgnoreCase(firstName) && person.getLastName().equalsIgnoreCase(lastName)) {
				person.setFirstName(firstName);
				person.setLastName(lastName);
				person.setCity(newCity);
				person.setEmail(newEmail);
				person.setPhoneNumber(newPhoneNumber);
				System.out.println("Contact edited");
				return;
				
			}
			
		}
	}
	
	public void deletePerson(String firstName,String lastName) {
		for(ContactPerson person:persons) {
			if(person.getFirstName().equalsIgnoreCase(firstName) && person.getLastName().equalsIgnoreCase(lastName)) {
				persons.remove(person);
				System.out.println("Person removed");
				return;
			}
	}
		
	}
	
	public String displayDetails(String firstName,String lastName) {
		for(ContactPerson person:persons) {
			if(person.getFirstName().equalsIgnoreCase(firstName) && person.getLastName().equalsIgnoreCase(lastName)) {
				return person.getFirstName()+" "+person.getLastName()+" "+person.getAddress()+" "+person.getEmail();
			}
	}
		return "Person Not found";
}
}
