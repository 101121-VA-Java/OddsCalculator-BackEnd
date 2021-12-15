package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.Daos.HistoryDao;
import com.revature.models.History;

@Service
public class RecommendationService {
private HistoryDao hd;

	
	@Autowired
	public void HistoryService(HistoryDao hd) {
		this.hd = hd;
	}
	

	public String getRecommendation(String PH, String DH){
		String[] playerHand = PH.split("_");
		String value = playerHand[1];
		String type = playerHand[0];
		String rec = null;
		switch(type) {
			case "S": 
				break;
			case "H": 
				rec = hardRecommendation(value, DH);
				break;
			case "P": 
				rec = pairRecommendation(value, DH);
				break;
		}
		
		return rec;
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
	
	public String hardRecommendation(String value, String DH) {
		String rec;
		int val = Integer.parseInt(value);
		switch (val) {
		case 21:
		case 20:
		case 19:
		case 18:
		case 17:
			rec = "Stand";
			break;
		case 16:
			if(DH.equals("A")||DH.equals("9")) {
				rec = "Surrender";
				break;
			}
		case 15:
			if(DH.equals("10")) {
				rec = "Surrender";
				break;
			}
		case 14:
		case 13:
			if(DH.equals("A")||Integer.parseInt(DH)>6) {
				rec = "Hit";
			}else {
				rec = "Stand";
			}
			break;
		case 12:
			if(DH.equals("A")||(Integer.parseInt(DH)>6||Integer.parseInt(DH)<4)) {
				rec = "Stand";
			}else {
				rec = "Hit";
			}
			break;
		case 11:
			rec = "Double if Allowed, otherwise hit";
			break;
		case 10:
			if(DH.equals("A")||DH.equals("10")) {
				rec = "Hit";
			}else {
				rec = "Double if Allowed, otherwise hit";
			}
			break;
		case 9:
			if(DH.equals("A")||(Integer.parseInt(DH)>6||Integer.parseInt(DH)<3)) {
				rec = "Double if Allowed, otherwise hit";
			}else {
				rec = "Hit";
			}
			break;
		case 8:
		case 7:
		case 6:
		case 5:
		case 4:
			rec = "hit";
			break;
		default:
			rec = "Input not recognized";
		}
		return rec;
	}
	
	
	public void addHandToHistory(int id, String PH, String DH, String rec) {
		History hand = new History(id, PH, rec, DH);
		hd.save(hand);
		//return gameID;
	}
	
}
