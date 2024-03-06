package fr.ensma.a3.ia.jeupersonnages.elements.comportement.attaques;

import fr.ensma.a3.ia.jeupersonnages.outils.MortPersonnageException;

/**
 * Peut-être attaqué de toute part...
 */
public interface IAttaquable {

    void estAttaque(final Integer puissance)
    throws MortPersonnageException;

    String getIdentPerso();
}
