package com.example.demo.controller;

import com.example.demo.model.Address;
import com.example.demo.repos.AddressRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

@RestController
public class AddressController {

    private AddressRepo addressRepo;

    @Autowired
    public AddressController(AddressRepo addressRepo){
        this.addressRepo = addressRepo;
    }

    @GetMapping(value = "/address")
    public ModelAndView getXSLAddresses() throws JsonProcessingException {
        String data = new XmlMapper().writeValueAsString(addressRepo.findAll());
        ModelAndView modelAndView = new ModelAndView("address-list");
        Source src = new StreamSource(new StringReader(data));
        modelAndView.addObject("AddressList", src);
        return modelAndView;
    }

    @GetMapping(value = "/getAllAddresses", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE  })
    public Iterable<Address> getAllAddresses(){
        return addressRepo.findAll();
    }

    @GetMapping(value = "/getAddressById", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE  })
    public Address getAddressById(@PathParam("id") int id) {
        return addressRepo.findById(id).get();
    }

    @PostMapping("/createAddress")
    public void createAddress(@RequestBody Address addressToCreate){
        addressRepo.save(addressToCreate);
    }

    @PutMapping("/updateAddress")
    public void updateAddress(@RequestBody Address addressToUpdate){
        addressRepo.save(addressToUpdate);
    }

    @DeleteMapping("/deleteAddress")
    public void deleteAddress(@PathParam("id") int id){
        if (addressRepo.existsById(id)){
            addressRepo.deleteById(id);
        }
    }

    @DeleteMapping("/deleteAllAddresses")
    public void deleteAllAddresses(){
        addressRepo.deleteAll();
    }

}
