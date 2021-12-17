package com.revature.Daos;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.models.History;


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
	@Query("UPDATE history h SET h.winner = ?2 WHERE h.game_id = ?1")
	void updateHistoryWinner(int gameID, boolean winner);
	
	@Transactional
	@Modifying
	@Query("UPDATE history h SET h.followedrec = ?2 WHERE h.game_id = ?1")
	void updateHistoryFollowedRec(int gameID, boolean followed);	

}
