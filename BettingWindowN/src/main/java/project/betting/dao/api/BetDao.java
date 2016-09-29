package project.betting.dao.api;

import java.util.List;

import project.betting.model.Bet;

public interface BetDao {
	public List<Bet> getBetListByMatchID(int id);
	public List<Bet> getBetListByClientID(int id);
	public void insertBatch(final List<Bet> sports);
	public long insert(Bet bet);
	public List<Bet> getBetListWithMatchesByClientID(int id);
}
