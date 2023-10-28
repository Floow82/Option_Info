package fr.ensma.a3.ia.element;

import fr.ensma.a3.ia.map.Base;
import java.util.Objects;
import fr.ensma.a3.ia.utils.ValParamException;
/**
 * Modelisation d'un élément du jeu
 * @author florineteulieres
 */
public abstract class ElementJeu implements IElementJeu{
    /**
     * Représente le niveau d'un élément du jeu, accessible dans toutes les sous-classses de ElementJeu
     */
    protected Float nivVie;
    /**
     * Cet attribut représente la base à laquelle l'élément de jeu est rattaché.
     * accessible qu'à l'intérieur de cette classe.
     */
    private Base laBase;

    /**
     * Constructeur qui initialise niv et bse.
     * Il verifie s'il ne sont pas nul, et renvoie une exception dans ce cas.
     * @param niv Float (niveau de vie, non null)
     * @param bse Base (non null)
     * @throws ValParamException (pour verifier niv et bse non nul)
     */
    public ElementJeu (final Float niv, final Base bse) throws ValParamException
    {
        try {
            nivVie = Objects.requireNonNull(niv);
            laBase = Objects.requireNonNull(bse);
            laBase.addElementJeu(this);
        } catch (final Throwable e) {
            throw new ValParamException(getClass().getSimpleName() + " : Param(s) null");
        }
    }

    /**
     * le final implique que la fonction ne peux pas etre modifiee
     * on peux juste la override.
     * @return
     */
    public final Base getLaBase() {
        return laBase;
    }
    public final Float getNivVie() {
        return nivVie;
    }

    @Override
    /**
     * Compare les attributs pour déterminer si deux objets de type ElementJeu sont égaux.
     * Elle renvoie true si les attributs sont égaux et false sinon.
     */
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof ElementJeu))
            return false;
        final ElementJeu elem = (ElementJeu) obj;
        if (laBase == null) {
            if (elem.laBase != null)
                return false;
        } else if (!laBase.equals(elem.laBase))
            return false;
        if (nivVie == null) {
            if (elem.nivVie != null)
                return false;
        } else if (!nivVie.equals(elem.nivVie))
            return false;
        return true;
    }

    @Override
    /**
     * calcule un code de hachage basé sur les attributs de l'élément de jeu.
     * Utilisé pour identifier l'objet de manière unique dans des structures de données.
     */
    public int hashCode() {
        int res = 1;
        res = HASH * res + ((laBase == null) ? 0 : laBase.hashCode());
        res = HASH * res + ((nivVie == null) ? 0 : nivVie.hashCode());
        return res;
    }

    private static final int HASH = 23;

}