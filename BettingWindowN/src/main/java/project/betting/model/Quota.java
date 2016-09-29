package project.betting.model;

import project.betting.model.enums.BetType;

public class Quota {

	private int ID;
	private String quotaType;
	private float quotaValue;
	private int matchID;
	public Quota() {
		super();
	}
	public Quota(int iD, String quotaType, float quotaValue, int matchID) {
		super();
		ID = iD;
		this.quotaType = quotaType;
		this.quotaValue = quotaValue;
		this.matchID = matchID;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getQuotaType() {
		return quotaType;
	}
	public void setQuotaType(String quotaType) {
		this.quotaType = quotaType;
	}
	public float getQuotaValue() {
		return quotaValue;
	}
	public void setQuotaValue(float quotaValue) {
		this.quotaValue = quotaValue;
	}
	public int getMatchID() {
		return matchID;
	}
	public void setMatchID(int matchID) {
		this.matchID = matchID;
	}
	@Override
	public String toString() {
		return "Quota [ID=" + ID + ", quotaType=" + quotaType + ", quotaValue=" + quotaValue + ", matchID=" + matchID
				+ "]";
	}
	
}
