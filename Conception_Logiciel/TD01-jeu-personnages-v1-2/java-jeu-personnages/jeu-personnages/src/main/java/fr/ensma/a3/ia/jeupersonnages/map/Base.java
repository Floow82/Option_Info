package fr.ensma.a3.ia.jeupersonnages.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ensma.a3.ia.jeupersonnages.elements.IElementJeu;
import fr.ensma.a3.ia.jeupersonnages.outils.ValParamException;

/**
 * Modélise une Base de la map.
 *
 * @author Mikky
 * @since 1.0
 * @version 1.0
 *
 */
public class Base {

    private String nomBase;
    private ECouleur coulBase;
    private List<IElementJeu> elem;

    /**
     * Instancie une Base
     *
     * @param nom  String (non null)
     * @param coul {@link ECouleur} (non null)
     * @throws ValParamException
     */
    public Base(final String nom, final ECouleur coul) throws ValParamException {
        try {
            nomBase = Objects.requireNonNull(nom);
            coulBase = Objects.requireNonNull(coul);
            elem = new ArrayList<IElementJeu>();

        } catch (NullPointerException e) {
            logger.error("Paramètres null...");
            throw new ValParamException(getClass().getSimpleName() + " : Param(s) null");
        }
        logger.info("Base créée : nom = {} - Couleur = {}", nomBase, coulBase);
    }

    /**
     * Obtient le nom de la base
     *
     * @return String le nom
     */
    public final String getNomBase() {
        return nomBase;
    }

    /**
     * Obtient la couleur de la base
     *
     * @return {@link ECouleur} la couleur
     */
    public final ECouleur getCoulBase() {
        return coulBase;
    }

    /**
     * Obtient le nombre d'éléments dans la base
     *
     * @return int nb élément(s)
     */
    public final int getNbElem() {
        return elem.size();
    }

    /**
     * Ajoute un élément à la base
     *
     * @param el IElementJeu
     */
    public void addElementJeu(final IElementJeu el) {
        elem.add(el);
    }

    /**
     * Redéfinition de toString
     */
    @Override
    public String toString() {
        return "Base " + nomBase + ": " + coulBase;
    }

    /**
     * Obtient une chaîne décrivant la base et les éléments
     * qu'elle contient.
     *
     * @return la chaîne de description.
     */
    public String afficheElements() {
        StringBuffer buf = new StringBuffer();
        buf.append(toString() + "\n");
        buf.append("Éléments jeu :\n");
        for (IElementJeu iter : elem) {
            buf.append("--> " + iter + "\n");
        }
        return buf.toString();

    }

    private static Logger logger = LogManager.getLogger(Base.class);

}
