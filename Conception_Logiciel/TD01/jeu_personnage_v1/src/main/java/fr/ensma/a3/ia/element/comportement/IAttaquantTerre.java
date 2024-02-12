package fr.ensma.a3.ia.element.comportement;
import fr.ensma.a3.ia.utils.MortPersonnageException;

/**
 * Peut attaquer des gens de la Terre
 */
public interface IAttaquantTerre {

    public void ALAttaque(final IAttaquableTerre cible)
            throws MortPersonnageException;
}
