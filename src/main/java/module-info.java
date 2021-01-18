module poo.lucas {
    requires javafx.controls;
    requires javafx.fxml;

    opens poo.lucas.application.view to javafx.fxml;
    opens poo.lucas.application.controller to javafx.fxml;
    opens poo.lucas.domain.entities.gasto to javafx.base;
    opens poo.lucas.domain.entities.declaracao to javafx.base;

    exports poo.lucas.application.view;
    exports poo.lucas.application.controller;
}