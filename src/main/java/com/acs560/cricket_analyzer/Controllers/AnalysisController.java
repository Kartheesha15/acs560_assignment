package com.acs560.cricket_analyzer.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.acs560.cricket_analyzer.Services.AnalysisServices;
import com.acs560.cricket_analyzer.model.Player;

public class AnalysisController{
	@Autowired
	public AnalysisServices analysisServices;

    @GetMapping("/analysis/average-runs")
    public double getAverageRuns() {
        return analysisServices.getAverageRuns();
    }

    @GetMapping("/analysis/average-strike-rate")
    public double getAverageStrikeRate() {
        return analysisServices.getAverageStrikeRate();
    }

    @GetMapping("/analysis/highest-average")
    public double getHighestAverage() {
        return analysisServices.getHighestAverage();
    }
    @GetMapping("/analysis/highest-strike-rate")
    public double getHighestStrikeRate() {
        return analysisServices.getHighestStrikeRate();
    }

    @GetMapping("/analysis/top-scorers/{n}")
    public List<Player> getTopScorers(@PathVariable int n) {
        return analysisServices.getTopScorers(n);
    }

    @GetMapping("/analysis/top-strikers/{n}")
    public List<Player> getTopStrikers(@PathVariable int n) {
        return analysisServices.getTopStrikers(n);
    }

    @GetMapping("/analysis/team-average-runs/{team}")
    public double getTeamAverageRuns(@PathVariable String team) {
    	return analysisServices.getTeamAverageRuns(team);
    }

    @GetMapping("/analysis/team-average-strike-rate/{team}")
    public double getTeamAverageStrikeRate(@PathVariable String team) {
        return analysisServices.getTeamAverageStrikeRate(team);
    }

}



/*import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acs560.cricket_analyzer.Services.PlayerServices;
import com.acs560.cricket_analyzer.model.Player;

import lombok.NoArgsConstructor;


@RestController
@RequestMapping("/api/v1/bat")
@NoArgsConstructor
public class PlayersController {
    
    public PlayerServices playerServices;
    
    @Autowired
    public PlayersController(PlayerServices playerServices) {
        this.playerServices = playerServices;
    }
    
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
}*/
