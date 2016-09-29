package project.betting.model;

public class Team {
	private int ID;
	private String teamName;
	private int competitionID;
	
	public Team() {}
	public Team(int iD, String teamName, int competitionID) {
		super();
		ID = iD;
		this.teamName = teamName;
		this.competitionID = competitionID;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getCompetitionID() {
		return competitionID;
	}
	public void setCompetitionID(int competitionID) {
		this.competitionID = competitionID;
	}
	@Override
	public String toString() {
		return "Team [ID=" + ID + ", teamName=" + teamName + ", competitionID=" + competitionID + "]" + "\n";
	}

}
