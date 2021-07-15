/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzasystem;

/**
 *
 * @author Michael
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PizzaSystemFX extends Application{
    
    @Override
    public void start(Stage stage) {
        String version = System.getProperty("java.version");
        Label l = new Label("Hello PizzaFX, JavaFX 16, running on " + version);
        Scene scene = new Scene(new StackPane(l), 300, 200);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
