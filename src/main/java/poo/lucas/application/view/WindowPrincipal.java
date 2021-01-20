package poo.lucas.application.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */

public class WindowPrincipal extends Application{

    private static Scene scene;
    private static Object controller;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("WindowPrincipal"));
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader =  new FXMLLoader();
        Parent parent = fxmlLoader.load(WindowPrincipal.class.getResource(fxml + ".fxml").openStream());
        controller = fxmlLoader.getController();
        return parent;
    }

    public static Object getController() {
        return controller;
    }

    //TODO: essa funcao n ta funcionando direito, bug ao enviar dados para a principal
    public static void show(String fxml) throws IOException {
        Scene scene = new Scene(loadFXML(fxml));
        Stage stage = new Stage();
        stage.setScene(scene);

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}