package poo.lucas.application.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import poo.lucas.application.view.App;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
