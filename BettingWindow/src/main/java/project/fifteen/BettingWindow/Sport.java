package project.fifteen.BettingWindow;

import java.util.HashMap;

public class Sport {
	private String sportName;
	private HashMap<String,Competition> competitions;

	public Sport (String name) {
		this.sportName=name;
		this.competitions=new HashMap();
	}
	public String getSportName(){
		return this.sportName;
	}
	public Competition getCompetition(String name) {
		return competitions.get(name);
	}
	public void addCompetition(Competition comp) {
		competitions.put(comp.getCompName(), comp);
	}
	public void print() {

	}
}
