package project.betting.model.enums;

public enum BetState {
	ACTIVE (1), LOST (2), WON (3);
	
	private final int stateCode;
	
	BetState(int stateCode) {
		this.stateCode = stateCode;
	}
	
	public int getStateCode() {
		return this.stateCode;
	}
}
