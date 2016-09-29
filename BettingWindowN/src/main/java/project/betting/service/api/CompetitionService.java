package project.betting.service.api;

import java.util.List;
import java.util.Map;

import project.betting.model.Competition;

public interface CompetitionService {
	// She's the one
	public List<Competition> getCompetitionListWithTeamsBySportID(int id);
	public Competition getCompetitionByID(int id);
	public List<Competition> getCompetitionListWithBettableMatchesBySportID(int id);
}
