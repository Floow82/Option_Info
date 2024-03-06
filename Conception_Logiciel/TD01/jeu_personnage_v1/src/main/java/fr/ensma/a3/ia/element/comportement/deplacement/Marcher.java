package fr.ensma.a3.ia.element.comportement.deplacement;

import fr.ensma.a3.ia.element.ElementJeu;
import fr.ensma.a3.ia.element.personnages.PersonnageVivant;
import fr.ensma.a3.ia.utils.ValParamException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Marcher implements IDeplacement {

    @Override
    public void seDeplacer (final ElementJeu elm) throws ValParamException {
        if (elm == null) {
            throw new ValParamException("Param Elem null");
        }
        if (elm instanceof PersonnageVivant) {
            logger.info(((PersonnageVivant) elm).getIdentifiantPerson() + "dit : Je me déplace en marchant! \n");
        } else {
            logger.info("\n Je me déplace en marchant \n");
        }
    }

    private static Logger logger = LogManager.getLogger(Marcher.class);
}
