package fr.example.demo.injection;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("mock")
public class ServicePersonMock extends ServicePerson {

}
