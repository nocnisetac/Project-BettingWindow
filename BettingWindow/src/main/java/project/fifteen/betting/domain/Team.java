package project.fifteen.betting.domain;

import java.util.Set;

public class Team {
	private static final long serialVersionUID = 1L;
	
	private Long teamID;
	private String teamName;
	
	protected Team() {
		// ako je potreban...
	}
	
	public Team(String name) {
		this.teamName=name;
	}

	public Long getTeamID() {
		return teamID;
	}

	public void setTeamID(Long teamID) {
		this.teamID = teamID;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

}

