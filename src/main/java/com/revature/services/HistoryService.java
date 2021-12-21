package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.Daos.HistoryDao;
import com.revature.Daos.UserDao;
import com.revature.models.History;
import com.revature.models.Outcome;
import com.revature.models.User;


@Service
public class HistoryService {
	private HistoryDao hd;
	private UserDao ud;
	
	@Autowired
	public HistoryService(HistoryDao hd, UserDao ud) {
		this.hd = hd;
		this.ud = ud;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void createHistory(History h) {
		hd.save(h);
		if(h.getOutcome().equals(Outcome.WIN)) {
			int wins = ud.getById(h.getPlayerID()).getWins() +1;
			ud.updateUserWins(h.getPlayerID(), wins);
		}else if(h.getOutcome().equals(Outcome.LOSE)) {
			int losses = ud.getById(h.getPlayerID()).getLosses() +1;
			ud.updateUserLosses(h.getPlayerID(), losses);
		}
	}
	
	public List<History> getAllHistory(){
		return hd.findAll();
		
	}
	
	public Optional<History> getHistory(int id){
		return hd.findById(id);
		
	}
	
	public List<History> getHistorybyUser(int Userid){
		return hd.findByplayer_id(Userid);
		
	}
	
	public void updateHistory(int id, History h, String field) {
		if(field.equals("balance")) {
			hd.updateHistoryBalance(id, h.getBalance());
		}else if(field.equals("outcome")) {
			hd.updateHistoryOutcome(id, h.getOutcome());
			if(h.getOutcome().equals(Outcome.WIN)) {
				int wins = ud.getById(h.getPlayerID()).getWins() +1;
				ud.updateUserWins(h.getPlayerID(), wins);
			}else if(h.getOutcome().equals(Outcome.LOSE)) {
				int losses = ud.getById(h.getPlayerID()).getLosses() +1;
				ud.updateUserLosses(h.getPlayerID(), losses);
			}
		}else if(field.equals("followedrec")) {
			 hd.updateHistoryFollowedRec(id, h.isFollowedRec());
		}
		else if(field.equals("all")) {
			 hd.updateHistoryFollowedRec(id, h.isFollowedRec());
			 hd.updateHistoryOutcome(id, h.getOutcome());
			 if(h.getOutcome().equals(Outcome.WIN)) {
					int wins = ud.getById(h.getPlayerID()).getWins() +1;
					ud.updateUserWins(h.getPlayerID(), wins);
				}else if(h.getOutcome().equals(Outcome.LOSE)) {
					int losses = ud.getById(h.getPlayerID()).getLosses() +1;
					ud.updateUserLosses(h.getPlayerID(), losses);
				}
			 hd.updateHistoryBalance(id, h.getBalance());
		}
		
		
	}
	

}
