package project.betting.model;

import java.util.List;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Client {
	
	private long ID;
	@NotEmpty
	@Length(min=3, max=10)
	private String username;
	@NotEmpty
	@Length(min=3, max=10)
	private String password;
	@Email
	@NotEmpty
	private String email;
	
	private int count;
	
	private List<Bet> bets;
	
	
	public List<Bet> getBets() {
		return bets;
	}
	public void setBets(List<Bet> bets) {
		this.bets = bets;
	}
	public Client() {
		super();
	}
	
	public Client(long iD, String username, String password, String email, int count) {
		super();
		ID = iD;
		this.username = username;
		this.password = password;
		this.email = email;
		this.count = count;
	}
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
