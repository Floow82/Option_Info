package fr.ensma.a3.ia.exo1_1;

/**
 * Implémnentation du Mdd
 * @see IMdd
 */

public class Mdd implements IMdd {

    private String laData;

    public Mdd() {
        laData = "";
    }

    /**
     * Modifie la valeur de la donnée dans le Mdd.
     * Utilisation de synchronized pour assurer l'accès unique.
     */
    public synchronized void ecrireData(final String d) {
        laData = d;
    }

    /**
     * Obtient la valeur contenu dans le Mdd.
     * Utilisation de synchronized pour assurer l'accès unique.
     */
    public synchronized String lireData() {
        try {
            Thread.sleep(500); //Pour simuler le fait que ca dure plus longtemps
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return laData;
    }
}
