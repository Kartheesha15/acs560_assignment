package com.acs560.cricket_analyzer.Services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acs560.cricket_analyzer.Repository.PlayerRepository;
import com.acs560.cricket_analyzer.Services.AnalysisServices;
import com.acs560.cricket_analyzer.model.Player;

@Service
public class AnalysisServicesImpl implements AnalysisServices {
	@Autowired
	public  PlayerRepository playerRepository;

    
//    public AnalysisServiceImpl(PlayerRepository playerRepository) {
	@Override
	public double getAverageRuns() {
        List<Player> players = playerRepository.getPlayers();
        return players.stream()
                .mapToDouble(player -> (double) player.getRuns())
                .average()
                .orElse(0.0);
    }
	@Override
    public double getAverageStrikeRate() {
        List<Player> players = playerRepository.getPlayers();
        return players.stream()
                .mapToDouble(Player::getStrikeRate)
                .average()
                .orElse(0.0);
    }
	@Override
    public double getHighestAverage() {
        List<Player> players = playerRepository.getPlayers();
        return players.stream()
                .mapToDouble(Player::getAverage)
                .max()
                .orElse(0.0);
    }
	@Override
    public double getHighestStrikeRate() {
        List<Player> players = playerRepository.getPlayers();
        return players.stream()
                .mapToDouble(Player::getStrikeRate)
                .max()
                .orElse(0.0);
    }
	@Override
    public List<Player> getTopScorers(int n) {
        List<Player> players = playerRepository.getPlayers();
        return players.stream()
                .sorted((p1, p2) -> Integer.compare(p2.getRuns(), p1.getRuns()))
                .limit(n)
                .collect(Collectors.toList());
    }
	@Override
    public List<Player> getTopStrikers(int n) {
        List<Player> players = playerRepository.getPlayers();
        return players.stream()
                .sorted((p1, p2) -> Double.compare(p2.getStrikeRate(), p1.getStrikeRate()))
                .limit(n)
                .collect(Collectors.toList());
    }
	@Override
    public double getTeamAverageRuns(String team) {
        List<Player> teamPlayers = playerRepository.getPlayersByTeam(team);
        return teamPlayers.stream()
                .mapToDouble(player -> (double) player.getRuns())
                .average()
                .orElse(0.0);
    }
	@Override
    public double getTeamAverageStrikeRate(String team) {
        List<Player> teamPlayers = playerRepository.getPlayersByTeam(team);
        return teamPlayers.stream()
                .mapToDouble(Player::getStrikeRate)
                .average()
                .orElse(0.0);
    }

}
