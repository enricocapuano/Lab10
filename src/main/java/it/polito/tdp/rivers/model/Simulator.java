 package it.polito.tdp.rivers.model;

import java.util.PriorityQueue;

public class Simulator {
	
	
	
	//Coda degli eventi
	private PriorityQueue<Flow> queue;
	
	//Modello del mondo
	private float Q = 0;
	private float C = 0;
	private int giorniPassati;
	
	//Parametri di output
	private int nGiorni;
	private float cMed;
	
	public void run(int id, float k, float fMed, PriorityQueue<Flow> coda) {
		nGiorni = 0;
		cMed = 0;
		this.queue = new PriorityQueue<>();
		queue = coda;
		Q = k*fMed*30*86400;
		C = Q/2;
		Flow f;
		while((f = queue.poll()) != null)  {
			giorniPassati++;
			double x = Math.random();
			float deltaFlusso = 0;
			if(x <= 0.95) {
				deltaFlusso = (float) (C + f.getFlow()*86400 - 0.8*fMed*86400);
				if(deltaFlusso < Q && deltaFlusso > 0)
					C = deltaFlusso;
				else {
					C = C - deltaFlusso;
					nGiorni++;
				}
				
			}else {
				deltaFlusso = (float) (C + f.getFlow()*86400 - 10*0.8*fMed*86400);
				if(deltaFlusso < Q && deltaFlusso > 0)
					C = deltaFlusso;
				else {
					C = C - deltaFlusso;
					nGiorni++;
				}
			}
			cMed = C/giorniPassati;
		}
	}
	
	public int getGiorni() {
		return nGiorni;
	}
	
	public float getCMed() {
		return cMed;
	}

}
