package com.revature.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Services.RecommendationService;

@RestController
@CrossOrigin

@RequestMapping("/Recommendation")

public class RecommendationController {

@PostMapping(value="/{id}/${PH}/${DH}")
	public String getUserRecommendation(@RequestParam(name="id", required = true)int id, @RequestParam(name="PH", required = true)String ph, @RequestParam(name="DH", required = true)String dh){
		return null;
	}


@GetMapping(value="/${PH}/${DH}")
	public String getPlayerRecommendation( @RequestParam(name="PH", required = true)String ph, @RequestParam(name="DH", required = true)String dh){
		
		return null;
	}


}
