package fr.ensma.a3.ia.amo.td1.exo3;

public class StartExo3 {

	public static void main(String[] args) {
		MonThread th1 = new MonThread(500, 30, "TH1");
		MonThread th2 = new MonThread(1000, 20, "TH2");

		th1.start();
		th2.start();

		try {
			 th1.join(3000);
			System.out.println("===> Fin attente Th1");
			 th2.join(5000);
			// th1.join();
			// th2.join();
			System.out.println("===========Prog FINI============");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
