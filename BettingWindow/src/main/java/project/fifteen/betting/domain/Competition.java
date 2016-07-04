package project.fifteen.betting.domain;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Competition {
	
	private static final long serialVersionUID = 1L;
	private Long competitionID;
	
	private int competitionCapacity;
	private String competitionName;
	
	private Set<Team> competitionMembers;
	
	public Competition() {}
	public Competition(String compName) {
		this();
		this.competitionName=compName;
	}
	public Competition (String compName, int compCapacity) {
		this();
		this.competitionName=compName;
		this.competitionCapacity=compCapacity;

	}
	
	public Long getCompetitionID() {
		return competitionID;
	}
	public void setCompetitionID(Long competitionID) {
		this.competitionID = competitionID;
	}
	public int getCompetitionCapacity() {
		return competitionCapacity;
	}
	public void setCompetitionCapacity(int competitionCapacity) {
		this.competitionCapacity = competitionCapacity;
	}
	public String getCompetitionName() {
		return competitionName;
	}
	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
	}
	public Set<Team> getCompetitionMembers() {
		return competitionMembers;
	}
	public void setCompetitionMembers(Set<Team> competitionMembers) {
		this.competitionMembers = competitionMembers;
	}
	
}

