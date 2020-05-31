package com.covid.CovidTracker.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.covid.CovidTracker.Model.CaseStatus;
import com.covid.CovidTracker.Services.DataAcessService;

@Controller
public class covidController {
    @Autowired
	DataAcessService dataservice;
    
	@GetMapping("/")
	public String showDetails(Model model) {
		List<CaseStatus> totallist = dataservice.getAllList();
		int sumcases = totallist.stream().mapToInt(tot -> tot.getNewCases()).sum();
		model.addAttribute("allListOfCases", totallist);
		model.addAttribute("sumcases", sumcases);
		return "home";
	}
	@GetMapping("/filtered")
	public String showDetails_filtered(Model model) {
		List<CaseStatus> totallist = dataservice.getAllList();
		int sumcases = totallist.stream().mapToInt(tot -> tot.getNewCases()).sum();
		model.addAttribute("allListOfCases", totallist);
		model.addAttribute("sumcases", sumcases);
		return "home_Filtered";
	}
}
