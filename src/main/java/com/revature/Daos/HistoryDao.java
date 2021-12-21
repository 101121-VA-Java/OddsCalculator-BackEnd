package com.revature.Daos;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.models.History;
import com.revature.models.Outcome;


@Repository
public interface HistoryDao extends JpaRepository<History, Integer>{
	

	@Query("SELECT h FROM history h WHERE h.player_id = ?1")
	List<History> findByplayer_id(int userid);
	
	@Transactional
	@Modifying
	@Query("UPDATE history h SET h.balance = ?2 WHERE h.game_id = ?1")
	void updateHistoryBalance(int gameID, float balance);
	
	@Transactional
	@Modifying
	@Query("UPDATE history h SET h.outcome = ?2 WHERE h.game_id = ?1")
	void updateHistoryOutcome(int gameID, Outcome outcome);
	
	@Transactional
	@Modifying
	@Query("UPDATE history h SET h.followedrec = ?2 WHERE h.game_id = ?1")
	void updateHistoryFollowedRec(int gameID, boolean followed);	

}
