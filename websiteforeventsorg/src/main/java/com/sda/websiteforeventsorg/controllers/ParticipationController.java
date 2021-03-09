package com.sda.websiteforeventsorg.controllers;

import com.sda.websiteforeventsorg.entities.Participation;
import com.sda.websiteforeventsorg.services.ParticipationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/participation")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ParticipationController {

    private final ParticipationService participationService;

    @GetMapping()
    public List<Participation> getAllParticipants(){
        return participationService.getAllParticipants();
    }

    @GetMapping("/{id}")
    public Participation getParticipation(@PathVariable("id") long id){
        return participationService.getParticipantsById(id);
    }

    @PostMapping()
    public void saveParticipation(@RequestBody Participation participation){
         participationService.createParticipation(participation);
    }

    @PutMapping("/{id}")
    public Participation updateParticipation(@RequestBody Participation participation, @PathVariable("id") long id){
        return participationService.updateParticipation(participation, id);
    }

    @DeleteMapping("/{id}")
    public void deleteParticipation(@PathVariable("id") long id){
        participationService.deleteParticipantsById(id);
    }

}
