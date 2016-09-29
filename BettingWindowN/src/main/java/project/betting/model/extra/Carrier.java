package project.betting.model.extra;

import java.util.List;

public class Carrier {
	
	private int clientID;
	private List<Integer> checked;
	private List<String> tips;
	private List<Integer> invested;

	public int getClientID() {
		return clientID;
	}
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	public List<Integer> getChecked() {
		return checked;
	}
	public void setChecked(List<Integer> checked) {
		this.checked = checked;
	}
	public List<String> getTips() {
		return tips;
	}
	public void setTips(List<String> tips) {
		this.tips = tips;
	}
	public List<Integer> getInvested() {
		return invested;
	}
	public void setInvested(List<Integer> invested) {
		this.invested = invested;
	}
	
}
