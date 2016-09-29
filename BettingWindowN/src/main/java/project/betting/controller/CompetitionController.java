package project.betting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.betting.model.Match;
import project.betting.service.api.CompetitionService;
import project.betting.service.api.MatchService;

@Controller
@RequestMapping("betting")
public class CompetitionController {

	@Autowired
	private CompetitionService competitionService;
	
	@RequestMapping(value = "competitions/{id}", method=RequestMethod.GET)
	public String competitionsAndTeams(@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.put("competitions", competitionService.getCompetitionListWithTeamsBySportID(id));
		modelMap.put("i", new Match());
		return "betting/competitions";
	}
	
	

	@RequestMapping(value = "bettable/{id}", method=RequestMethod.GET)
	public String bet(@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.put("competitions", competitionService.getCompetitionListWithBettableMatchesBySportID(id));
		return "betting/bettable";
	}
}
