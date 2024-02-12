package fr.ensma.a3.ia;

import fr.ensma.a3.ia.structure.ConvertisseurED;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application
{
    @Override
    public void start(Stage primaryStage){
        Scene ConvScene = new Scene (new ConvertisseurED(20));
        primaryStage.setScene(ConvScene);
        primaryStage.setTitle("Convertisseur Euros<->Dollars");
        // Limite le redimensionnement
        primaryStage.setMinWidth(600);
        primaryStage.setMinHeight(120);
        primaryStage.show();
    }
    public static void main( String[] args )
    {
        launch(args);
    }
}
