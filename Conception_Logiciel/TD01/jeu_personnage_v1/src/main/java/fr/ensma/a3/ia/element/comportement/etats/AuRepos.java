package fr.ensma.a3.ia.element.comportement.etats;

public class AuRepos extends AbstractEtat {

    public AuRepos(IAutomate auto) {
        super(auto);
    }
    @Override
    public void seDeplacer() throws TransitionException {
        autom.setEtatCourant(autom.getEnDeplacement());
    }
}
