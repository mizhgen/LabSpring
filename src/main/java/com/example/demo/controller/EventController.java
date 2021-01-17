package com.example.demo.controller;

import com.example.demo.model.Event;
import com.example.demo.repos.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EventController {
    private EventRepo eventRepo;

    @Autowired(required = true)
    public void setEventRepo(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public String listEvents(Model model){
        model.addAttribute("event", new Event());
        model.addAttribute("listEvents", this.eventRepo.findAll());
        return "events";
    }

    @RequestMapping("/remove/{id}")
    public String removeEvent(@PathVariable("id") int id){
        this.eventRepo.deleteById(id);
        return "redirect:/events";
    }
}
