package com.acs560.cricket_analyzer.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import com.acs560.cricket_analyzer.model.Player;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class PlayerRepository {

    private static List<Player> players;

    public  List<Player> getPlayers() {
        if (players == null) {
            players = initializePlayers();
        } 
        return players;
    }

    private static List<Player> initializePlayers() {
    	try( BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ClassPathResource("batting stats.csv").getInputStream()))){
    		String firstLine=bufferedReader.readLine();
    		if(firstLine!= null && firstLine.startsWith("\uFEFF")) {
    			firstLine=firstLine.substring(1);
    		}
    		
    	}
            CsvToBean<Player> csvToBean = new CsvToBeanBuilder<Player>(bufferedReader)
            		.withType(Player.class)
            		.withSkipLines(1)
            		.build();
            players = csvToBean.parse();
        }  catch  (IOException e1) {
            e1.printStackTrace();
            players = new ArrayList<>();
        }catch(Exception e) {
        	e1.printStackTrace();
        	players = new ArrayList<>();
        }
   

public static List<Player> getAllPlayers(){
	if(players == null) {
		initializePlayers();
//		players.add(new Player(null,null,0,0,0,0,0,0));
	}
	return players;
}
    
    public Player getPlayerByName(String name) {
    	for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }
    public List<Player> getPlayersByTeam(String team) {
        List<Player> teamPlayers = new ArrayList<>();
        for (Player player : players) {
            if (player.getTeam().equals(team)) {
                teamPlayers.add(player);
            }
        }
        return teamPlayers;
    }

    }
