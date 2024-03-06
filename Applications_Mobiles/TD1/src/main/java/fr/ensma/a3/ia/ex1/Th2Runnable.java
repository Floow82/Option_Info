package fr.ensma.a3.ia.ex1;

public class Th2Runnable implements Runnable {

    private TableauNoir monTabNoir;

    public Th2Runnable(TableauNoir tabn) {
        monTabNoir = tabn;
    }
    /**
     * Redéfinition du corps du Thread. Issu de l'interface Runnable.
     *
     * @see Runnable
     */
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " lit valeur " + monTabNoir.getValeur());
            System.out.println(Thread.currentThread().getName() + " calcul " + monTabNoir.getValeur() * 10);
            try {
                Thread.sleep(500); //Arret quand val supp à 500
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}