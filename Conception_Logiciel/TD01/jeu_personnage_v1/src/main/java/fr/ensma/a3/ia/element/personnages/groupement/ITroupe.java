package fr.ensma.a3.ia.element.personnages.groupement;

public interface ITroupe {

    public void rejoindreTroupe(final IDeplacable elem);
    public void quitterTroupe(final IDeplacable elem);
    public void seDeplacer();


}
