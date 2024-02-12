package fr.ensma.a3.ia.element.personnages.humains;

import fr.ensma.a3.ia.element.comportement.deplacement.Marcher;
import fr.ensma.a3.ia.element.comportement.IAttaquable;
import fr.ensma.a3.ia.element.personnages.PersonnageVivant;
import fr.ensma.a3.ia.map.Base;
import fr.ensma.a3.ia.utils.ValParamException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class PersonnageHumain extends PersonnageVivant implements IAttaquable {

    public PersonnageHumain (final Float niv, final Base bse, final String identif) throws ValParamException
    {
        super (niv, bse, identif);
        compDep = new Marcher();
    }

    //@Override
    //public void seDeplacer() {
    //    logger.info(IdentifiantPerson + " dit : \"je me déplace en marchant\"");
    //}

    private static Logger logger = LogManager.getLogger(PersonnageHumain.class);
}
