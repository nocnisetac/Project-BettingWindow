package project.fifteen.betting.domain;

import java.util.Set;


/**
 * @author nocnisetac
 * Pretpostavljam da mehanizam inicijalizovanja sportID ide preko anotacija, tj ima veze sa 
 * konfigurisanjem binova. Zato - za sad ovako...
 */
public class Sport {

	private static final long serialVersionUID = 1L;
	
	private Long sportID;
	private String sportName;
	private Set<Competition> competitions;
	
	protected Sport() {
		// Prazan konstruktor ako zatreba...
	}
	public Sport(String sportName) {
		this();
		this.sportName = sportName;
	}
	public Long getSportID() {
		return sportID;
	}
	public void setSportID(Long sportID) {
		this.sportID = sportID;
	}
	public String getSportName() {
		return sportName;
	}
	public void setSportName(String sportName) {
		this.sportName = sportName;
	}
	public Set<Competition> getCompetitions() {
		return competitions;
	}
	public void setCompetitions(Set<Competition> competitions) {
		this.competitions = competitions;
	}
	
	

}