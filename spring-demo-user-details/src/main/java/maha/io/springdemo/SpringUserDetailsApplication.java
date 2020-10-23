package maha.io.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class SpringUserDetailsApplication {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@LoadBalanced
	@Bean
	RestTemplate loadBalanced() {
		return  new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringUserDetailsApplication.class, args);
	}

}
