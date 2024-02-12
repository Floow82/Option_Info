package fr.ensma.a3.ia.utils;
import fr.ensma.a3.ia.element.comportement.IAttaquable;

public class MortPersonnageException extends Exception {

    private IAttaquable elem;

    public MortPersonnageException(IAttaquable pers) {
        elem = pers;
    }

    public IAttaquable getElem() {
        return elem;
    }

}