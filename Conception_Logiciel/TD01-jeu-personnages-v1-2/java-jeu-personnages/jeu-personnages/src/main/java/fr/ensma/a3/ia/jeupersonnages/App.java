package fr.ensma.a3.ia.jeupersonnages;

import fr.ensma.a3.ia.jeupersonnages.elements.personnages.animaux.Dragon;
import fr.ensma.a3.ia.jeupersonnages.elements.personnages.humains.Guerrier;
import fr.ensma.a3.ia.jeupersonnages.elements.personnages.humains.Ouvrier;
import fr.ensma.a3.ia.jeupersonnages.map.Base;
import fr.ensma.a3.ia.jeupersonnages.map.ECouleur;
import fr.ensma.a3.ia.jeupersonnages.outils.MortPersonnageException;
import fr.ensma.a3.ia.jeupersonnages.outils.ValParamException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Le jeu des personnages !!");
        try {
            Base winterfell = new Base("Winterfell", ECouleur.bleu);
            Ouvrier hodor = new Ouvrier(255.0f, winterfell, 2500, "Hodor");
            Guerrier jSnow = new Guerrier(150.0f, winterfell, 450, "John Snow");
            System.out.println(winterfell.afficheElements());
            Base castralRoc = new Base("Castral Roc", ECouleur.rouge);
            Guerrier joffrey = new Guerrier(75.0f, castralRoc, 200, "Joffrey");
            System.out.println(castralRoc.afficheElements());
            Base peyredragon = new Base("Peyredragon", ECouleur.noir);
            Dragon viserion = new Dragon(2000.0f, peyredragon, "Viserion", 3000);
            Dragon drogon = new Dragon(3500.0f, peyredragon, "Drogon", 3500);
            System.out.println(peyredragon.afficheElements());
            // déplacement
            hodor.deplacer();
            jSnow.deplacer();
            joffrey.deplacer();
            viserion.deplacer();
            drogon.deplacer();
            // Attaque
            try {
                jSnow.aLAttaque(joffrey);
                joffrey.aLAttaque(hodor);

                // joffrey.aLAttaque(viserion);
                viserion.aLAttaque(joffrey);
                drogon.aLAttaque(viserion);
            } catch (MortPersonnageException ex) {
                if (ex.getElem() == joffrey) {
                    joffrey = null;
                }
            }
            joffrey.deplacer();

        } catch (final ValParamException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
