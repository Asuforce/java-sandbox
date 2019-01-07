package com.example.javacrud.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.javacrud.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
