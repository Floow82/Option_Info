package fr.ensma.a3.ia.ex2;

public class Th2Thread extends Thread {

    private TableauNoir monTab;
    private Thread copainTh1;

    public Th2Thread (TableauNoir tabn, Thread th1, String nom) {
        super(nom);
        copainTh1 = th1;
        monTab = tabn;
    }

    /*
     * Corps du thread.
     */

     @Override public void run() {
            while (true) {
                int val = monTab.getValeur();
                System.out.println(Thread.currentThread().getName() + "lit valeur" + val);
                val *= 10;
                System.out.println(Thread.currentThread().getName() + " calcul " + val);
                if (val > 250) {
                    System.out.println("Envoie demande interruption ...");
                    copainTh1.interrupt();
                    return;
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
     }


}
