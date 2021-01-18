module poo.lucas {
    requires javafx.controls;
    requires javafx.fxml;

    opens poo.lucas.application.view to javafx.fxml;
    opens poo.lucas.application.controller to javafx.fxml;

    exports poo.lucas.application.view;
    exports poo.lucas.application.controller;
}