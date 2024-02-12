package fr.ensma.a3.ia.exo1_1;

public class ThreadLecture extends Thread {
    private long periode;
    private int duree;
    private IMdd Mdd;
    private int numIte =0;

    public ThreadLecture (final long p, final int d, final String nom, final IMdd md) {
        super(nom);
        periode = p;
        duree = d;
        Mdd = md;
    }

    @Override
    public void run() {
        long reveil = System.currentTimeMillis();
        while (System.currentTimeMillis() <= reveil + (duree * 1000)) {
            System.out.println(getName() + " s'execute a : " + System.currentTimeMillis() + "-> iteration " + ++numIte
             + "; vient de lire : " + Mdd.lireData());

             try {
                sleep(periode);
             } catch (InterruptedException e) {
                e.printStackTrace();
             }

        }
    }

}
