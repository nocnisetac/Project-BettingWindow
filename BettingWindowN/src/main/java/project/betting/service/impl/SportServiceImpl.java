package project.betting.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.betting.dao.api.CompetitionDao;
import project.betting.dao.api.MatchDao;
import project.betting.dao.api.QuotaDao;
import project.betting.dao.api.ResultDao;
import project.betting.dao.api.SportDao;
import project.betting.model.Competition;
import project.betting.model.Match;
import project.betting.model.Sport;
import project.betting.service.api.SportService;

@Service
public class SportServiceImpl implements SportService {
	
	@Autowired
	private SportDao sportDao;

	@Autowired
	private CompetitionDao competitionDao;
	
	@Autowired
	private MatchDao matchDao;
	
	@Autowired
	private ResultDao resultDao;
	
	@Autowired
	private QuotaDao quotaDao;
	
	@Override
	public Sport getByID(int id) {
		Sport sport = sportDao.getByID(id);
		sport.setCompets(competitionDao.getCompetitionListBySportID(id));
		for(Competition c : sport.getCompets()) {
			c.setMatches(matchDao.getMatchListByCompetitionID(c.getID()));
			for(Match m : c.getMatches()){
				m.setResults(resultDao.getByMatchID(m.getID()));
				m.setQuotas(quotaDao.getQuotaListByMatchID(m.getID()));
			}
		}
		return sport;
	}

	@Override
	public List<Sport> getSports() {
		return sportDao.getSports();
	}

}
