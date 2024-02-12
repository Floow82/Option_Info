package fr.ensma.a3.ia.element.personnages;

import fr.ensma.a3.ia.element.ElementJeu;
import fr.ensma.a3.ia.element.comportement.IDeplacable;
import fr.ensma.a3.ia.element.comportement.etats.*;
import fr.ensma.a3.ia.map.Base;
import fr.ensma.a3.ia.utils.ValParamException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class PersonnageVivant extends ElementJeu implements IDeplacable, IAutomate {
    protected String IdentifiantPerson;
    private IEtat etatAuRepos;
    private IEtat etatEnDeplacement;
    private IEtat etatCourant;
    /**
     * Instancie un personnage vivant
     * @param niv Float (non null)
     * @param bse Base (non null)
     * @param identif String (non null)
     * @throws ValParamException (si identif est nul)
     */
    public PersonnageVivant (final Float niv, final Base bse, final String identif) throws ValParamException {
        super(niv, bse);
        if ( identif == null) {
            throw new ValParamException(getClass().getSimpleName() + " : Param(s) null");
        }
        IdentifiantPerson = identif;
        etatAuRepos = new AuRepos(this);
        etatEnDeplacement = new EnDeplacement(this);
        etatCourant = etatAuRepos;
    }
    public final String getIdentifiantPerson() {return IdentifiantPerson;}

    @Override
    /**
     * redefinition de la methode equals
     * Compare les attributs pour déterminer si deux objets de type ElementJeu sont égaux.
     * Elle renvoie true si les attributs sont égaux et false sinon.
     */

    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (!(obj instanceof PersonnageVivant))
            return false;
        final PersonnageVivant perso = (PersonnageVivant) obj;
        if (IdentifiantPerson == null) {
            if (perso.IdentifiantPerson != null)
                return false;
        } else if (!IdentifiantPerson.equals(perso.IdentifiantPerson))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int res = super.hashCode();
        res = HASH * res + ((IdentifiantPerson == null) ? 0 : IdentifiantPerson.hashCode());
        return res;
    }

    private static final int HASH = 13;
    private final Logger logger = LogManager.getLogger(PersonnageVivant.class);
    @Override
    public final IEtat getAurepos() {
        return etatAuRepos;
    }

    @Override
    public final IEtat getEnDeplacement() {
        return etatEnDeplacement;
    }
    @Override
    public final void setEtatCourant(final IEtat etat) {
        etatCourant = etat;
    }

    //Ajout de deplacer (depuis IDeplacable) suite à l'ajout du strategy
    @Override
    public void seDeplacer() {
        //compoDeplacement.deplacer(this);
        try {
            etatCourant.seDeplacer();
            compDep.seDeplacer(this);
        } catch (TransitionException ex) {
            logger.warn("Action demandée non réalisable !!!");
        } catch (ValParamException e) {
            throw new RuntimeException(e);
        }
    }

    //à Ajouter dans Interface Ideplacable
    public void arretDeplacement() {
        try {
            etatCourant.arret();
        } catch (TransitionException ex) {
            logger.info("Action demandée non réalisable !!!");
        }

    }
    //@Override
    //public void seDeplacer(ElementJeu elem) throws ValParamException {
    //    compDep.seDeplacer(this);
    //}
}
