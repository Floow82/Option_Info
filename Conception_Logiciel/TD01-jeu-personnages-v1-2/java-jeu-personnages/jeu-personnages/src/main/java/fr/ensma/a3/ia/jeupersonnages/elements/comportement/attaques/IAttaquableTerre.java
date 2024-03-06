package fr.ensma.a3.ia.jeupersonnages.elements.comportement.attaques;

import fr.ensma.a3.ia.jeupersonnages.outils.MortPersonnageException;

/**
 * Peut être attaqué uniquement depuis la terre...
 */
public interface IAttaquableTerre {

    public void estAttaque(final Integer puissance)
        throws MortPersonnageException;

    public String getIdentPerso();
}
