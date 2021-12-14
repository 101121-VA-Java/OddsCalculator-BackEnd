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
			rec = "Split ";
		}
		if(value.equals("10")) {
			//becomes a hard total -> needs to be passed into hardRecs
			rec = "Do not split ";
		}
		if( (value.equals("9") && DH.equals("7")) || (value.equals("9") && DH.equals("10")) || (value.equals("9") && DH.equals("A")) ) { 
			//becomes a hard total -> needs to be passed into hardRecs
			rec = "Do not split ";
		} else if(value.equals("9")) { 
			rec = "Split";
		}
		if(value.equals("8")) { 
			rec = "Split";
		}
		if( (value.equals("7") && DH.equals("8")) || (value.equals("7") && DH.equals("9")) || (value.equals("7") && DH.equals("10")) || (value.equals("7") && DH.equals("A")) ) { 
			//becomes a hard total -> needs to be passed into hardRecs
			rec = "Do not split ";
		} else if(value.equals("7")) { 
			rec = "Split";
		}
		if( (value.equals("6") && DH.equals("3")) || (value.equals("6") && DH.equals("4")) || (value.equals("6") && DH.equals("5")) ) { 
			rec = "Split";
		} else if (value.equals("6") && DH.equals("2")) {
			//becomes a hard total -> needs to be passed into hardRecs
			rec = "Split and double bet ";
		} else if (value.equals("6")) {
			//becomes a hard total -> needs to be passed into hardRecs
			rec = "Do not split ";
		}
		if(value.equals("5")) { 
			//becomes a hard total -> needs to be passed into hardRecs
			rec = "Do not split ";
		}
		if( (value.equals("4") && DH.equals("5")) || (value.equals("4") && DH.equals("6")) ) {
			//becomes a hard total -> needs to be passed into hardRecs
			rec = "Split and double ";
		} else if(value.equals("4")) {
			//becomes a hard total -> needs to be passed into hardRecs
			rec = "Do not split ";
		}
		if( (value.equals("3") && DH.equals("2")) || (value.equals("3") && DH.equals("3")) ) {
			rec = "Split and double ";
		} else if((value.equals("3") && DH.equals("4")) || (value.equals("3") && DH.equals("5")) || (value.equals("3") && DH.equals("6")) || (value.equals("3") && DH.equals("7")) ) {
			rec = "Split ";
		} else if(value.equals("3")) {
			rec = "Do not split";
		}
		if( (value.equals("2") && DH.equals("2")) || (value.equals("2") && DH.equals("3")) ) {
			rec = "Split and double ";
		} else if((value.equals("2") && DH.equals("4")) || (value.equals("2") && DH.equals("5")) || (value.equals("2") && DH.equals("6")) || (value.equals("2") && DH.equals("7")) ) {
			rec = "Split ";
		} else if(value.equals("2")) {
			rec = "Do not split ";
		}
		
		return rec;
	}
	
	
	public int addHandToHistory(int id, String PH, String DH, String rec) {
		History hand = new History(id, PH, rec, DH);
		hd.save(hand);
		return gameID;
	}
	
}
