package com.sda.websiteforeventsorg.repositories;

import com.sda.websiteforeventsorg.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
