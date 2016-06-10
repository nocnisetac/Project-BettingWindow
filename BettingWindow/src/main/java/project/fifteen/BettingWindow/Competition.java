package project.fifteen.BettingWindow;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Competition {
	private int compCapacity;
	private String compName;
	private HashMap<String,Team> compTeams;
	private HashMap<Integer, Match> compMatches;
	public Competition (String compName, int compCapacity) {
		this.compName=compName;
		this.compCapacity=compCapacity;
		this.compTeams=new HashMap(compCapacity);
		this.compMatches=new HashMap();
	}
	public String getCompName() { return this.compName; }
	
	public void addTeam(Team t) {
		try {
			if (compTeams.size()==compCapacity) throw new LeagueOverflowException();
			if(this.compTeams.containsKey(t.getTeamName())) throw new TeamExsistsException();
			else compTeams.put(t.getTeamName(), t);
		} catch (TeamExsistsException e) {
			System.out.println(e);
		} catch (LeagueOverflowException e) {
			System.out.println(e);
		}
	}
	public Team getTeam(String teamName) {
		return compTeams.get(teamName);
	}
	public void addCompMatch(String home, String visitor, GregorianCalendar dt) {
		try {
			Team homeTeam = null, visitorTeam=null;
			if (!compTeams.containsKey(home))
				throw new TeamExsistsException();
			homeTeam=compTeams.get(home);
			if (!compTeams.containsKey(visitor))
				throw new TeamExsistsException();
			visitorTeam=compTeams.get(visitor);
			Match match = new Match(compTeams.get(home), compTeams.get(visitor), dt);
			compMatches.put(match.getMatchId(), match);
			homeTeam.addTeamMatch(match);
			visitorTeam.addTeamMatch(match);
			
		} catch (TeamExsistsException e) {
			System.out.println(e);
		}
		
	}
	public void printCompetition() {
		System.out.println("Teams in league");
		Set<Map.Entry<String,Team>> set1 = compTeams.entrySet();
		for(Map.Entry<String, Team> me1: set1) {
			System.out.println("\t"+me1.getValue());
		}
		System.out.println("Matches:");
		Set<Map.Entry<Integer,Match>> set2 = compMatches.entrySet();
		for(Map.Entry<Integer, Match> me2: set2) {
			System.out.println("\t"+me2.getValue());
		}
	}
}
