package fr.ensma.a3.ia.structure;

import fr.ensma.a3.ia.listeners.EcouteurClavier;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.collections.ObservableList;
import javafx.scene.input.KeyEvent;

/*
Constructeur d'une interface permettant la conversion euro/dollar
@author Fleurine
 */
public class ConvertisseurED extends VBox implements EventHandler<ActionEvent> {
    private FlowPane root2;
    private VBox panBouton;
    private Button actConvert;
    private TextField champEntree, champSortie;
    private ComboBox<String> choixSens;

    public ConvertisseurED(double spacing) {
        super(spacing);
        ObservableList components = this.getChildren();

        root2 = new FlowPane(Orientation.HORIZONTAL, 10, 10);
        root2.setMinWidth(600);
        root2.setAlignment(Pos.TOP_CENTER);
        champEntree = new TextField();
        root2.getChildren().add(champEntree);

        panBouton = new VBox(20);
        panBouton.setAlignment(Pos.TOP_CENTER);
        choixSens = new ComboBox<>();
        choixSens.getItems().addAll("Dollars->Euros", "Euros->Dollars");
        choixSens.getSelectionModel().select(0);
        actConvert = new Button("Conversion !");
        panBouton.getChildren().addAll(choixSens, actConvert);
        root2.getChildren().addAll(panBouton);

        champSortie = new TextField();
        champSortie.setEditable(false);
        champSortie.setDisable(true);
        root2.getChildren().addAll(champSortie);

        //A partir de la c'est du bonus hors sujet du td
        actConvert.addEventHandler(ActionEvent.ACTION, this);
        choixSens.addEventHandler(ActionEvent.ACTION, this);
        actConvert.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Filtre de réaction");
            }
        });

        root2.addEventFilter(KeyEvent.KEY_TYPED, new EcouteurClavier(this));
        root2.addEventFilter(KeyEvent.KEY_TYPED, new EcouteurInterne());
        components.addAll(root2);
    }
    public void resetChampTexte() {
        champEntree.setText("");
        champSortie.setText("");
    }
    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == choixSens) {
            System.out.println("Action choisie : " + choixSens.getValue() + "("
                    + choixSens.getSelectionModel().getSelectedIndex() + ")");
        }
        if (event.getSource() == actConvert) {
            System.out.println("Demande de conversion !");
            convertCurrency();
        }
    }
    private void convertCurrency() {
        String inputText = champEntree.getText();
        if (!inputText.isEmpty()) {
            try {
                double amount = Double.parseDouble(inputText);
                double conversionRate = getConversionRate(); // You need to implement this method
                String result = performConversion(amount, conversionRate);
                champSortie.setText(result);
            } catch (NumberFormatException e) {
                champSortie.setText("Invalid input");
            }
        } else {
            champSortie.setText("Enter an amount");
        }
    }

    private double getConversionRate() {
        // Tableau de taux de conversion (Dollars vers Euros et Euros vers Dollars)
        double[] conversionRates = {1.2, 0.8};

        // Récupère l'indice sélectionné dans le ComboBox
        int selectedIndex = choixSens.getSelectionModel().getSelectedIndex();
        // Vérifie que l'indice est valide
        if (selectedIndex >= 0 && selectedIndex < conversionRates.length) {
            // Retourne le taux de conversion correspondant à l'indice
            return conversionRates[selectedIndex];
        } else {
            // Gestion d'erreur : indice invalide
            System.err.println("Indice de conversion invalide : " + selectedIndex);
            return 1.0; // Par défaut, retourne 1.0 si l'indice est invalide
        }
    }


    private String performConversion(double amount, double conversionRate) {
        double result = amount * conversionRate;
        return String.format("%.2f", result);
    }

    //Classe ecouteur interne
    private class EcouteurInterne implements EventHandler<KeyEvent> {

        public EcouteurInterne() {}

        @Override
        public void handle(KeyEvent event) {
            if (event.getCharacter().compareTo("A") == 0) {
                System.out.println("Depuis l'ecouteur Interne");
                resetChampTexte();
                event.consume();
            }
        }
    }

}
