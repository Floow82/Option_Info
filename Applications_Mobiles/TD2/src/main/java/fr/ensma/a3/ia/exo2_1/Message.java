package fr.ensma.a3.ia.exo2_1;

public class Message implements IBalMessages {

    private String leMess;
    private static int numInstance;

    public Message(final String m) {
        numInstance++;
        leMess = m + " - " + numInstance;
    }

    public String getValMess() {
        return leMess;
    }

    public void setValMess(final String m) {
        leMess = m;
    }

    @Override
    public String toString() {
        return "Corps du Message : " + leMess;
    }
}
