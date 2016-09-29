package project.betting.service.api;

import java.util.List;

import project.betting.model.Match;

public interface MatchService {
	public Match getMatchByID(int id);
	public List<Match> getMatchListByListOfID(List<Integer> listID);
}
