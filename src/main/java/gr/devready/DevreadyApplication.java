package gr.devready;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import models.Call;
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
