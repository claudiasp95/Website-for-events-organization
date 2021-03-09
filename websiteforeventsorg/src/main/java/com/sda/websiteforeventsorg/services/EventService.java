package com.sda.websiteforeventsorg.services;

import com.sda.websiteforeventsorg.entities.Event;

import java.util.List;

public interface EventService {
    List<Event> getAllEvents();
    Event getEventById(long id);
    void createEvent(Event event);
    Event updateEvent(Event event, long id);
    void deleteEventById(long id);
}
