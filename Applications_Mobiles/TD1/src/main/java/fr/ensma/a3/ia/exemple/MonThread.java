package fr.ensma.a3.ia.exemple;

public class MonThread implements Runnable{
    private int number;
    public MonThread(int n) {
        this.number = n;
    }
    @Override
    public void run() {
        for (int i =1; i<=5; i++) {
            System.out.println(i + " from thread " + number);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

}
