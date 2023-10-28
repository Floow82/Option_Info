package fr.ensma.a3.ia.element.personnages;

import fr.ensma.a3.ia.element.ElementJeu;
import fr.ensma.a3.ia.map.Base;
import fr.ensma.a3.ia.utils.ValParamException;

public class PersonnageVivant extends ElementJeu {
    protected String IdentifiantPerson;

    /**
     * Instancie un personnage vivant
     * @param niv Float (non null)
     * @param bse Base (non null)
     * @param identif String (non null)
     * @throws ValParamException (si identif est nul)
     */
    public PersonnageVivant (final Float niv, final Base bse, final String identif) throws ValParamException {
        super(niv, bse);
        if ( identif == null) {
            throw new ValParamException(getClass().getSimpleName() + " : Param(s) null");
        }
        IdentifiantPerson = identif;
    }
    public final String getIdentifiantPerson() {return IdentifiantPerson;}

    @Override
    /**
     * redefinition de la methode equals
     * Compare les attributs pour déterminer si deux objets de type ElementJeu sont égaux.
     * Elle renvoie true si les attributs sont égaux et false sinon.
     */

    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (!(obj instanceof PersonnageVivant))
            return false;
        final PersonnageVivant perso = (PersonnageVivant) obj;
        if (IdentifiantPerson == null) {
            if (perso.IdentifiantPerson != null)
                return false;
        } else if (!IdentifiantPerson.equals(perso.IdentifiantPerson))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int res = super.hashCode();
        res = HASH * res + ((IdentifiantPerson == null) ? 0 : IdentifiantPerson.hashCode());
        return res;
    }

    private static final int HASH = 13;
}
