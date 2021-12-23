package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping("/{id}")
	public Optional<History> getHistory(@PathVariable(name="id", required = true)int id){
		
		System.out.println("Getting History " + id);
		return hs.getHistory(id);
		
	}
	@CrossOrigin
	@GetMapping(value="/user/{id}")
	public List<History> getUserHistory(@PathVariable(name="id", required = true)int id){
		
		System.out.println("Getting User History " + id);
		return hs.getHistorybyUser(id);
		
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> createHistory(@RequestBody History history){
		history.setNumOfDecks(6);
		hs.createHistory(history);
		System.out.println("We here!");
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, value="/balance/{id}")
	public ResponseEntity<String> updateHistorybalance(@PathVariable(name="id", required = true)int id, @RequestBody History history){
		hs.updateHistory(id, history, "balance");
		System.out.println("We here!");
		return new ResponseEntity<>(history.getGameID() + " was updated.", HttpStatus.OK);
	}
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, value="/recfollowed/{id}")
	public ResponseEntity<String> updateHistoryrecfollowed(@PathVariable(name="id", required = true)int id, @RequestBody History history){
		hs.updateHistory(id, history, "followedrec");
		System.out.println("We here!");
		return new ResponseEntity<>(history.getGameID() + " was updated.", HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, value="/won/{id}")
	public ResponseEntity<String> updateHistoryrecwon(@PathVariable(name="id", required = true)int id, @RequestBody History history){
		hs.updateHistory(id, history, "outcome");
		System.out.println("We here!");
		return new ResponseEntity<>(history.getGameID() + " was updated.", HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, value="/gameover/{id}")
	public ResponseEntity<String> updateHistoryFinished(@PathVariable(name="id", required = true)int id, @RequestBody History history){
		hs.updateHistory(id, history, "all");
		System.out.println("We here!");
		return new ResponseEntity<>(history.getGameID() + " was updated.", HttpStatus.OK);
	}

}
