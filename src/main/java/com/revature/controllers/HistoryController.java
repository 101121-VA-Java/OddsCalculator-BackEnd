package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.revature.models.History;
import com.revature.services.HistoryService;

@RestController
@RequestMapping("/history")
@CrossOrigin
public class HistoryController {

		private HistoryService hs;
	
	@Autowired
	public HistoryController(HistoryService hs) {
		this.hs = hs;
	}
	@CrossOrigin
	@GetMapping
	public List<History> getAllHistory(){

		System.out.println("Getting All History");
		return hs.getAllHistory();
	}
	
	@CrossOrigin
	@GetMapping(value="/{id}")
	public History getHistory(@RequestParam(name="id", required = true)int id){
		
		System.out.println("Getting History " + id);
		return hs.getHistory(id);
		
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody History history){
		hs.createHistory(history);
		//System.out.println("We here!");
		return new ResponseEntity<>(history.getGameID() + " was created.", HttpStatus.CREATED);
	}

}
