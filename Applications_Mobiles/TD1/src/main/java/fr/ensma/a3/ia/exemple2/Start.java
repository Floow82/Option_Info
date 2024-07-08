package fr.ensma.a3.ia.exemple2;

public class Start {
    public static void main (String[] args) {
        TabNoir tab = new TabNoir(1);
        for(int i =1; i<=5; i++){
            TH1 T1 = new TH1(i, tab);
            Thread t1 = new Thread(T1);
            TH2 T2 = new TH2(tab, t1);
            Thread t2 = new Thread(T2);
            t1.start();
            t2.start();
        }
    }

}
