package gr.devready;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import services.CallService;

@SpringBootApplication
public class DevreadyApplication {

	public static CallService service;
	public static void main(String[] args) {
		
		SpringApplication.run(DevreadyApplication.class, args);
		
	}

	@Bean
    CommandLineRunner init() {
        return args -> {
            service=new CallService();
			service.init();
        };
    }

}
