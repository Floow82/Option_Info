package fr.ensma.a3.ia.element.objet;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ensma.a3.ia.element.ElementJeu;
import fr.ensma.a3.ia.map.Base;
import fr.ensma.a3.ia.utils.ValParamException;

public abstract class Arme extends ElementJeu {

    private Integer puissAtt;

    public Arme(final Float nvie, final Base bse, final Integer patt) throws ValParamException {
        super(nvie,bse);
        try {
            puissAtt = Objects.requireNonNull(patt);
        } catch (NullPointerException e) {
            logger.error("Paramètres null...");
            throw new ValParamException(getClass().getSimpleName() + " : Param(s) null");
        }

    }

    public Integer getPuissAtt() {
        return puissAtt;
    }

    private Logger logger = LogManager.getLogger(Arme.class);

}
