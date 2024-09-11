package com.acs560.cricket_analyzer.Services.Impl;

import java.util.List;

import com.acs560.cricket_analyzer.Repository.PlayerRepository;
import com.acs560.cricket_analyzer.Services.PlayerServices;
import com.acs560.cricket_analyzer.model.Player;

public class PlayerServiceImpl implements PlayerServices {
    public  PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.getPlayers();
    }

    @Override
    public Player getPlayerByName(String name) {
        return playerRepository.getPlayerByName(name);
    }

    @Override
    public List<Player> getPlayersByTeam(String team) {
        return playerRepository.getPlayersByTeam(team);
    }
}
