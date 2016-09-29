package project.betting.service.api;

import java.util.List;

import project.betting.model.Bet;
import project.betting.model.extra.Carrier;

public interface BetService {
	public void insertBatch(Carrier carrier);
	public List<Bet> getBetListByClientID(int client_id);
	public List<Bet> getBetListWithMatchesByClientID(int id);
}
