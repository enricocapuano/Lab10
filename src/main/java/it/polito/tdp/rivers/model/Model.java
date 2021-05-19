package it.polito.tdp.rivers.model;

import java.util.List;
import java.util.PriorityQueue;

import it.polito.tdp.rivers.db.RiversDAO;

public class Model {

	RiversDAO dao;
	Simulator sim;
	
	public Model() {
		dao = new RiversDAO();
		sim = new Simulator();
	}
	
	public List<River> getAllRivers() {
		return dao.getAllRivers();
	}
	
	public Info getInfoRiver(int id) {
		return dao.getInfoRiver(id);
	}
	
	public PriorityQueue<Flow> getAllFlows(int id) {
		return dao.getAllFlows(id);
	}
	
	public void run(int id, float k, float fMed) {
		sim.run(id, k, fMed, this.getAllFlows(id));
	}
	
	public int getGiorni() {
		return sim.getGiorni();
	}

	public float getCMed() {
		return sim.getCMed();
	}
}
