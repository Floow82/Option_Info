package fr.ensma.a3.ia.element.comportement.etats;

public abstract class AbstractEtat implements IEtat{
    protected IAutomate autom;
    public AbstractEtat(final IAutomate auto){
        autom = auto;
    }

    @Override
    public void seDeplacer() throws TransitionException{
        throw new TransitionException();
    }
    @Override
    public void arret() throws TransitionException{
        throw new TransitionException();
    }
    @Override
    public void attaquer() throws TransitionException{
        throw new TransitionException();
    }
    @Override
    public void subirAttaque() throws TransitionException{
        throw new TransitionException();
    }
    @Override
    public void finAttaque() throws TransitionException{
        throw new TransitionException();
    }
}
