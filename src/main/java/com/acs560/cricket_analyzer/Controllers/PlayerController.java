package com.acs560.cricket_analyzer.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.acs560.cricket_analyzer.Services.PlayerServices;
import com.acs560.cricket_analyzer.model.Player;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PlayerController {
	@Autowired
	public PlayerServices playerServices;

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerServices.getAllPlayers();
    }

    @GetMapping("/players/{name}")
    public Player getPlayerByName(@PathVariable String name) {
        return playerServices.getPlayerByName(name);
    }
    @GetMapping("/players/team/{team}")
    public List<Player> getPlayersByTeam(@PathVariable String team) {
        return playerServices.getPlayersByTeam(team);
    }


}
