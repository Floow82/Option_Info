package fr.ensma.a3.ia.exemple2;

public class TH2 implements Runnable{
    private TabNoir tab;
    private Thread cop1;

    public TH2(TabNoir t, Thread c1) {
        tab = t;
        cop1=c1;
    }

    @Override
    public void run(){
        int val = tab.consomme();
        val*=10;
        System.out.println("Th2 calcule " + val);
        if(val> 40){
            System.out.println("Interruption");
            cop1.interrupt();
            return;
        }

    }
}
