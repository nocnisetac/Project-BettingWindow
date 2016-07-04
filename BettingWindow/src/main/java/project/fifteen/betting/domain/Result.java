package project.fifteen.betting.domain;

public class Result {
	
	private static final long serialVersionUID = 1L;
	
	private Long resultID;
	private int home;
	private int visitor;
	
	public Result() {

	}

	public Long getResultID() {
		return resultID;
	}

	public void setResultID(Long resultID) {
		this.resultID = resultID;
	}

	public int getHome() {
		return home;
	}

	public void setHome(int home) {
		this.home = home;
	}

	public int getVisitor() {
		return visitor;
	}

	public void setVisitor(int visitor) {
		this.visitor = visitor;
	}
	
}
