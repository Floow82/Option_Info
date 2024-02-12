package fr.ensma.a3.ia.jeupersonnages.elements.personnages.humains;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ensma.a3.ia.jeupersonnages.elements.comportement.attaques.IAttaquable;
import fr.ensma.a3.ia.jeupersonnages.elements.comportement.attaques.IAttaquableTerre;
import fr.ensma.a3.ia.jeupersonnages.map.Base;
import fr.ensma.a3.ia.jeupersonnages.outils.MortPersonnageException;
import fr.ensma.a3.ia.jeupersonnages.outils.ValParamException;

/**
 * Modélisation d'un Ouvrier
 *
 * @author M.Richard
 * @since 1.0
 * @version 1.0
 * @see PersoHumain
 */
public class Ouvrier extends PersoHumain implements IAttaquable, IAttaquableTerre{

    private Integer puissTravail;
    private static int numInstance;

    /**
     * Instancie un Ouvrier
     *
     * @param nvie  le niveau de vie de l'ouvrier
     * @param bse   la base de rattachement de l'ouvrier
     * @param ptrv  la puissance de travail de l'ouvrier
     * @param ident le nom de l'ouvrier
     * @throws ValParamException si nvie == null || bse == null || ptrv == null ||
     *                           ident == null
     */
    public Ouvrier(final Float nvie, final Base bse, final Integer ptrv, final String ident) throws ValParamException {
        super(nvie, bse, ident);
        _init(ptrv);
        numInstance++;
    }

    /**
     * Instancie un Ouvrier
     *
     * @param nvie le niveau de vie de l'ouvrier
     * @param bse  la base de rattachement de l'ouvrier
     * @param ptrv la puissance de travail de l'ouvrier
     * @throws ValParamException si nvie == null || bse == null || ptrv == null
     */
    public Ouvrier(final Float nvie, final Base bse, final Integer ptrv) throws ValParamException {
        super(nvie, bse, ("Ouvrier" + ++numInstance));
        _init(ptrv);
    }

    /**
     * Obtient la puissance de travail
     *
     * @return la puissance de travail de l'ouvrier
     */
    public final Integer getPuissTravail() {
        return puissTravail;
    }

    @Override
    public void estAttaque(final Integer puissance) throws MortPersonnageException{
        nivVie = nivVie - puissance / 15.0f;
        logger.info(identPerso + " dit : Aiieee !! petit poltron, je n'ai même pas d'arme !!!! --> " + nivVie);
    }

    /**
     * Redéfinition de toString.
     */
    @Override
    public String toString() {
        return "Ouvrier : " + identPerso + " - Niv Vie : " + nivVie + " - P Travail : " + puissTravail
                + super.toString();
    }

    /**
     * Redéfinition de equals.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ouvrier other = (Ouvrier) obj;
        if (puissTravail == null) {
            if (other.puissTravail != null)
                return false;
        } else if (!puissTravail.equals(other.puissTravail))
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
        result = prime * result + ((puissTravail == null) ? 0 : puissTravail.hashCode());
        return result;
    }

    private void _init(final Integer ptrv) throws ValParamException {
        if (ptrv == null) {
            logger.error("Paramètres null...");
            throw new ValParamException();
        }
        puissTravail = ptrv;
    }

    private final Logger logger = LogManager.getLogger(Ouvrier.class);

}
