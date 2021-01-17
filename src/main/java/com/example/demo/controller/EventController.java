package com.example.demo.controller;

import com.example.demo.model.Event;
import com.example.demo.repos.EventRepo;
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
public class EventController {
    private EventRepo eventRepo;

    @Autowired(required = true)
    public void setEventRepo(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    @GetMapping("events")
    public ModelAndView getXSLEvents() throws JsonProcessingException {
        String data = new XmlMapper().writeValueAsString(eventRepo.findAll());
        ModelAndView modelAndView = new ModelAndView("event-list");
        Source src = new StreamSource(new StringReader(data));
        modelAndView.addObject("EventList", src);
        return modelAndView;
    }

    @GetMapping(value = "/getAllEvents", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE  })
    public Iterable<Event> getAllBooks() {
        return eventRepo.findAll();
    }

    @GetMapping("/getEventById")
    public Event getEventById(@PathParam("id") int id) throws Exception {
        return eventRepo.findById(id).get();
    }

    @PostMapping("/createEvent")
    public void createEvent(@RequestBody Event event) {
        eventRepo.save(event);
    }

    @PutMapping("/updateEvent")
    public void updateEvent(@RequestBody Event eventToUpdate) {
        eventRepo.save(eventToUpdate);
    }

    @DeleteMapping("/deleteEventById")
    public void deleteEventById(@PathParam("id") int id) {
        if (eventRepo.existsById(id)) {
            eventRepo.deleteById(id);
        }
    }

    @DeleteMapping("/deleteAllBooks")
    public void deleteAllBooks() {
        eventRepo.deleteAll();
    }

}
