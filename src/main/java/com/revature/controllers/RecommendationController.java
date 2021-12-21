package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.revature.Daos.HistoryDao;
import com.revature.models.History;
import com.revature.services.HistoryService;
import com.revature.services.RecommendationService;

@RestController
@RequestMapping("/rec")

public class RecommendationController {
	
	private RecommendationService rs;
	private HistoryDao hd;

	@Autowired
	public RecommendationController(RecommendationService rs, HistoryDao hd) {
		this.rs = rs;
		this.hd = hd;
	}
	


	
	@CrossOrigin
	@PostMapping("/{id}/{PH}/{DH}")
	public String getUserRecommendation(@PathVariable(name="id", required = true)int id, @PathVariable(name="PH", required = true)String ph, @PathVariable(name="DH", required = true)String dh){
		String rec = rs.getRecommendation(ph, dh);
		
		History h = new History(id, ph, rec, dh);
		History his = hd.save(h);
	return rec +":"+ his.getGameID();
	}

	@CrossOrigin
	@GetMapping("/{PH}/{DH}")
	public String getPlayerRecommendation(@PathVariable(name="PH", required = true)String ph, @PathVariable(name="DH", required = true)String dh){
		
		return rs.getRecommendation(ph, dh);
	}


}
