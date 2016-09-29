package project.betting.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.betting.model.Client;
import project.betting.model.extra.Err;
import project.betting.service.api.ClientService;
import project.betting.service.api.SportService;

@Controller
@RequestMapping("betting")
public class HomeController {
	@Autowired
	private SportService sportService;
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("sports", sportService.getSports());
		return "betting/index";
	}
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(ModelMap modelMap) {
		modelMap.put("client", new Client());
		return "betting/register";
	}
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(
			@ModelAttribute("client") @Valid Client account,
			BindingResult bindingResult,
			ModelMap modelMap) {
		if(bindingResult.hasErrors()) {
			modelMap.put("client", account);
			return "betting/register";
		} else {
			Err err = null;
			int exists = clientService.doesPasswordExist(account.getPassword());
			if(exists==1){
				err = new Err();
				modelMap.put("err", err);
				return "betting/register";
				}
			else {
				modelMap.put("client", account);
				modelMap.put("err", err);
				clientService.enterNewClient(account);
				return "betting/success";
			}	
		}
	}
}
