package fr.ensma.a3.ia.element.personnages.humains;

import fr.ensma.a3.ia.element.comportement.IAttaquableTerre;
import fr.ensma.a3.ia.element.comportement.IAttaque;
import fr.ensma.a3.ia.element.comportement.IAttaqueTerre;
import fr.ensma.a3.ia.element.comportement.IAttaquable;
import fr.ensma.a3.ia.map.Base;
import fr.ensma.a3.ia.utils.MortPersonnageException;
import fr.ensma.a3.ia.utils.ValParamException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Guerrier extends PersonnageHumain implements IAttaqueTerre, IAttaque {

    private Integer PuissAtt;
    private static int NumInstance;

    /**
     * Instancie un Guerrier
     * @param niv Float (non null)
     * @param bse Base (non null)
     * @param identif String (non null)
     * @param patt Integer (non null)
     * @throws ValParamException (verif non null)
     */
    public Guerrier(final Float niv, final Base bse, final Integer patt, final String identif) throws ValParamException {
        super(niv, bse, identif);
        _init(patt);
        NumInstance ++;
    }

    /**
     * Instancie un nouveau Guerrier
     * @param niv Float (non null)
     * @param bse Base (non null)
     * @param patt Integer (non null)
     * @throws ValParamException (verif non null)
     */
    public Guerrier(final Float niv, final Base bse, final Integer patt) throws ValParamException
    {
        super(niv, bse, "Gerrier" + NumInstance++);
        _init(patt);
    }
    public final Integer getPuissAttaque() {
        return PuissAtt;
    }

    @Override
    public void estAttaque (final Integer NivPuis)
    {
        nivVie = nivVie - NivPuis/20.0f;
        logger.info (IdentifiantPerson + "dit : Aiiiiie!! --->" + nivVie);
    }
    //@Override
    //public void ALAttaque (IAttaquableTerre cible) throws MortPersonnageException {
    //    logger.info(IdentifiantPerson + "dit : Aaaaaa l'attaque!" + cible.getIdentifiantPerson() + "j'arrive!" );
    //    cible.estAttaque(PuissAtt);
    //}
    @Override
    public void ALAttaque (IAttaquable cible) throws MortPersonnageException {
        logger.info(IdentifiantPerson + "dit : Aaaaaa l'attaque!" + cible.getIdentifiantPerson() + "j'arrive!" );
        cible.estAttaque(PuissAtt);
    }

    @Override
    public String toString (){
        return "Guerrier : " + IdentifiantPerson + " - NiveauVie : " + nivVie + " - Puissance Attaque :" + PuissAtt;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Guerrier other = (Guerrier) obj;
        if (PuissAtt == null) {
            if (other.PuissAtt != null)
                return false;
        } else if (!PuissAtt.equals(other.PuissAtt))
            return false;
        return true;
    }

    private void _init(final Integer patt) throws ValParamException {
        if (patt== null) {
            throw new ValParamException();
        }
        PuissAtt = patt;
    }

    private static Logger logger = LogManager.getLogger(Guerrier.class);
}

