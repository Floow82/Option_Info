package fr.ensma.a3.ia.amo.td1.exo3;

public class MonThread extends Thread {

	public long maPeriode;
	public int maDuree;

	public MonThread(long perio,int duree,String nom) {
		super(nom);
		maPeriode = perio;
		maDuree = duree;
	}

	@Override
	public void run() {
		long reveil = System.currentTimeMillis();
		while(System.currentTimeMillis()<=reveil+(maDuree*1000)){
			System.out.println(getName() + "s'execute a :"+
					System.currentTimeMillis());
			try {
				sleep(maPeriode);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}