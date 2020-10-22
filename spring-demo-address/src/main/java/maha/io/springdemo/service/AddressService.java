package maha.io.springdemo.service;

import maha.io.springdemo.entity.Address;
import maha.io.springdemo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public void saveAddress(Address address){
        addressRepository.save(address);
    }

    public List<Address> getAddresses(){
        return addressRepository.findAll();
    }

    public Optional<Address> getAddress(Long id){
        return addressRepository.findById(id);
    }
}
