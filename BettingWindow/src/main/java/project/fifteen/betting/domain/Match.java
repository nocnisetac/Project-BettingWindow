package project.fifteen.betting.domain;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;



/**
 * @author nocnisetac
 * U code-review kazes da je potrebno da rezultate prihvata neka lista,jer ne znam kada
 * mi mogu traziti rezultate od pre nedelju ili godinu. Ne razumem kakve veze to ima sa
 * rezultatom. On je jednoznacno odredjen sa dva tima i terminom. Bar tako ga ja ovde 
 * razumem. Stavio sam listu (u svakom slucaju mora neka struktura) jer razni sportovi
 * imaju razlicite celine (poluvreme, cetvrtine, produzeci...), pa da sve to moze da se
 * prihvati...
 */
public class Match {
	
	private static final long serialVersionUID = 1L;
	
	private Long matchID;
	
	private Team home;
	private Team visitor;
	
	private Status status;
	private GregorianCalendar date;
	private List<Result> results;
	
	public Match (Team home, Team visitor) {
		
	}
	protected Match () {}
	public Match (Team home, Team visitor, GregorianCalendar gc) {
		this();
		this.home=home;
		this.visitor=visitor;
	}
	public Long getMatchID() {
		return matchID;
	}
	public void setMatchID(Long matchID) {
		this.matchID = matchID;
	}
	public Team getHome() {
		return home;
	}
	public void setHome(Team home) {
		this.home = home;
	}
	public Team getVisitor() {
		return visitor;
	}
	public void setVisitor(Team visitor) {
		this.visitor = visitor;
	}
	public GregorianCalendar getDate() {
		return date;
	}
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public List<Result> getResults() {
		return results;
	}
	public void setResults(List<Result> results) {
		this.results = results;
	}
	
}

