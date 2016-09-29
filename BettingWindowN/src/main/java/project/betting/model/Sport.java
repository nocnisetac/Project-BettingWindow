package project.betting.model;

import java.util.List;
import java.util.Map;

import project.betting.model.Competition;

public class Sport {
	
	private int ID;
	private String sportName;
	
	private List<Competition> compets; 
	
	public Sport() {}

	public Sport(int id, String sportName) {
		super();
		this.ID = id;
		this.sportName = sportName;
	}

	public int getID() {
		return ID;
	}

	public void setID(int id) {
		this.ID = id;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public List<Competition> getCompets() {
		return compets;
	}

	public void setCompets(List<Competition> compets) {
		this.compets = compets;
	}
	@Override
	public String toString() {
		return ""+ID ;
	}

}

