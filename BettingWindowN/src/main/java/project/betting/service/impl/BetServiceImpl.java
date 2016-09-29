package project.betting.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.betting.dao.api.BetDao;
import project.betting.model.Bet;
import project.betting.model.enums.BetState;
import project.betting.model.extra.Carrier;
import project.betting.service.api.BetService;

@Service
public class BetServiceImpl implements BetService {

	@Autowired
	private BetDao betDao;
	
	@Override
	public void insertBatch(Carrier carrier) {
		List<Bet> bets = new ArrayList<Bet>(carrier.getChecked().size());
		for(int i=1; i<=carrier.getChecked().size(); i++){
			Bet bet = new Bet();
			bet.setID(42);
			bet.setMatchID(carrier.getChecked().get(i-1));
			bet.setClientID(7);
			bet.setBetType(carrier.getTips().get(i-1));
			bet.setBetState(BetState.ACTIVE);
			bet.setInvest(carrier.getInvested().get(i-1));
			bets.add(bet);
		}
		betDao.insertBatch(bets);
	}

	@Override
	public List<Bet> getBetListByClientID(int client_id) {
		return betDao.getBetListByClientID(client_id);
	}
	public List<Bet> getBetListWithMatchesByClientID(int id) {
		return betDao.getBetListWithMatchesByClientID(id);
	}
}
