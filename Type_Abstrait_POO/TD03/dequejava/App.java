package TD03.dequejava;

import TD03.dequejava.monpack.MaClasse;
import TD03.dequejava.monpack.MaClasse2;

/**
 * App
 */
public class App {

    public static void main(String[] args){
        System.out.println("Bonjour !!");
        MaClasse2 mcc = new MaClasse2 (2);
        MaClasse2 mcc2 = new MaClasse2(2);
        System.out.println(mcc.equals(mcc2));

        MaClasse mc = new MaClasse("Salut.");
        MaClasse mc2 = new MaClasse("Salut.");
        System.out.println(mc.getLaChaine());
        System.out.println(mc.equals(mc2));

    }
}