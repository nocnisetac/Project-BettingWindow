package project.fifteen.BettingWindow;

import java.util.HashMap;

public class BettingWindow {
	private String bettName;
	private HashMap<String,Sport> sportsToBett;
	public BettingWindow (String name) {
		this.bettName=name;
		this.sportsToBett=new HashMap();
	}
	public String getBettName(){
		return this.bettName;
	}
	public void addSport(String name) {
		sportsToBett.put(name, new Sport(name));
	}
	public Sport getSportToBett(String sport) {
		return sportsToBett.get(sport);
	}
	public HashMap<String, Sport> getSportsToBet() {
		return sportsToBett;
	}
}
