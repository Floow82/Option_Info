package fr.ensma.a3.ia.jeupersonnages.outils;

import fr.ensma.a3.ia.jeupersonnages.elements.comportement.attaques.IAttaquable;

public class MortPersonnageException extends Exception {

    private IAttaquable elem;

    public MortPersonnageException(IAttaquable pers) {
        elem = pers;
    }

    public IAttaquable getElem() {
        return elem;
    }

}
