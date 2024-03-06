package fr.ensma.a3.ia.jeupersonnages.elements.personnages.animaux;

import fr.ensma.a3.ia.jeupersonnages.elements.personnages.PersoVivant;
import fr.ensma.a3.ia.jeupersonnages.map.Base;
import fr.ensma.a3.ia.jeupersonnages.outils.ValParamException;

/**
 * Modélise un PersoAnimal
 *
 * @author M.Richard
 * @since 1.0
 * @version 1.0
 * @see PersoVivant
 */
public abstract class PersoAnimal extends PersoVivant {

    /**
     * Instancie un PersoAnimal
     *
     * @param nvie  le niveau de vie du PersoAnimal
     * @param bse   la base de rattachement du PersoAnimal
     * @param ident le nom du PersoAnimal
     * @throws ValParamException si nvie == null || bse == null || ident == null
     */
    public PersoAnimal(Float nvie, Base bse, String ident) throws ValParamException {
        super(nvie, bse, ident);
    }

}
