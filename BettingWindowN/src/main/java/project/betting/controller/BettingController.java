package project.betting.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.betting.dao.api.QuotaDao;
import project.betting.model.Bet;
import project.betting.model.Match;
import project.betting.model.extra.Carrier;
import project.betting.service.api.BetService;
import project.betting.service.api.CompetitionService;
import project.betting.service.api.MatchService;

@Controller
@RequestMapping("betting")
public class BettingController {
	
	@Autowired
	private CompetitionService competitionService;
	
	@Autowired
	private BetService betService;
	
	@Autowired
	private MatchService matchService;
	
	@Autowired
	private QuotaDao quotaDao;
	
	@RequestMapping(value="showBets/{id}", method=RequestMethod.GET)
	public String showBets(@PathVariable("id") Integer id, ModelMap modelMap){
		
		modelMap.put("competitions", competitionService.getCompetitionListWithBettableMatchesBySportID(id));
		Carrier carrier = new Carrier();
		List<Integer> checked = new ArrayList<Integer>();
		List<String> tips = new ArrayList<String>();
		List<Integer> invested = new ArrayList<Integer>();
		carrier.setChecked(checked);
		carrier.setTips(tips);
		carrier.setInvested(invested);
		modelMap.put("carrier", carrier);
		return "betting/showBets";
	}
	
	@RequestMapping(value = "processBets", method = RequestMethod.POST)
	public String processBets(@ModelAttribute("carrier") Carrier carrier, ModelMap modelMap) {
		betService.insertBatch(carrier);
		modelMap.put("carrier", carrier);
		modelMap.put("matches", matchService.getMatchListByListOfID(carrier.getChecked()));
		return "betting/finished";
	}
	
	@RequestMapping(value="myBets", method = RequestMethod.GET)
	public String myBets(ModelMap modelMap) {
		List<Bet> myBets = betService.getBetListWithMatchesByClientID(42);
		for(Bet bet: myBets) {
			bet.setMatch(matchService.getMatchByID(bet.getMatchID()));
			bet.getMatch().setQuotas(quotaDao.getQuotaListByMatchID(bet.getMatchID()));
		}
		modelMap.put("myBets", myBets);
		return "betting/myBets";
	}
}
