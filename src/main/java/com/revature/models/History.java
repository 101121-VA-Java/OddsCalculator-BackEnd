package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name="history")
public class History {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int gameID;
	private int playerID;
	@Column(nullable=true)
	private boolean winner;
	//private float initialOdds;
	@Column(nullable=true)
	private float balance;
	private String initialHand;
	private String initialDealerCard;
	private String recommendation;
	@Column(nullable=true)
	private boolean followedRec;
	//private int numOfDecks;

	public History() {
		// TODO Auto-generated constructor stub
	}
	
	

	public History(int playerID, String initialHand, String recommendation, String initialDealerCard) {
		super();
		this.playerID = playerID;
		this.initialHand = initialHand;
		this.initialDealerCard = initialDealerCard;
		this.recommendation = recommendation;
	}



	public History(int gameID, int playerID, boolean winner, float balance, String initialHand,
			String recommendation, boolean followedRec) {
		super();
		this.gameID = gameID;
		this.playerID = playerID;
		this.winner = winner;
		//this.initialOdds = initialOdds;
		this.balance = balance;
		this.initialHand = initialHand;
		this.recommendation = recommendation;
		this.followedRec = followedRec;
		//this.numOfDecks = numOfDecks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(balance);
		result = prime * result + (followedRec ? 1231 : 1237);
		result = prime * result + gameID;
		result = prime * result + ((initialHand == null) ? 0 : initialHand.hashCode());
		result = prime * result + playerID;
		result = prime * result + ((recommendation == null) ? 0 : recommendation.hashCode());
		result = prime * result + (winner ? 1231 : 1237);
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
		if (followedRec != other.followedRec)
			return false;
		if (gameID != other.gameID)
			return false;
		if (initialHand == null) {
			if (other.initialHand != null)
				return false;
		} else if (!initialHand.equals(other.initialHand))
			return false;
		if (playerID != other.playerID)
			return false;
		if (recommendation == null) {
			if (other.recommendation != null)
				return false;
		} else if (!recommendation.equals(other.recommendation))
			return false;
		if (winner != other.winner)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "History [gameID=" + gameID + ", playerID=" + playerID + ", winner=" + winner + 
				", balance=" + balance + ", initialHand=" + initialHand + ", recommendation="
				+ recommendation + ", followedRec=" + followedRec + "]";
	}

	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

//	public float getInitialOdds() {
//		return initialOdds;
//	}
//
//	public void setInitialOdds(float initialOdds) {
//		this.initialOdds = initialOdds;
//	}

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
		return followedRec;
	}

	public void setFollowedRec(boolean followedRec) {
		this.followedRec = followedRec;
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
	
	

}
