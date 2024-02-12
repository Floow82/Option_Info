package fr.ensma.a3.ia.element.personnages.humains.options;

import fr.ensma.a3.ia.element.comportement.IAttaquable;
import fr.ensma.a3.ia.element.comportement.IAttaqueTerre;
import fr.ensma.a3.ia.utils.MortPersonnageException;

public abstract class AbstractOption implements IGuerrier{
    protected IGuerrier base;
    public AbstractOption (final IGuerrier bse) {
        base = bse;
    }

    @Override
    public void estAttaque (Integer puissance) throws MortPersonnageException {
        base.estAttaque(puissance);
    }
    @Override
    public void ALAttaque (final IAttaqueTerre cible){
        base.ALAttaque(cible);
    }
    @Override
    public void ALAttaque(final IAttaquable cible){
        base.ALAttaque(cible);
    }
    @Override
    public void seDeplacer(){
        base.seDeplacer();
    }
}
