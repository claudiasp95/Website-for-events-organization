package com.sda.websiteforeventsorg.repositories;

import com.sda.websiteforeventsorg.entities.Participation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Long> {
}
