package project.betting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.betting.dao.api.MatchDao;
import project.betting.dao.api.QuotaDao;
import project.betting.model.Match;
import project.betting.service.api.MatchService;

@Service
public class MatchServiceImpl implements MatchService {
	
	@Autowired
	private MatchDao matchDao;
	
	@Autowired
	private QuotaDao quotaDao;
	
	@Override
	public Match getMatchByID(int id) {
		Match match = matchDao.getMatchByID(id);
		//System.out.println("SERV: "+match);
		match.setQuotas(quotaDao.getQuotaListByMatchID(id));
		return match;
	}
	public List<Match> getMatchListByListOfID(List<Integer> listID){
		return matchDao.getMatchListByListOfID(listID);
	}
}
