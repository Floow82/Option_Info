package fr.ensma.a3.ia.element.comportement;
import fr.ensma.a3.ia.utils.MortPersonnageException;

/**
 * Peut être attaqué uniquement depuis la terre...
 */
public interface IAttaquableTerre {

    public void estAttaque(final Integer puissance)
            throws MortPersonnageException;

    public String getIdentifiantPerson();
}
