package fr.ensma.a3.ia.exemple2;

import java.util.LinkedList;
import java.util.List;

public class TabNoir {
    private int tailleMax;
    private List<Integer> zone;

    public TabNoir (int taille) {
        tailleMax=taille;
        zone = new LinkedList<Integer>();
    }

    public synchronized void depose(int data){
        while(zone.size()==tailleMax) {
            try{wait();}
            catch (InterruptedException e) {}
        }
        zone.add(data);
        System.out.println("Ajout de data " + data);
        notifyAll();
    }

    public synchronized int consomme(){
        while(zone.size()==0) {
            try{wait();}
            catch (InterruptedException e) {}
        }
        int data = zone.remove(zone.size()-1);
        System.out.println("TH2 consomme " + data);
        notifyAll();
        return data;
    }
}
