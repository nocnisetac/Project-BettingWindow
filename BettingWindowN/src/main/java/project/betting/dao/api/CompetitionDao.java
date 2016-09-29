package project.betting.dao.api;

import java.util.List;
import java.util.Map;

import project.betting.model.Competition;

public interface CompetitionDao {
	public List<Competition> getCompetitionListBySportID (int id);
	public Competition getCompetitionByID(int id);
}
