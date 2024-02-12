package fr.ensma.a3.ia.jeupersonnages.elements.personnages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ensma.a3.ia.jeupersonnages.elements.ElementJeu;
import fr.ensma.a3.ia.jeupersonnages.elements.comportement.IDeplacable;
import fr.ensma.a3.ia.jeupersonnages.map.Base;
import fr.ensma.a3.ia.jeupersonnages.outils.ValParamException;

/**
 * Modélise un personnage vivant.
 *
 * @author M.Richard
 * @since 1.0
 * @version 1.0
 * @see IDeplacable
 * @see ElementJeu
 */
public abstract class PersoVivant extends ElementJeu implements IDeplacable {

    protected String identPerso;

    /**
     * Instancie un PersoVivant.
     *
     * @param nvie  le niveau de vie
     * @param bse   la base du personnage
     * @param ident le nom du personnage
     * @throws ValParamException si nvie == null || Bse == null || ident == null
     */
    public PersoVivant(final Float nvie, final Base bse, final String ident) throws ValParamException {
        super(nvie, bse);
        if (ident == null) {
            logger.error("Paramètres null...");
            throw new ValParamException(getClass().getSimpleName() + " : Param(s) null");
        }
        identPerso = ident;
    }

    /**
     * Obtient le nom du personnage.
     *
     * @return le nom
     */
    public final String getIdentPerso() {
        return identPerso;
    }

    /**
     * Redéfinition de equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        PersoVivant other = (PersoVivant) obj;
        if (identPerso == null) {
            if (other.identPerso != null)
                return false;
        } else if (!identPerso.equals(other.identPerso))
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
        result = prime * result + ((identPerso == null) ? 0 : identPerso.hashCode());
        return result;
    }

    private static Logger logger = LogManager.getLogger(PersoVivant.class);

}
