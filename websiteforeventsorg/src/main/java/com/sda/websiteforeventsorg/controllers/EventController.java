package com.sda.websiteforeventsorg.controllers;


import com.sda.websiteforeventsorg.entities.Event;
import com.sda.websiteforeventsorg.services.EventService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/event")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EventController {
    private final EventService eventService;
    @GetMapping()
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();

    }
    @GetMapping("/{id}")
    public Event getEvent(@PathVariable("id") long id){
        return eventService.getEventById(id);
    }
    @PostMapping()
    public void saveEvent(@RequestBody Event event){
        eventService.createEvent(event);
    }
    @PutMapping("/{id}")
    public Event updateEvent(@RequestBody Event event, @PathVariable("id") long id){
        return eventService.updateEvent(event, id);
    }
    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable("id") long id){
        eventService.deleteEventById(id);
    }



}
