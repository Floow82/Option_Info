package fr.ensma.a3.ia.element.personnages.humains;

import fr.ensma.a3.ia.element.comportement.IAttaquableTerre;
import fr.ensma.a3.ia.map.Base;
import fr.ensma.a3.ia.utils.ValParamException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Ouvrier extends PersonnageHumain implements IAttaquableTerre {
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
        super(niv, bse, identif);
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
        super(niv, bse, "Ouvrier" + NumInstance++);
        _init(ptrav);
    }


    private void _init(final Integer ptrav) throws ValParamException
    {
        if (ptrav == null){
            throw new ValParamException();
        }
        PuissTrav = ptrav;
    }

    public final Integer getPuissTrav() {
        return PuissTrav;
    }
    @Override
    public void estAttaque (final Integer NivPuis)
    {
        nivVie = nivVie - NivPuis/15.0f;
        logger.info(IdentifiantPerson + " dit : Aiieee !!--> " + nivVie);

    }

    @Override
    public String toString (){
        return "Ouvrier : " + IdentifiantPerson + " - NiveauVie : " + nivVie + " - Puissance Attaque : " + PuissTrav;
    }
    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (!(obj instanceof Ouvrier))
            return false;
        final Ouvrier ouv = (Ouvrier) obj;
        if (PuissTrav == null) {
            if (ouv.PuissTrav != null)
                return false;
        } else if (!PuissTrav.equals(ouv.PuissTrav))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = HASH * result + ((PuissTrav == null) ? 0 : PuissTrav.hashCode());
        return result;
    }

    private final Logger logger = LogManager.getLogger(Guerrier.class);
    private static final int HASH = 11;
}

