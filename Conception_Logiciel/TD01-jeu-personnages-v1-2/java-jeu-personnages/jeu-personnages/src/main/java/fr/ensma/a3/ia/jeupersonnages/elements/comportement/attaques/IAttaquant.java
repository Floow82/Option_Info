package fr.ensma.a3.ia.jeupersonnages.elements.comportement.attaques;

import fr.ensma.a3.ia.jeupersonnages.outils.MortPersonnageException;

/**
 * Peut attaquer tout ...
 */
public interface IAttaquant {

    public void aLAttaque(final IAttaquable cible)
        throws MortPersonnageException;
}
