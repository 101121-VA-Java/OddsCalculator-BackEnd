package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.Daos.HistoryDao;
import com.revature.models.History;


@Service
public class HistoryService {
	private HistoryDao hd;
	
	@Autowired
	public HistoryService(HistoryDao hd) {
		this.hd = hd;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void createHistory(History h) {
		hd.save(h);
	}
	
	public List<History> getAllUsers(){
		return hd.findAll();
		
	}
	
	public History getUser(int id){
		return hd.getById(id);
		
	}
	

}
