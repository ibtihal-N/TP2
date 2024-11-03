package ma.enset.customer_service;

import ma.enset.customer_service.entities.Customer;
import ma.enset.customer_service.repo.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
			customerRepository.saveAll(List.of(
					Customer.builder().name("mohammed").email("med@gmail.com").build(),
					Customer.builder().name("hassan").email("hassan@gmail.com").build(),
					Customer.builder().name("Imane").email("imane@gmail.com").build()
			));
			customerRepository.findAll().forEach(System.out::println);
		};
	}
}
