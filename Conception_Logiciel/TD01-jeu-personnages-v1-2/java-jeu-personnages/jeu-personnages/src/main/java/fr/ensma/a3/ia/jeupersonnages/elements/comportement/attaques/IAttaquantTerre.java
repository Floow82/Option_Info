package fr.ensma.a3.ia.jeupersonnages.elements.comportement.attaques;

import fr.ensma.a3.ia.jeupersonnages.outils.MortPersonnageException;

/**
 * Peut attaquer des gens de la Terre
 */
public interface IAttaquantTerre {

    public void aLAttaque(final IAttaquableTerre cible)
        throws MortPersonnageException;
}
