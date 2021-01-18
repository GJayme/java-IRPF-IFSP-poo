module poo.lucas {
    requires javafx.controls;
    requires javafx.fxml;

    opens poo.lucas to javafx.fxml;
    exports poo.lucas;
}