package fr.ensma.a3.ia.element.comportement.etats;

public interface IEtat {
    public void seDeplacer() throws TransitionException;
    public void arret() throws TransitionException;
    public void attaquer() throws TransitionException;
    public void subirAttaque() throws TransitionException;
    public void finAttaque() throws TransitionException;
}
