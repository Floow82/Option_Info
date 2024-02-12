package fr.ensma.a3.ia.element.comportement.etats;

public interface IAutomate {

    public IEtat getAurepos();
    public IEtat getEnDeplacement();
    public void setEtatCourant(final IEtat etat);
}
