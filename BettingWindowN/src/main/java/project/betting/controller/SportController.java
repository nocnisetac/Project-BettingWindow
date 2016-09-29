package project.betting.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.betting.model.Competition;
import project.betting.service.api.CompetitionService;
import project.betting.service.api.SportService;

@Controller
@RequestMapping("betting")
public class SportController {
	
	@Autowired
	private SportService sportService;
	
	@RequestMapping(value = "sport/{id}", method=RequestMethod.GET)
	public String sport(@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.put("sport", sportService.getByID(id));
		return "betting/sport";
	}
}
