package com.acs560.cricket_analyzer.Services;

import java.util.List;

import com.acs560.cricket_analyzer.model.Player;

public interface AnalysisServices {
	 double getAverageRuns() ;
     double getAverageStrikeRate();
     double getHighestAverage() ;
     double getHighestStrikeRate() ;
     List<Player> getTopScorers(int n) ;
     List<Player> getTopStrikers(int n) ;
     double getTeamAverageRuns(String team);
     double getTeamAverageStrikeRate(String team) ;

}
