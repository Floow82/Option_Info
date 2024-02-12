package fr.ensma.a3.ia.amo.td1.exo4;

import java.util.TimerTask;

public class TachePeriodique extends TimerTask {
	private String nomThread;
	private int numIte = 0;

	public TachePeriodique(String nom) {
		nomThread = nom;
	}

	@Override
	public void run() {
		System.out.println("Task-" + nomThread + " s'exécute à la date " +
				+System.currentTimeMillis() + " ; Iteration " + ++numIte);
		// Contexte exécution
		System.out.println(Thread.currentThread().getName());
	}
}
