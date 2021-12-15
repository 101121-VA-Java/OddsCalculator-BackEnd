package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
//import org.springframework.data.annotation.Id;

@Entity
@Table(name="History")
public class History {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int game_id;
	@Column(name = "player_id", nullable=false)
	private int player_id;
	@Column(nullable=true)
	private boolean winner;
	@Column(name = "initialodds", nullable=false)
	private float initialOdds;
	@Column(name = "balance", nullable=true)
	private float balance;
	@Column(name = "initialhand", nullable=false)
	private String initialHand;
	//private String initialDealerCard;
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
		//this.initialDealerCard = initialDealerCard;
		this.recommendation = recommendation;
		this.initialOdds = 0;
		this.numOfDecks = 6;
		this.followedrec = false;
	}



	public History(int gameID, int playerID, boolean winner, float balance, String initialHand,
			String recommendation, boolean followedRec) {
		super();
		this.game_id = gameID;
		this.player_id = playerID;
		this.winner = winner;
		this.initialOdds = 0;
		this.balance = balance;
		this.initialHand = initialHand;
		this.recommendation = recommendation;
		this.followedrec = followedRec;
		this.numOfDecks = 6;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(balance);
		result = prime * result + (followedrec ? 1231 : 1237);
		result = prime * result + game_id;
		result = prime * result + ((initialHand == null) ? 0 : initialHand.hashCode());
		result = prime * result + player_id;
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
		if (followedrec != other.followedrec)
			return false;
		if (game_id != other.game_id)
			return false;
		if (initialHand == null) {
			if (other.initialHand != null)
				return false;
		} else if (!initialHand.equals(other.initialHand))
			return false;
		if (player_id != other.player_id)
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
		return "History [gameID=" + game_id + ", playerID=" + player_id + ", winner=" + winner + 
				", balance=" + balance + ", initialHand=" + initialHand + ", recommendation="
				+ recommendation + ", followedRec=" + followedrec + "]";
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


//	public String getInitialDealerHand() {
//		return initialDealerCard;
//	}
//
//
//	public void setInitialDealerHand(String initialDealerCard) {
//		this.initialDealerCard = initialDealerCard;
//	}



	public float getInitialOdds() {
		return initialOdds;
	}



	public void setInitialOdds(float initialOdds) {
		this.initialOdds = initialOdds;
	}



	public int getNumOfDecks() {
		return numOfDecks;
	}



	public void setNumOfDecks(int numOfDecks) {
		this.numOfDecks = numOfDecks;
	}
	
	

}
