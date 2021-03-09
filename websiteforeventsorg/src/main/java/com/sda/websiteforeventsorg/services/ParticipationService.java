package com.sda.websiteforeventsorg.services;

import com.sda.websiteforeventsorg.entities.Comment;
import com.sda.websiteforeventsorg.entities.Participation;

import java.util.List;

public interface ParticipationService {
    List<Participation> getAllParticipants();
    Participation getParticipantsById(long id);
    void createParticipation(Participation participation);
    Participation updateParticipation(Participation participation, long id);
    void deleteParticipantsById(long id);
}
