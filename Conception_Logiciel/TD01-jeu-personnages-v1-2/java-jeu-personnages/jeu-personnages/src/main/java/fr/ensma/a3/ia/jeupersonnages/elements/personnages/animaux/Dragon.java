package fr.ensma.a3.ia.jeupersonnages.elements.personnages.animaux;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ensma.a3.ia.jeupersonnages.elements.comportement.IDeplacable;
import fr.ensma.a3.ia.jeupersonnages.elements.comportement.attaques.IAttaquable;
import fr.ensma.a3.ia.jeupersonnages.elements.comportement.attaques.IAttaque;
import fr.ensma.a3.ia.jeupersonnages.map.Base;
import fr.ensma.a3.ia.jeupersonnages.outils.MortPersonnageException;
import fr.ensma.a3.ia.jeupersonnages.outils.ValParamException;

/**
 * Modélise un Dragon
 *
 * @author M.Richard
 * @since 1.0
 * @version 1.0
 * @see PersoAnimal
 */
public class Dragon extends PersoAnimal implements IAttaque {

    private Integer puissAtt;
    private static int numInstance;

    public Dragon(final Float nvie, final Base bse, final String ident, final Integer patt) throws ValParamException {
        super(nvie, bse, ident);
        _init(patt);
        numInstance++;
    }

    public Dragon(final Float nvie, final Base bse, final Integer patt) throws ValParamException {
        super(nvie, bse, "Dragon" + ++numInstance);
        _init(patt);
    }

    /**
     * Obtient la puissance d'attaque
     *
     * @return la puissance d'attaque du dragon
     */
    public final Integer getPuissAttaque() {
        return puissAtt;
    }

    /**
     * Redéfinition de toString
     */
    @Override
    public String toString() {
        return "Guerrier : " + identPerso + " - Niv. Vie : " + nivVie + " - P Att : " + puissAtt
                + super.toString();
    }

    /**
     * Redéfinition de déplacer
     *
     * @see IDeplacable
     */
    @Override
    public void deplacer() {
        logger.info(identPerso + " dit : je me déplace en volant");
    }

    @Override
    public void aLAttaque(final IAttaquable cible) throws MortPersonnageException{
        logger.info(identPerso + " dit : raaahhhh !! " + cible.getIdentPerso() + " je vais te réduire en cendres !!!");
        cible.estAttaque(puissAtt);
    }

    // @Override
    // public void aLAttaque(IAttaquableTerre cible) {
    //     logger.info(identPerso + " dit : raaahhhh !! " + cible.getIdentPerso() + " je vais te réduire en cendres !!!");
    //     cible.estAttaque(puissAtt);
    // }

    @Override
    public void estAttaque(final Integer puissance) {
        nivVie = nivVie - puissance / 50.0f;
        logger.info(identPerso + " dit : hmmm ... qui me chatouille ... ?? --> " + nivVie);
    }

    /**
     * Redéfinition de equals
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dragon other = (Dragon) obj;
        if (puissAtt == null) {
            if (other.puissAtt != null)
                return false;
        } else if (!puissAtt.equals(other.puissAtt))
            return false;
        return true;
    }

    /**
     * Redéfinition de hashCode pour conformité à equals
     *
     * @see equals
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((puissAtt == null) ? 0 : puissAtt.hashCode());
        return result;
    }

    private void _init(final Integer patt) throws ValParamException {
        if (patt == null) {
            logger.error("Paramètres null...");
            throw new ValParamException(getClass().getName() + " : Param(s) null");
        }
        puissAtt = patt;
    }

    private static Logger logger = LogManager.getLogger(Dragon.class);

}
