package fr.ensma.a3.ia.element.comportement.deplacement;

import fr.ensma.a3.ia.element.ElementJeu;
import fr.ensma.a3.ia.element.personnages.PersonnageVivant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Flotter implements IDeplacement {

    @Override
    public void seDeplacer(final ElementJeu elm) {
        if (elm instanceof PersonnageVivant)
            logger.info(((PersonnageVivant)elm).getIdentifiantPerson() + " dit : Ouuuuuhuuuu je flotte, enorme!!");
    }

    private static Logger logger = LogManager.getLogger(Courir.class);

}
