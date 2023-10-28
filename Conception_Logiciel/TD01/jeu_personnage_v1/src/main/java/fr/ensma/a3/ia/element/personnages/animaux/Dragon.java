package fr.ensma.a3.ia.element.personnages.animaux;

import fr.ensma.a3.ia.element.comportement.IAttaquable;
import fr.ensma.a3.ia.element.comportement.IAttaque;
import fr.ensma.a3.ia.element.comportement.IDeplacable;
import fr.ensma.a3.ia.map.Base;
import fr.ensma.a3.ia.utils.ValParamException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Dragon extends PersonnageAnimal implements IAttaque, IDeplacable {
    private Integer PuissAtt;
    private static int NumInstance;

    /**
     * Instanciation du dragon
     * @param niv Float
     * @param bse Base
     * @param identif String
     * @param patt Integer
     * @throws ValParamException (verif non null)
     */
    public Dragon(final Float niv, final Base bse, final String identif, final Integer patt) throws ValParamException {
        super(niv, bse, identif);
        _init(patt);
        NumInstance++;
    }

    /**
     * Instanciation du dragon avec decla de l'identifiant
     * @param niv Float
     * @param bse Base
     * @param patt String
     * @throws ValParamException (verif non null)
     */
    public Dragon(final Float niv, final Base bse, final Integer patt) throws ValParamException {
        super(niv, bse, "Dragon" + NumInstance++);
        _init(patt);
    }
    @Override
    public String toString() {
        return "Dragon : " + IdentifiantPerson + " - Niv. Vie : " + nivVie + " - P Att : " + PuissAtt;
    }

    @Override
    public void seDeplacer() {
        logger.info(IdentifiantPerson + " dit : je me déplace en volant");
    }

    @Override
    public void ALAttaque(final IAttaquable cible) {
        logger.info(IdentifiantPerson + " dit : raaahhhh !! " + cible.getIdentifiantPerson() + " je vais te réduire en cendres !!!");
        cible.estAttaque(PuissAtt);
    }

    @Override
    public void estAttaque(final Integer NivPuis) {
        nivVie = nivVie - NivPuis / 50.0f;
        logger.info(IdentifiantPerson + " dit : hmmm ... qui me chatouille ... ?? --> " + nivVie);
    }

    private void _init(final Integer patt) throws ValParamException{
        if (patt == null) {
            throw new ValParamException(getClass().getName() + " : Param(s) null");
        }
        PuissAtt = patt;
    }

    private static Logger logger = LogManager.getLogger(Dragon.class);

}