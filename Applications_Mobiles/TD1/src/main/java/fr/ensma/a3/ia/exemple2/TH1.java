package fr.ensma.a3.ia.exemple2;

public class TH1 implements Runnable{
    private TabNoir tab;
    private int ite;

    public TH1(int n, TabNoir t) {
        tab = t;
        ite = n;
    }

    @Override
    public void run(){
        tab.depose(ite);
    }
}
