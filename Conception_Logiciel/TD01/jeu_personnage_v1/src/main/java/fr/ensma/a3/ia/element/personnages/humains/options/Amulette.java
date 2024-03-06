package fr.ensma.a3.ia.element.personnages.humains.options;

import fr.ensma.a3.ia.element.comportement.IAttaquable;
import fr.ensma.a3.ia.element.personnages.humains.Guerrier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Amulette extends AbstractOption{
    public Amulette (final IGuerrier base) {
        super(base);
    }
    @Override
    public void ALAttaque (final IAttaquable cible) {
        super.ALAttaque(cible);
        cible.estattaque(puissace*2);
    }
    private final Logger logger = LogManager.getLogger(Guerrier.Casque.class);
}

