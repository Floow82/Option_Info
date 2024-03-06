package fr.ensma.a3.ia.element.comportement.deplacement;

import fr.ensma.a3.ia.element.ElementJeu;
import fr.ensma.a3.ia.utils.ValParamException;

public interface IDeplacement {
    public void seDeplacer(final ElementJeu elem) throws ValParamException;
}
