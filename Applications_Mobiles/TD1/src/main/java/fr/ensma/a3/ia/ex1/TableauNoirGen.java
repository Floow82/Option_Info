package fr.ensma.a3.ia.ex1;

public class TableauNoirGen<T> {

    private T monTab;

    public TableauNoirGen() {
    }

    public T getValeur() {
        return monTab;
    }

    public void setValeur(final T val) {
        monTab = val;
    }
}
