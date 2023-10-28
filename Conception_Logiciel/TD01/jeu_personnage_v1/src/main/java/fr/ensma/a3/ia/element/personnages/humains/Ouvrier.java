package fr.ensma.a3.ia.element.personnages.humains;

import fr.ensma.a3.ia.map.Base;
import fr.ensma.a3.ia.utils.ValParamException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Ouvrier extends PersonnageHumain {
    protected Integer PuissTrav;
    protected static int NumInstance;

    /**
     * Instancie un ouvrier
     * @param niv Float (non null)
     * @param bse Base (non null)
     * @param identif String (non null)
     * @param ptrav Integer (non null)
     * @throws ValParamException (verification param non null)
     */
    public Ouvrier (final Float niv, final Base bse, final String identif, final Integer ptrav) throws ValParamException
    {
        super (niv, bse, identif);
        _init(ptrav);
        NumInstance++;
    }

    /**
     * Instancie un nouvel ouvrier (version pour le cahier des charges)
     * @param niv Float (non null)
     * @param bse Base (non null)
     * @param ptrav Integer (non null)
     * @throws ValParamException (verif param non null)
     */
    public Ouvrier (final Float niv, final Base bse, final Integer ptrav) throws ValParamException
    {
        super (niv, bse, "Ouvrier" + NumInstance++);
        _init(ptrav);
    }


    private void _init(final Integer ptrav) throws ValParamException
    {
        if (ptrav == null){
            throw new ValParamException();
        }
        PuissTrav = ptrav;
    }
    @Override
    public void estAttaque (final Integer NivPuis)
    {
        nivVie = nivVie - NivPuis/15.0f;
        logger.info(IdentifiantPerson + " dit : Aiieee !!--> " + nivVie);

    }

    private String toSring(){
        return "Ouvrier" + IdentifiantPerson + "-NiveauVie" + nivVie + "-Puissance de travail" + PuissTrav;
    }

    private final Logger logger = LogManager.getLogger(Ouvrier.class);

}

