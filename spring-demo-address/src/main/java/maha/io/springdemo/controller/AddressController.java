package maha.io.springdemo.controller;

import maha.io.springdemo.entity.Address;
import maha.io.springdemo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<String> createAddress(@RequestBody Address address){
        addressService.saveAddress(address);
        return new ResponseEntity<>(":Successfully Created", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAddresses(){
        List<Address> addresses = addressService.getAddresses();
        if(!CollectionUtils.isEmpty(addresses)) {
            return new ResponseEntity<>(addresses, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable("id") Long addressId){
        Optional<Address> addresses = addressService.getAddress(addressId);
        if(addresses.isPresent()) {
            return new ResponseEntity<>(addresses.get(), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }
}
