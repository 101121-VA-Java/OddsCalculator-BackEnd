package com.revature.Services;

public class RecommendationService {

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
	
}
