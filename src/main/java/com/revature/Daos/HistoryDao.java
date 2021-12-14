package com.revature.Daos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.History;


@Repository
public interface HistoryDao extends JpaRepository<History, Integer>{
	

}
