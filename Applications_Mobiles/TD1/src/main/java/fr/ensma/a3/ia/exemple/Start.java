package fr.ensma.a3.ia.exemple;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        MonThread mt = new MonThread(1);
        Thread th = new Thread(mt);
        // th.setPriority(1);
        th.start();
        th.join();

        MonThread mt2 = new MonThread(2);
        Thread th2 = new Thread(mt2);
        th2.setPriority(1);
        th2.start();

        MonThread mt3 = new MonThread(3);
        Thread th3 = new Thread(mt3);
        th2.setPriority(10);
        th3.start();

    }
}
