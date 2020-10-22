package maha.io.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserDetailsService {

    public ResponseEntity<Map<String, String>> getUserDetails(){
        Map<String, String> resultMap = new HashMap<>();

       String users = restTemplate().exchange("http://localhost:8081/users", HttpMethod.GET, null, String.class).getBody();
       String address = restTemplate().exchange("http://localhost:8080/addresses", HttpMethod.GET, null, String.class).getBody();

        resultMap.put("users", users);
        resultMap.put("address", address);

        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
