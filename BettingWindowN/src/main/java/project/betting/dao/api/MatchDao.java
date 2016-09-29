package project.betting.dao.api;

import java.util.List;
import java.util.Map;

import project.betting.model.Match;

public interface MatchDao {
	public List<Match> getMatchListByCompetitionID(int competition_id);
	public List<Match> getBettableMatchListByCompetitionID(int competition_id);
	public Match getMatchByID(int id);
	public List<Match> getMatchListByListOfID(List<Integer> listID);
}
