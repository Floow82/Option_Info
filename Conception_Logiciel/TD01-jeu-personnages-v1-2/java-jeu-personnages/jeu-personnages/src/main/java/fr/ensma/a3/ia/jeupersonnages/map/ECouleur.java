package fr.ensma.a3.ia.jeupersonnages.map;

/**
 * Modélise les couleurs d'une base
 *
 * @author Mikky
 * @since 1.0
 * @version 1.0
 *
 */
public enum ECouleur {

    /**
     * rouge(Lannister)
     */
    rouge("Lannister"),
    /**
     * jaune(Baratheon)
     */
    jaune("Baratheon"),
    /**
     * vert(???)
     */
    vert(),
    /**
     * bleu(Stark)
     */
    bleu("Stark"),
    /**
     * noir(Targaryen)
     */
    noir("Targaryen");

    private String familleBase;

    private ECouleur() {
        familleBase = "???";
    }

    private ECouleur(final String famille) {
        familleBase = famille;
    }

    /**
     * Obtient la couleur à partir de la famille.
     *
     * @param famille la famille demandée
     * @return la couleur correspondant à la famille
     */
    public static ECouleur getCouleurFamille(final String famille) {
        ECouleur val = null;
        for (ECouleur c : values()) {
            if (c.familleBase.equals(famille)) {
                val = c;
            }
        }
        return val;
    }

    /**
     * Obtient la représentation d'une couleur au format chaîne.
     */
    @Override
    public String toString() {
        return super.toString() + "(" + familleBase + ")";
    }
}
