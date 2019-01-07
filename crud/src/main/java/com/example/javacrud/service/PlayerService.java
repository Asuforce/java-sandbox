package com.example.javacrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javacrud.domain.Player;
import com.example.javacrud.repository.PlayerRepository;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Player getOne(Long id) {
        return playerRepository.getOne(id);
    }

    public Player save(Player player) {
        return playerRepository.save(player);
    }

    public void delete(Player player) {
        playerRepository.delete(player);
    }

}
