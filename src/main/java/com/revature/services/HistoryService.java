package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.Daos.HistoryDao;
import com.revature.models.History;


@Service
public class HistoryService {
	private HistoryDao hd;
	
	@Autowired
	public HistoryService(HistoryDao hd) {
		this.hd = hd;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void createHistory(History h) {
		hd.save(h);
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
		}else if(field.equals("winner")) {
			hd.updateHistoryOutcome(id, h.getOutcome());
		}else if(field.equals("followedrec")) {
			 hd.updateHistoryFollowedRec(id, h.isFollowedRec());
		}
		else if(field.equals("all")) {
			 hd.updateHistoryFollowedRec(id, h.isFollowedRec());
			 hd.updateHistoryOutcome(id, h.getOutcome());
			 hd.updateHistoryBalance(id, h.getBalance());
		}
		
		
	}
	

}
