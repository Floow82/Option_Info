package fr.ensma.a3.ia;
import fr.ensma.a3.ia.element.comportement.IAttaquable;
import fr.ensma.a3.ia.element.personnages.animaux.Dragon;
import fr.ensma.a3.ia.element.personnages.humains.Guerrier;
import fr.ensma.a3.ia.element.personnages.humains.Ouvrier;
import fr.ensma.a3.ia.map.Base;
import fr.ensma.a3.ia.map.ECouleur;
import fr.ensma.a3.ia.utils.ValParamException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App
{
    private static System LogManager;
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(App.class);

    public static void main(String[] args)
    {
        try {
            Base winterfell = new Base ("Winterfell", ECouleur.bleu);
            Ouvrier hodor = new Ouvrier (255.0f, winterfell, "Hodor", 2500 );
            Guerrier jSnow = new Guerrier (150.0f, winterfell, 450, "John Snow");
            Base peyredragon = new Base("Peyredragon", ECouleur.jaune);
            Dragon crocmou = new Dragon (3500.0f, peyredragon, "Crocmou", 3500);
            System.out.println(hodor);
            System.out.println(jSnow);
            System.out.println(crocmou);
            System.out.println(winterfell);
            System.out.println(peyredragon);

            jSnow.seDeplacer();
            hodor.seDeplacer();
            crocmou.seDeplacer();

            jSnow.ALAttaque((IAttaquable) crocmou);

            System.out.println(hodor.equals(jSnow));
        } catch (ValParamException e) {
            logger.error("Erreur(s) paramètre(s)!");
        }
    }
}

