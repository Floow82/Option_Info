package fr.ensma.a3.ia.element.comportement.deplacement;

import fr.ensma.a3.ia.element.ElementJeu;
import fr.ensma.a3.ia.utils.ValParamException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Immobile implements IDeplacement {
    @Override
    public void seDeplacer(ElementJeu elm) throws ValParamException {
        if (elm == null){
            throw new ValParamException("Param nuls ...");
        }
        logger.warn("Jsuis complètement immobile, c'est nul de fou là!!");
    }
    private static Logger logger = LogManager.getLogger(Immobile.class);
}
