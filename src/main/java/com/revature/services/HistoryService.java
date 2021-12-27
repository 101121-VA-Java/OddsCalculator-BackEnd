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
		System.out.println("I hope it isnt hitting this..");
		hd.save(h);
		User user = ud.findUserByuserid(h.getPlayerID());
		System.out.println(h.getUserbalance());
		System.out.println(user.getBalance());
		if(h.getOutcome().equals(Outcome.WIN)) {
			int wins = ud.getById(h.getPlayerID()).getWins() +1;
			ud.updateUserWins(h.getPlayerID(), wins);
			 System.out.println("Winning!");
				int tempbal = h.getBet(); 
				h.setUserbalance(user.getBalance() + tempbal);

//				h.setUserbalance(h.getUserbalance()+user.getBalance());
				ud.updateUserBalance(h.getPlayerID(), h.getUserbalance());
				
		}else if(h.getOutcome().equals(Outcome.LOSE)) {
			System.out.println("You snooze you lose");
			int losses = ud.getById(h.getPlayerID()).getLosses() +1;
			ud.updateUserLosses(h.getPlayerID(), losses);
			h.setUserbalance(user.getBalance()-h.getBet());
//			User user = ud.findUserByuserid(h.getPlayerID());
//			h.setUserbalance(user.getBalance() - h.getUserbalance());
			
			ud.updateUserBalance(h.getPlayerID(), h.getUserbalance());
		}
		else if(h.getOutcome().equals(Outcome.TIE)) {
			h.setUserbalance(user.getBalance());
			
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
		if(field.equals("userbalance")) {
			System.out.println("test Balance");
			if(h.getOutcome() == Outcome.WIN) {
				int tempbal = h.getBet() + h.getBet();
				h.setUserbalance(h.getUserbalance() + tempbal);
				
			}
			if(h.getOutcome() == Outcome.LOSE) {
				h.setUserbalance(h.getUserbalance()-h.getBet());
			}
			hd.updateHistoryUserbalance(id, h.getUserbalance());
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
			System.out.println("It hits all");
			 hd.updateHistoryFollowedRec(id, h.isFollowedRec());
			 hd.updateHistoryOutcome(id, h.getOutcome());
			 if(h.getOutcome().equals(Outcome.WIN)) {
					int wins = ud.getById(h.getPlayerID()).getWins() +1;
					ud.updateUserWins(h.getPlayerID(), wins);
				}else if(h.getOutcome().equals(Outcome.LOSE)) {
					int losses = ud.getById(h.getPlayerID()).getLosses() +1;
					ud.updateUserLosses(h.getPlayerID(), losses);
				}
			 if(h.getOutcome().equals(Outcome.WIN)) {
				 System.out.println("Winning!");
					int tempbal = h.getBet() + h.getBet();
					h.setUserbalance(h.getUserbalance() + tempbal);
					
				}
				if(h.getOutcome().equals(Outcome.LOSE)) {
					h.setUserbalance(h.getUserbalance()-h.getBet());
				}
			 hd.updateHistoryUserbalance(id, h.getUserbalance());
		}
		
		
	}
	
public int getWinsbyUserREC(int id) {
		int wins = 0;
		List <History> his =  hd.findByplayer_id(id);
		for(History h: his) {
			if(h.getOutcome().equals(Outcome.valueOf("WIN"))&&h.isFollowedRec()) {
				wins ++;
			}
		}
		return wins;
	}

	public int getWinsbyUsernotREC(int id) {
		int losses = 0;
		List <History> his =  hd.findByplayer_id(id);
		for(History h: his) {
			if(h.getOutcome().equals(Outcome.valueOf("WIN"))&&!h.isFollowedRec()) {
				losses ++;
			}
		}
		return losses;
	}
}
