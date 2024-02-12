package fr.ensma.a3.ia.listeners;

import fr.ensma.a3.ia.structure.ConvertisseurED;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class EcouteurClavier implements EventHandler<KeyEvent> {

    private ConvertisseurED vue;

    public EcouteurClavier(final ConvertisseurED v) {
        vue = v;
    }

    @Override
    public void handle(KeyEvent event) {
        if (event.getCharacter().compareTo("A") == 0) {
            System.out.println("Texte mis a jour.");
            vue.resetChampTexte();
            event.consume();
        }
    }
}
