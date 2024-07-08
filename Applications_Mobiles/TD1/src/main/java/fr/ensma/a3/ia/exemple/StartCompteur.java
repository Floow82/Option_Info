package fr.ensma.a3.ia.exemple;

public class StartCompteur {
    public static void main(String[] args) {
        Compteur compteur = new Compteur();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                synchronized(compteur){
                    compteur.increment();
                }

                // System.out.println("Thread 1 - Compteur : " + compteur.getCount());
                // try{
                //     Thread.sleep(200);
                // } catch (InterruptedException e) {
                // }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                synchronized(compteur){
                    compteur.decrement();
                }
                // System.out.println("Thread 2 - Compteur : " + compteur.getCount());
                // try{
                //     Thread.sleep(100);
                // } catch (InterruptedException e) {
                // }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("La valeur finale du compteur est : " + compteur.getCount());
    }
}
