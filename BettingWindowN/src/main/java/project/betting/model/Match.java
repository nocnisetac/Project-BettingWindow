package project.betting.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import project.betting.model.Bet;
import project.betting.model.Result;
import project.betting.model.Team;
import project.betting.model.enums.MatchState;

public class Match {
	private int ID;
	private Team domestic;
	private Team guest;
	private Date dateTime;
	private MatchState state;
	private int competitionID;
	
	private Map<String, Result> results;
	private Map<String, Quota> quotas;
	
	public Match() {}

	public Match(int iD, Team domestic, Team guest, Date dateTime, MatchState state, int competitionID) {
		super();
		ID = iD;
		this.domestic = domestic;
		this.guest = guest;
		this.dateTime = dateTime;
		this.state = state;
		this.competitionID = competitionID;
		this.results = null;
		this.quotas = null;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Team getDomestic() {
		return domestic;
	}

	public void setDomestic(Team domestic) {
		this.domestic = domestic;
	}

	public Team getGuest() {
		return guest;
	}

	public void setGuest(Team guest) {
		this.guest = guest;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public MatchState getState() {
		return state;
	}

	public void setState(MatchState state) {
		this.state = state;
	}

	public int getCompetitionID() {
		return competitionID;
	}

	public void setCompetitionID(int competitionID) {
		this.competitionID = competitionID;
	}

	public Map<String, Result> getResults() {
		return results;
	}

	public void setResults(Map<String, Result> results) {
		this.results = results;
	}
    
	
	public Map<String, Quota> getQuotas() {
		return quotas;
	}

	public void setQuotas(Map<String, Quota> quotas) {
		this.quotas = quotas;
	}
/*
	@Override
	public String toString() {
		return  String.format("%1$-5s %2$-13s %3$-13s %4$-20s %5$-11s %6$-3s ", 
    			getID(), getDomestic().getTeamName(), getGuest().getTeamName(),
        		new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(getDateTime()), 
        		getState(), getCompetitionID());
	}
	*/
	@Override
	public String toString() { return ""+this.getID();  }
}
