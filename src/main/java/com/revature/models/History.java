package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import javax.persistence.Id;
//import org.springframework.data.annotation.Id;

@Entity(name="history")
//@Table
public class History {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int game_id;
	//@ForeignKey(name = "player_id")
	@Column(name = "player_id", nullable=false)
	private int player_id;
	@Column(name = "outcome", nullable=true)
	private Outcome outcome;
//	@Column(name = "initialodds", nullable=false)
//	private float initialOdds;
	@Column(name = "balance", nullable=true)
	private float balance;
	@Column(name = "initialhand", nullable=false)
	private String initialHand;
	@Column(name = "dealerhand", nullable=false)
	private String initialDealerCard;
	@Column(name = "recommend", nullable=false)
	private String recommendation;
	@Column(name = "followedrec", nullable=true)
	private boolean followedrec;
	@Column(name = "numofdecks", nullable=false)
	private int numOfDecks;

	public History() {
		// TODO Auto-generated constructor stub
	}
	
	

	public History(int playerID, String initialHand, String recommendation, String initialDealerCard) {
		super();
		this.player_id = playerID;
		this.initialHand = initialHand;
		this.initialDealerCard = initialDealerCard;
		this.recommendation = recommendation;
		this.numOfDecks = 6;
		this.followedrec = false;
	}



	public History(int gameID, int playerID, Outcome outcome, float balance, String initialHand, String initialDealerCard,
			String recommendation, boolean followedRec) {
		super();
		this.game_id = gameID;
		this.player_id = playerID;
		this.outcome = outcome;
		this.initialDealerCard = initialDealerCard;
		this.balance = balance;
		this.initialHand = initialHand;
		this.recommendation = recommendation;
		this.followedrec = followedRec;
		this.numOfDecks = 6;
	}



	@Override
	public String toString() {
		return "History [game_id=" + game_id + ", player_id=" + player_id + ", Outcome=" + outcome + ", balance="
				+ balance + ", initialHand=" + initialHand + ", initialDealerCard=" + initialDealerCard
				+ ", recommendation=" + recommendation + ", followedrec=" + followedrec + ", numOfDecks=" + numOfDecks
				+ "]";
	}







	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(balance);
		result = prime * result + (followedrec ? 1231 : 1237);
		result = prime * result + game_id;
		result = prime * result + ((initialDealerCard == null) ? 0 : initialDealerCard.hashCode());
		result = prime * result + ((initialHand == null) ? 0 : initialHand.hashCode());
		result = prime * result + numOfDecks;
		result = prime * result + ((outcome == null) ? 0 : outcome.hashCode());
		result = prime * result + player_id;
		result = prime * result + ((recommendation == null) ? 0 : recommendation.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		History other = (History) obj;
		if (Float.floatToIntBits(balance) != Float.floatToIntBits(other.balance))
			return false;
		if (followedrec != other.followedrec)
			return false;
		if (game_id != other.game_id)
			return false;
		if (initialDealerCard == null) {
			if (other.initialDealerCard != null)
				return false;
		} else if (!initialDealerCard.equals(other.initialDealerCard))
			return false;
		if (initialHand == null) {
			if (other.initialHand != null)
				return false;
		} else if (!initialHand.equals(other.initialHand))
			return false;
		if (numOfDecks != other.numOfDecks)
			return false;
		if (outcome != other.outcome)
			return false;
		if (player_id != other.player_id)
			return false;
		if (recommendation == null) {
			if (other.recommendation != null)
				return false;
		} else if (!recommendation.equals(other.recommendation))
			return false;
		return true;
	}



	public int getGameID() {
		return game_id;
	}

	public void setGameID(int gameID) {
		this.game_id = gameID;
	}

	public int getPlayerID() {
		return player_id;
	}

	public void setPlayerID(int playerID) {
		this.player_id = playerID;
	}

	

//	public float getInitialOdds() {
//		return initialOdds;
//	}
//
//	public void setInitialOdds(float initialOdds) {
//		this.initialOdds = initialOdds;
//	}

	public Outcome getOutcome() {
		return outcome;
	}



	public void setOutcome(Outcome outcome) {
		this.outcome = outcome;
	}



	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getInitialHand() {
		return initialHand;
	}

	public void setInitialHand(String initialHand) {
		this.initialHand = initialHand;
	}

	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

	public boolean isFollowedRec() {
		return followedrec;
	}

	public void setFollowedRec(boolean followedRec) {
		this.followedrec = followedRec;
	}

//	public int getNumOfDecks() {
//		return numOfDecks;
//	}
//
//	public void setNumOfDecks(int numOfDecks) {
//		this.numOfDecks = numOfDecks;
//	}


	public String getInitialDealerHand() {
		return initialDealerCard;
	}


	public void setInitialDealerHand(String initialDealerCard) {
		this.initialDealerCard = initialDealerCard;
	}



//	public float getInitialOdds() {
//		return initialOdds;
//	}
//
//
//
//	public void setInitialOdds(float initialOdds) {
//		this.initialOdds = initialOdds;
//	}



	public int getNumOfDecks() {
		return numOfDecks;
	}



	public void setNumOfDecks(int numOfDecks) {
		this.numOfDecks = numOfDecks;
	}
	
	

}
