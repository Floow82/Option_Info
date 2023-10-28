package fr.ensma.a3.ia.element.personnages.animaux;

import fr.ensma.a3.ia.element.personnages.PersonnageVivant;
import fr.ensma.a3.ia.map.Base;
import fr.ensma.a3.ia.utils.ValParamException;

public class PersonnageAnimal extends PersonnageVivant {
    public PersonnageAnimal (final Float niv, final Base bse, final String identif) throws ValParamException {
        super (niv, bse, identif);
    }
}
