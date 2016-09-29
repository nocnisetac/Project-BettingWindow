package project.betting.model;

import java.util.List;
import java.util.Map;

import project.betting.model.Match;
import project.betting.model.Team;

public class Competition {
	private int ID;
	private int sportID;
	private String competitionName;
	private List<Match> matches;
	private List<Team> teams;
	
	public Competition() {}

	
	
	public Competition(int iD, int sportID, String competitionName) {
		super();
		ID = iD;
		this.sportID = sportID;
		this.competitionName = competitionName;
	}



	public int getID() {
		return ID;
	}



	public void setID(int iD) {
		ID = iD;
	}



	public int getSportID() {
		return sportID;
	}



	public void setSportID(int sportID) {
		this.sportID = sportID;
	}



	public String getCompetitionName() {
		return competitionName;
	}

	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
	}

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	@Override
	public String toString() {
		return "Competition [ID=" + ID + ", sportID=" + sportID + ", competitionName=" + competitionName + "]";
	}

}
