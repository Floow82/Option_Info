package fr.ensma.a3.ia.element.personnages.groupement;

import fr.ensma.a3.ia.utils.ValParamException;

import java.util.ArrayList;

public class Troupe implements ITroupe, IDeplacable {
    private String nomTroupe;
    public ArrayList<IDeplacable> laTroupe;

    public Troupe(final IDeplacable elem, final String nom) throws ValParamException{
        if (elem == null) {
            throw new ValParamException();
        }
        if ( nom == null) {
            throw new ValParamException(getClass().getSimpleName() + " : Param(s) null");
        }
        nomTroupe = nom;
        laTroupe = new ArrayList<IDeplacable>();
        laTroupe.add(elem);
    }

    public final int getNbElem(){
        return laTroupe.size();
    }

    @Override
    public void rejoindreTroupe(final IDeplacable elem){
        laTroupe.add(elem);
    }

    @Override
    public void quitterTroupe (final IDeplacable elem){
        laTroupe.remove(elem);
    }

    @Override
    public void seDeplacer(){
        for (IDeplacable iter : laTroupe) {
            iter.seDeplacer();
        }
    }

    @Override
    public String toString(){
        StringBuffer buff = new StringBuffer();
        buff.append("\n Troupe :" + nomTroupe + "\n");
        for (IDeplacable elem : laTroupe){
            buff.append(elem + "\n");
        }
        return buff.toString();
    }
}
