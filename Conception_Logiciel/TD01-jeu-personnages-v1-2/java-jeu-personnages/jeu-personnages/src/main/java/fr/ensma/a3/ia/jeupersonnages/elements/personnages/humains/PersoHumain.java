package fr.ensma.a3.ia.jeupersonnages.elements.personnages.humains;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ensma.a3.ia.jeupersonnages.elements.comportement.IDeplacable;
import fr.ensma.a3.ia.jeupersonnages.elements.personnages.PersoVivant;
import fr.ensma.a3.ia.jeupersonnages.map.Base;
import fr.ensma.a3.ia.jeupersonnages.outils.ValParamException;

/**
 * Modélise un personnage humain.
 *
 * @author M.Richard
 * @since 1.0
 * @version 1.0
 * @see PersoVivant
 */
public abstract class PersoHumain extends PersoVivant {

    /**
     * Instancie un PersoHumain.
     *
     * @param nvie  le niveau de vie du personnage humain
     * @param bse   la base du personnage humain
     * @param ident le nom du personnage humain
     * @throws ValParamException
     */
    public PersoHumain(final Float nvie, final Base bse, final String ident) throws ValParamException {
        super(nvie, bse, ident);
    }

    /**
     * Redéfinition de deplacer.
     *
     * @see IDeplacable
     */
    @Override
    public void deplacer() {
        logger.info(identPerso + " dit : \"je me déplace en marchant\"");
    }

    private static Logger logger = LogManager.getLogger(PersoHumain.class);
}
