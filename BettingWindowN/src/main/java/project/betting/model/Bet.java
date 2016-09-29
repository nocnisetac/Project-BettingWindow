package project.betting.model;

import project.betting.model.enums.BetState;
import project.betting.model.enums.BetType;

public class Bet {
	private long ID;
	private int matchID;
	private int clientID;
	private String betType;
	private BetState betState;
	private int invest;
	
	private Match match;
	
	public Bet() {}

	public Bet(int iD, int matchID, int clientID, String betType, BetState betState, int invest) {
		super();
		ID = iD;
		this.matchID = matchID;
		this.clientID = clientID;
		this.betType = betType;
		this.betState = betState;
		this.invest = invest;
		this.match = null;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public int getMatchID() {
		return matchID;
	}

	public void setMatchID(int matchID) {
		this.matchID = matchID;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public String getBetType() {
		return betType;
	}

	//public void setBetType(BetType betType) {
	//	this.betType = betType;
	//}
	
	public void setBetType(String betType) {
		this.betType = betType;
	}

	public BetState getBetState() {
		return betState;
	}

	public void setBetState(BetState betState) {
		this.betState = betState;
	}

	public int getInvest() {
		return invest;
	}

	public void setInvest(int invest) {
		this.invest = invest;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	
}
