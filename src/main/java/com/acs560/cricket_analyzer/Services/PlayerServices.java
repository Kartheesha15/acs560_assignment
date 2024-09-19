package com.acs560.cricket_analyzer.Services;
import com.acs560.cricket_analyzer.model.Player ;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface PlayerServices {
	List<Player> getPlayers(String team);
	List<Player> getPlayers();
	List<Player> getPlayers1(String name);
//	List<Player> getPlayers(String team, int runs);
	
	
	void add(Player bill);
	void delete(Player bill);
	void update(Player bill);
	

	

}
