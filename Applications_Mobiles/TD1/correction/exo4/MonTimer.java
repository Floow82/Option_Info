package fr.ensma.a3.ia.amo.td1.exo4;

import java.util.Timer;

public class MonTimer {
	private Timer monTimer;
	private Timer monTimer2;

	public MonTimer(){
		monTimer = new Timer();

		monTimer2 = new Timer();
		TachePeriodique tch1 = new TachePeriodique("TH1");
		TachePeriodique tch2 = new TachePeriodique("Th2");
		TachePeriodique tch3 = new TachePeriodique("Th3");
		monTimer.scheduleAtFixedRate(tch1, 0l, 500l);
		//monTimer.scheduleAtFixedRate(tch2, 250l, 1000l);
		monTimer2.scheduleAtFixedRate(tch3, 250l, 1000l);
		try {
			Thread.sleep(20000);
			tch3.cancel();
			Thread.sleep(10000);
			tch1.cancel();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("===========Prog FINI============");
		monTimer.cancel();
		monTimer2.cancel();
	}
}
