package com.acs560.cricket_analyzer.Services;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.acs560.cricket_analyzer.model.Player;

@Service
public interface PlayerServices {
	List<Player> getAllPlayers();
    Player getPlayerByName(String name);
    List<Player> getPlayersByTeam(String team);

}
