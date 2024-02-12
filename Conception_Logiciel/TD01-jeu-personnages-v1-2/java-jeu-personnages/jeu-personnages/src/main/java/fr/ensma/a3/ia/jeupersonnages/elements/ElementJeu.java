package fr.ensma.a3.ia.jeupersonnages.elements;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ensma.a3.ia.jeupersonnages.map.Base;
import fr.ensma.a3.ia.jeupersonnages.outils.ValParamException;

/**
 * Modélisation d'un élément de jeu.
 *
 * @author M. Richard
 * @since 1.0
 * @version 1.0
 * @see IElementJeu
 */
public abstract class ElementJeu implements IElementJeu {

    protected Float nivVie;
    private Base laBase;

    /**
     * Instancie un élément du jeu.
     *
     * @param niv le niveau de vie
     * @param bse la base de rattachement
     * @throws ValParamException si niv == nul || bse == null.
     */
    public ElementJeu(final Float niv, final Base bse) throws ValParamException {
        try {
            nivVie = Objects.requireNonNull(niv);
            laBase = Objects.requireNonNull(bse);
            laBase.addElementJeu(this);

        } catch (final Throwable e) {
            logger.error("Paramètres null...");
            throw new ValParamException(getClass().getSimpleName() + " : Param(s) null");
        }
    }

    /**
     * Obtient la référence de la base.
     *
     * @return la base de l'élément de jeu.
     */
    public final Base getLaBase() {
        return laBase;
    }

    /**
     * Obtient le niveau de vie.
     *
     * @return le niveau de vie de l'élément.
     */
    public final Float getNivVie() {
        return nivVie;
    }

    /**
     * Redéfinition de toString.
     */
    @Override
    public String toString() {
        return " ----> " + laBase.toString();
    }

    /**
     * Redéfinition de equals.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ElementJeu other = (ElementJeu) obj;
        if (nivVie == null) {
            if (other.nivVie != null)
                return false;
        } else if (!nivVie.equals(other.nivVie))
            return false;
        if (laBase == null) {
            if (other.laBase != null)
                return false;
        } else if (!laBase.equals(other.laBase))
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
        int result = 1;
        result = prime * result + ((nivVie == null) ? 0 : nivVie.hashCode());
        result = prime * result + ((laBase == null) ? 0 : laBase.hashCode());
        return result;
    }

    private static Logger logger = LogManager.getLogger(ElementJeu.class);
}
