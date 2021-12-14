package com.revature.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.Daos.HistoryDao;

@Service
public class RecommendationService {
private HistoryDao hd;

	
	@Autowired
	public HistoryService(HistoryDao hd) {
		this.hd = hd;
	}
	

	public String getRecommendation(String PH, String DH){
		String[] playerHand = PH.split("_");
		String value = playerHand[1];
		String type = playerHand[0];
		
		switch(type) {
			case "S": 
				break;
			case "H": 
				break;
			case "P": pairRecommendation(value, DH);
				break;
		}
		
		return null;
	}
	
	public String pairRecommendation(String value, String DH) {
		String rec = null;
		if(value.equals("A") || value.equals("8")) {
			rec = "Split";
		}
		if(value.equals("10")) {
			rec = "Do not split, stand";
		}
		if(value.equals("9")) {
			rec = "Do not split, stand";
		}
		
		
		return rec;
	}
	
	
	public int addHandToHistory(int id, String PH, String DH, String rec) {
		History hand = new History(id, PH, rec, DH);
		hd.save(hand);
		return gameID;
	}
	
}
