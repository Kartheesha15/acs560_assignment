package com.acs560.cricket_analyzer.Services.Impl;

import org.springframework.stereotype.Service;

import com.acs560.cricket_analyzer.Repository.PlayerRepository;
import com.acs560.cricket_analyzer.Services.AnalysisServices;
import com.acs560.cricket_analyzer.model.Player;




@Service
public abstract class AnalysisServicesImpl implements AnalysisServices {

	@Override
	public double calculateAverageRuns(String team) {
		double average;
		average = PlayerRepository.getPlayers().stream().filter(b->b.getTeam().equals(team)).mapToDouble(Player::getRuns).average().orElseThrow();
		return average;
	}

	@Override
	public double calculateAverageStrikeRate(String team) {
		double average;
		average = PlayerRepository.getPlayers().stream().filter(b->b.getTeam().equals(team)).mapToDouble(Player::getStrikeRate).average().orElseThrow();
		return average;
	}
	





}
