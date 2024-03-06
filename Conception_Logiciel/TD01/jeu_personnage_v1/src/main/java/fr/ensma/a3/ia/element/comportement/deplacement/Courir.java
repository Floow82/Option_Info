package fr.ensma.a3.ia.element.comportement.deplacement;

import fr.ensma.a3.ia.element.ElementJeu;
import fr.ensma.a3.ia.element.personnages.PersonnageVivant;
import fr.ensma.a3.ia.utils.ValParamException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Courir implements IDeplacement {

    @Override
    public void seDeplacer(final ElementJeu elm) throws ValParamException {
        if (elm == null) {
            throw new ValParamException("Param Elem null");
        }
        if (elm instanceof PersonnageVivant) {
            logger.info(((PersonnageVivant) elm).getIdentifiantPerson() + " dit : \"je me déplace 2 x plus vite en courrant !!!\"");
        } else {
            logger.info("\n Je me déplace en courrant \n");
        }
    }
    private static Logger logger = LogManager.getLogger(Courir.class);

}
