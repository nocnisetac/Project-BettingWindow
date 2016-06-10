package project.fifteen.BettingWindow;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Match {
	private static int id = 0;
	private int matchId;
	private Team home, visitor;
	private GregorianCalendar date;
	private Status status;
	private Result halfTime, endGame;
	public Match (Team home, Team visitor, GregorianCalendar gc) {
		this.matchId=id++;
		this.home=home;
		this.visitor=visitor;
		this.date=gc;
		this.status=null;
		this.halfTime=null;
		this.endGame=null;
	}
	void setStatus() {
		
	}
	void setHalfTimeResult() {
		
	}
	void setEndGame() {
		
	}
	public int getMatchId() {
		return matchId;
	}
	public String toString(){
		return home+":"+visitor+" on "+date.get(Calendar.DATE)+":"+date.get(Calendar.MONTH)+":"+date.get(Calendar.YEAR);
	}
}
