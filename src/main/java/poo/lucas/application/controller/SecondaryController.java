package poo.lucas.application.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import poo.lucas.application.view.App;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}