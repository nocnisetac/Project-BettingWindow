package project.betting.model;

import javax.validation.constraints.Pattern;

public class Bett {
	
	@Pattern(regexp="1|X|2")
	private String s;
	private int ID;

	public Bett() {
		super();
	}

	public Bett(int iD) {
		super();
		ID = iD;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
}
