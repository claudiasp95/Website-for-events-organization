package com.sda.websiteforeventsorg.services;

import com.sda.websiteforeventsorg.entities.Event;
import com.sda.websiteforeventsorg.entities.Participation;
import com.sda.websiteforeventsorg.repositories.ParticipationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ParticipationServiceImpl implements ParticipationService {

    private final ParticipationRepository participationRepository;

    @Override
    public List<Participation> getAllParticipants() {
        return participationRepository.findAll();
    }

    @Override
    public Participation getParticipantsById(long id) {
        return participationRepository.getOne(id);
    }

    @Override
    public void createParticipation(Participation participation) {
        participationRepository.save(participation);

    }

    @Override
    public Participation updateParticipation(Participation participation, long id) {
       try{
           Optional<Participation> newParticipation = Optional.ofNullable(participation);
           Participation oldParticipation = participationRepository.findById(id)
                   .orElseThrow(()->new RuntimeException("Participation not found."));
           oldParticipation.setEvent(newParticipation.map(Participation::getEvent).orElse(oldParticipation.getEvent()));
           oldParticipation.setUser(newParticipation.map(Participation::getUser).orElse(oldParticipation.getUser()));
           oldParticipation.setOrganizerApproval(newParticipation.map(Participation::isOrganizerApproval).orElse(oldParticipation.isOrganizerApproval()));
           oldParticipation.setParticipantApproval(newParticipation.map(Participation::isParticipantApproval).orElse(oldParticipation.isParticipantApproval()));

           return participationRepository.save(oldParticipation);

       }catch (Exception e){
           throw new RuntimeException("Participation can`t be found");
       }
    }

    @Override
    public void deleteParticipantsById(long id) {
        participationRepository.deleteById(id);

    }
}
