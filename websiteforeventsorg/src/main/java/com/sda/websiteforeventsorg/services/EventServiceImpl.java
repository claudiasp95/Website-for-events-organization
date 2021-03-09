package com.sda.websiteforeventsorg.services;

import com.sda.websiteforeventsorg.entities.Comment;
import com.sda.websiteforeventsorg.entities.Event;
import com.sda.websiteforeventsorg.repositories.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EventServiceImpl implements EventService{

    private final EventRepository eventRepository;
    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(long id) {
        return eventRepository.getOne(id);
    }

    @Override
    public void createEvent(Event event) {
        eventRepository.save(event);

    }

    @Override
    public Event updateEvent(Event event, long id) {
      try{
          Optional<Event > newEvent = Optional.ofNullable(event);
          Event oldEvent = eventRepository.findById(id)
                  .orElseThrow(()->new RuntimeException("Event not found."));
          oldEvent.setDate(newEvent.map(Event::getDate).orElse(oldEvent.getDate()));
          oldEvent.setName(newEvent.map(Event::getName).orElse(oldEvent.getName()));
          oldEvent.setAddress(newEvent.map(Event::getAddress).orElse(oldEvent.getAddress()));
          oldEvent.setAccess(newEvent.map(Event::getAccess).orElse(oldEvent.getAccess()));
          oldEvent.setUser(newEvent.map(Event::getUser).orElse(oldEvent.getUser()));

          return eventRepository.save(oldEvent);

      }catch (Exception e){
          throw new RuntimeException("Event can`t be found");
      }
    }

    @Override
    public void deleteEventById(long id) {
         eventRepository.deleteById(id);

    }
}
