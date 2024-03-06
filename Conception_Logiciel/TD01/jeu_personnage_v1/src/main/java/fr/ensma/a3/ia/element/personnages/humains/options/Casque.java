package fr.ensma.a3.ia.element.personnages.humains.options;

import fr.ensma.a3.ia.element.personnages.humains.Guerrier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Casque extends AbstractOption {
    public Casque (final IGuerrier base) {
        super(base);
    }
    @Override
    public void estAttaque (Integer puissance) {
        super.estAttaque(puissance / 2);
    }
    private final Logger logger = LogManager.getLogger(Guerrier.Casque.class);
}
