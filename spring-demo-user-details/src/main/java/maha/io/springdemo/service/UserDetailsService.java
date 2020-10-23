package maha.io.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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

    @Value("${external-service.user-service}")
    private String userServiceUrl;

    @Value("${external-service.address-service}")
    private String addressSetviceUrl;

    @Autowired
    private RestTemplate loadBalanced;

    public ResponseEntity<Map<String, String>> getUserDetails(){
        Map<String, String> resultMap = new HashMap<>();

       String users = loadBalanced.exchange("http://userservice/users", HttpMethod.GET, null, String.class).getBody();
       String address = loadBalanced.exchange(addressSetviceUrl, HttpMethod.GET, null, String.class).getBody();

        resultMap.put("users", users);
        resultMap.put("address", address);

        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }
}
