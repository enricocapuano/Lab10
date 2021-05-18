package it.polito.tdp.rivers.model;

import java.util.PriorityQueue;

public class Simulator {
	
	private Model m;
	
	public Simulator() {
		m = new Model();
	}
	
	//Coda degli eventi
	private PriorityQueue<Flow> queue;
	
	//Modello del mondo
	private int Q = 0;
	private int C = 0;
	
	//Parametri di output
	private int nGiorni;
	private float cMed;
	
	public void run(int id, int k, int fMed) {
		this.queue = new PriorityQueue<>();
		m.getAllFlows(queue, id);
		Q = k*fMed*30;
		C = Q/2;
		while(!queue.isEmpty()) {
			
		}
	}
	

}
