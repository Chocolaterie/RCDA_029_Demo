package fr.example.demo.injection;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

public class ServicePerson {

	int counter = 0;
	
	public void test() {
		counter++;
		System.out.println(counter);
	}
}
