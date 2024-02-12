package fr.ensma.a3.ia.exo1_1;

public class StartExo1_1 {

    public static void main(String[] args) {
        //Module de donnée
        IMdd mdd = new Mdd();
        //Création Thread
        ThreadEcrivain th1 = new ThreadEcrivain(1700, 30, "TH1-Ecrire", mdd);
        ThreadLecture th2 = new ThreadLecture(300, 20, "TH2-Lire", mdd);
        // Lancement Thread
        th1.start();
        th2.start();
        // Attente terinaison
        try {
            th2.join(10000);
            th1.join(20000);
            System.out.println("===========Prog FINI============");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
