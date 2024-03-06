package fr.ensma.a3.ia.exo2_1;

public class ThreadSend extends Thread {

    private IBal<Message> bal;
    private int periode;

    public ThreadSend(final String nom, final IBal<Message> b, final int p) {
        super(nom);
        bal = b;
        periode = p;
    }

    @Override
    public void run() {
        while (true) {
            bal.sendMessage(new Message(getName()));
            try {
                sleep(periode);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
