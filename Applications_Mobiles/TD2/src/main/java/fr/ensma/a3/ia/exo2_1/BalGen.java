package fr.ensma.a3.ia.exo2_1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BalGen <Mess extends IBalMessages> implements IBal<Mess> {

    private int nbPlaceMax;
    private Lock verrou;
    private Condition attPlace, attMess;
    private List<Mess> filAtt;

    public BalGen(final int taille) {
        verrou = new ReentrantLock();
        attMess = verrou.newCondition();
        attPlace = verrou.newCondition();
        filAtt = new ArrayList<Mess>();
        nbPlaceMax = taille;
    }

    public void sendMEssage(final Mess m) {
        verrou.lock();
        while (filAtt.size() == nbPlaceMax) {
            try {
                attPlace.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        filAtt.add(m);
        System.out.println("Message ajouté ...");
        attMess.signalAll();
        verrou.unlock();
    }

    public Mess receptionMessage() {
        verrou.lock();
        while (filAtt.size() == 0) {
            try {
                attMess.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Mess m = filAtt.remove(filAtt.size() - 1);
        attPlace.signalAll();
        verrou.unlock();
        return m;
    }

}
