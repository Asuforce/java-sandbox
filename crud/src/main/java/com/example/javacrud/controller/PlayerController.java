package com.example.javacrud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.javacrud.domain.Player;
import com.example.javacrud.service.PlayerService;

@Controller
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping
    public String index(Model model) {
        List<Player> players = playerService.findAll();
        model.addAttribute("players", players);
        return "players/index";
    }

    @GetMapping("new")
    public String newPlayer(Model model) {
        Player player = new Player();
        model.addAttribute("player", player);
        return "players/new";
    }

    @GetMapping("{id}/edit")
    public String editPlayer(@PathVariable Long id, Model model) {
        Player player = playerService.getOne(id);
        model.addAttribute("player", player);
        return "players/edit";
    }

    @GetMapping("{id}")
    public String showPlayer(@PathVariable Long id, Model model) {
        Player player = playerService.getOne(id);
        model.addAttribute("player", player);
        return "players/show";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute Player player, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "players/new";
        }
        playerService.save(player);
        return "redirect:/players";
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @Valid @ModelAttribute Player player, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "players/edit";
        }
        player.setId(id);
        playerService.save(player);
        return "redirect:/players";
    }

    @DeleteMapping("{id}")
    public String destroy(@ModelAttribute Player player) {
        playerService.delete(player);
        return "redirect:/players";
    }
}
