package project.betting.dao.api;

import java.util.List;

import project.betting.model.Team;

public interface TeamDao {
	public List<Team> getTeamListByCompetitionID(int id);
	public Team getTeamByID(int id);
}
