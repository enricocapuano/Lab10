package it.polito.tdp.rivers.model;

import java.util.List;
import java.util.PriorityQueue;

import it.polito.tdp.rivers.db.RiversDAO;

public class Model {

	RiversDAO dao;
	
	public Model() {
		dao = new RiversDAO();
	}
	
	public List<River> getAllRivers() {
		return dao.getAllRivers();
	}
	
	public Info getInfoRiver(int id) {
		return dao.getInfoRiver(id);
	}
	
	public void getAllFlows(PriorityQueue<Flow> queue, int id) {
		dao.getAllFlows(queue, id);
	}

	
}
