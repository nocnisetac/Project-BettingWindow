package project.fifteen.BettingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Team {
	private String teamName;
	private HashMap<Integer, Match> teamMatches;
	public Team(String name) {
		this.teamName=name;
		this.teamMatches=new HashMap();
	}
	public void addTeamMatch(Match match) {
		teamMatches.put(match.getMatchId(), match);
	}
	public String getTeamName() { return this.teamName; }
	public String toString() {
		return teamName;
	}
	public void printTeamMatches() {
		System.out.println(teamName+"'s matches:");
		Set<Map.Entry<Integer,Match>> set2 = teamMatches.entrySet();
		for(Map.Entry<Integer, Match> me2: set2) {
			System.out.println("\t"+me2.getValue());
		}
	}
}
