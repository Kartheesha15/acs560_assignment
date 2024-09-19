package com.acs560.cricket_analyzer.Services.Impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.acs560.cricket_analyzer.Repository.PlayerRepository;
import com.acs560.cricket_analyzer.Services.PlayerServices;
import com.acs560.cricket_analyzer.model.Player;
@Service
public class PlayerServiceImpl implements PlayerServices {


	@Override
	public List<Player> getPlayers(String name, String team) {
		List<Player> filteredPlayers = 
				new ArrayList<>(PlayerRepository.getPlayers()
						.stream()
						.filter(b -> b.getName().equals(name) && b.getName().equals(team))
						.toList());
		
		if (filteredPlayers.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		filteredPlayers.sort(createPlayerComparator());
		return filteredPlayers;

	}

	@Override
	public List<Player> getPlayers() {
		List<Player> players = PlayerRepository.getPlayers();
		players.sort(createPlayerComparator());
		return players;
	}

	@Override
	public List<Player> getPlayers(String name) {
		List<Player> filteredPlayers = new ArrayList<>(PlayerRepository.getPlayers().stream().filter(b -> b.getName().equals(name)).toList());
		if (filteredPlayers.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		filteredPlayers.sort(createPlayerComparator());
		return filteredPlayers;
	}
	
	private Comparator<Player> createPlayerComparator(){
		return Comparator.comparing(Player::getTeam).
				thenComparing(Player::getRuns).
				thenComparing(Player::getAverage);
	}

	@Override
	public void add(Player player) {
		PlayerRepository.addPlayer(player);
		
	}

	@Override
	public void delete(Player player) {
		PlayerRepository.addPlayer(player);
		
	}

	@Override
	public void update(Player player) {
		PlayerRepository.updatePlayer(player);
		
	}
}
