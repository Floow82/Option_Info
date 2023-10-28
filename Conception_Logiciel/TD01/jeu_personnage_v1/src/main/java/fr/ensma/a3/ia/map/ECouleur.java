package fr.ensma.a3.ia.map;

/**
 * Definit une enumeration
 * @author Fleu
 * @sincec 1.0
 * @version 1.0
 */
public enum ECouleur {
    /**
     * rouge (Lannister)
     */
    rouge ("Lannister"),
    /**
     * jaune (Baratheon)
     */
    jaune("Baratheon"),
    /**
     * vert
     */
    vert,
    /**
     * bleu (Stark)
     */
    bleu ("Stark");
    private String couleurFamille;

    private ECouleur() {
        couleurFamille = "???";
    }

    private ECouleur (final String famille) {
        couleurFamille = famille;
    }

    /**
     * Obtient la couleur correspondant à la famille
     * @param famille
     * @return
     */
    public static ECouleur getCouleurParFamille(final String famille) {
        ECouleur val = null;
        for (ECouleur c : values()) {
            if (c.couleurFamille.equals(famille)) {
                val = c;
            }
        }
        return val;
    }
    @Override
    public String toString() {
        return super.toString() + "(" + couleurFamille + ")";
    }
}