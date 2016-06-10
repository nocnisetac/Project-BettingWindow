package project.fifteen.BettingWindow;
import java.util.GregorianCalendar;

public class BettingTest {

	public static void main(String[] args) {
		BettingWindow betting = new BettingWindow("Milioner");
		betting.addSport("soccer");
		betting. getSportToBett("soccer").addCompetition(new Competition("League",4));
		
		betting. getSportToBett("soccer").getCompetition("League").addTeam(new Team("Real"));
		betting. getSportToBett("soccer").getCompetition("League").addTeam(new Team("PSG"));
		betting. getSportToBett("soccer").getCompetition("League").addTeam(new Team("CSKA"));
		betting. getSportToBett("soccer").getCompetition("League").addTeam(new Team("Ajax"));
		
		betting. getSportToBett("soccer").getCompetition("League").addCompMatch("Real","PSG",new GregorianCalendar());
		betting. getSportToBett("soccer").getCompetition("League").addCompMatch("Real","CSKA",new GregorianCalendar());
		betting. getSportToBett("soccer").getCompetition("League").addCompMatch("Real","Ajax",new GregorianCalendar());
		betting. getSportToBett("soccer").getCompetition("League").addCompMatch("PSG","CSKA",new GregorianCalendar());
		betting. getSportToBett("soccer").getCompetition("League").addCompMatch("PSG","Ajax",new GregorianCalendar());
		betting. getSportToBett("soccer").getCompetition("League").addCompMatch("CSKA","Ajax",new GregorianCalendar());
		
		betting.getSportToBett("soccer").getCompetition("League").printCompetition();
		betting.getSportToBett("soccer").getCompetition("League").getTeam("PSG").printTeamMatches();
	}

}