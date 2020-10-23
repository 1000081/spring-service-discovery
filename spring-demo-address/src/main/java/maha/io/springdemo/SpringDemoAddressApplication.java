package maha.io.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringDemoAddressApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoAddressApplication.class, args);
	}

}
