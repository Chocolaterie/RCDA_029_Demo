package fr.example.demo.injection;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class ServicePersonImpl extends ServicePerson {

	@Override
	public void test() {
		System.out.println("IMPL");
	}
	
}
