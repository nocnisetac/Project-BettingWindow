package project.betting.model;

public class Result {
	private int ID;
	private int matchID;
	private String result_type;
	private int domestic;
	private int guest;
	
	public Result() {}

	public Result(int ID, int matchID, String result_type, int domestic, int guest) {
		super();
		this.ID = ID;
		this.matchID = matchID;
		this.result_type = result_type;
		this.domestic = domestic;
		this.guest = guest;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getResult_type() {
		return result_type;
	}

	public void setResult_type(String result_type) {
		this.result_type = result_type;
	}

	public int getDomestic() {
		return domestic;
	}

	public void setDomestic(int domestic) {
		this.domestic = domestic;
	}

	public int getGuest() {
		return guest;
	}

	public void setGuest(int guest) {
		this.guest = guest;
	}

	public int getMatchID() {
		return matchID;
	}

	public void setMatchID(int matchID) {
		this.matchID = matchID;
	}

	@Override
	public String toString() {
		return "Result [ID=" + ID + ", matchID=" + matchID + ", result_type=" + result_type + ", domestic=" + domestic
				+ ", guest=" + guest + "]";
	}
}
