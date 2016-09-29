package project.betting.service.impl;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.betting.dao.api.CompetitionDao;
import project.betting.dao.api.MatchDao;
import project.betting.dao.api.QuotaDao;
import project.betting.dao.api.ResultDao;
import project.betting.dao.api.TeamDao;
import project.betting.model.Competition;
import project.betting.model.Match;
import project.betting.service.api.CompetitionService;

@Service
public class CompetitionServiceImpl implements CompetitionService {
	
	@Autowired
	private CompetitionDao competitionDao;
	
	@Autowired
	private MatchDao matchDao;
	
	@Autowired
	private ResultDao resultDao;
	
	@Autowired
	private QuotaDao quotaDao;
	
	@Autowired
	private TeamDao teamDao;
	
	@Override
	public List<Competition> getCompetitionListWithTeamsBySportID(int id) {
		List<Competition> compets = competitionDao.getCompetitionListBySportID(id);
		for(Competition c : compets) {
			c.setTeams(teamDao.getTeamListByCompetitionID(c.getID()));
		}
		return compets;
	}
	@Override
	public Competition getCompetitionByID(int id) {
		
		return competitionDao.getCompetitionByID(id);
	}

	@Override
	public List<Competition> getCompetitionListWithBettableMatchesBySportID(int id) {
		List<Competition> compets = competitionDao.getCompetitionListBySportID(id);
		for(Competition c : compets) {
			c.setMatches(matchDao.getBettableMatchListByCompetitionID(c.getID()));
			for(Match m : c.getMatches()){
				m.setQuotas(quotaDao.getQuotaListByMatchID(m.getID()));
			}
		}
		return compets;
	}

}
