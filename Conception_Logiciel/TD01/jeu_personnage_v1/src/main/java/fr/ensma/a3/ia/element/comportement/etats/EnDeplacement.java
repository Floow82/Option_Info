package fr.ensma.a3.ia.element.comportement.etats;

public class EnDeplacement extends AbstractEtat{
    public EnDeplacement(final IAutomate auto) {
        super(auto);
    }

    @Override
    public void arret() throws TransitionException {
        autom.setEtatCourant(autom.getAurepos());
    }
}
