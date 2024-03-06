package fr.ensma.a3.ia.jeupersonnages.elements.personnages.humains;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ensma.a3.ia.jeupersonnages.elements.comportement.attaques.IAttaquable;
import fr.ensma.a3.ia.jeupersonnages.elements.comportement.attaques.IAttaquableTerre;
import fr.ensma.a3.ia.jeupersonnages.elements.comportement.attaques.IAttaqueTerre;
import fr.ensma.a3.ia.jeupersonnages.map.Base;
import fr.ensma.a3.ia.jeupersonnages.outils.MortPersonnageException;
import fr.ensma.a3.ia.jeupersonnages.outils.ValParamException;

/**
 * Modélisation d'un Guerrier
 *
 * @author M.Richard
 * @since 1.0
 * @version 1.0
 * @see PersoHumain
 */
public class Guerrier extends PersoHumain implements IAttaqueTerre, IAttaquable {

    private Integer puissAtt;
    private static int numInstance;

    /**
     * Instancie un Guerrier
     *
     * @param nvie  le niveau de vie du guerrier
     * @param bse   la base de rattachement du guerrier
     * @param patt  la puissance d'attaque du guerrier
     * @param ident le nom du guerrier
     * @throws ValParamException
     */
    public Guerrier(final Float nvie, final Base bse, final Integer patt, final String ident) throws ValParamException {
        super(nvie, bse, ident);
        _init(patt);
        numInstance++;
    }

    /**
     * Instancie un Guerrier
     *
     * @param nvie Float (non null)
     * @param bse  {@link Base} (non null)
     * @param patt Integer (non null)
     * @throws ValParamException
     */
    public Guerrier(final Float nvie, final Base bse, final Integer patt) throws ValParamException {
        super(nvie, bse, "Guerrier" + ++numInstance);
        _init(patt);
    }

    /**
     * Obtient la puissance d'attaque
     *
     * @return la puissance d'attaque du guerrier
     */
    public final Integer getPuissAttaque() {
        return puissAtt;
    }

    @Override
    public void aLAttaque(IAttaquableTerre cible) throws MortPersonnageException {
        logger.info(identPerso + " dit : Ah, Ah !! " + cible.getIdentPerso() + " je vais te pourfendre !!!");
        cible.estAttaque(puissAtt);
    }

    @Override
    public void estAttaque(Integer puissance) throws MortPersonnageException {
        nivVie = nivVie - puissance / 20.0f;
        logger.info(identPerso + " dit : Aiieee !! ça fait mal quand même !! --> " + nivVie);
        if (nivVie <= 0f) {
            logger.warn(identPerso + " dit : Ahhh ..; je meurs .... ");
            throw new MortPersonnageException(this);
        }
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
        Guerrier other = (Guerrier) obj;
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
            throw new ValParamException();
        }
        puissAtt = patt;
    }

    private final Logger logger = LogManager.getLogger(Guerrier.class);
}
