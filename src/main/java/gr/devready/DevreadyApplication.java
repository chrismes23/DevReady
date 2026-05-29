package gr.devready;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import services.CallService;

@SpringBootApplication
public class DevreadyApplication {

	public static CallService service;
	public static void main(String[] args) {
		service =new CallService();
		service.init();
		SpringApplication.run(DevreadyApplication.class, args);
		
	}

}
