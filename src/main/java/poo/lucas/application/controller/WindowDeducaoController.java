package poo.lucas.application.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import poo.lucas.domain.entities.gasto.GastoDedutivel;

import java.util.List;

public class WindowDeducaoController {

    public void salvarDeducao(ActionEvent actionEvent) {
    }

    @FXML
    private ChoiceBox cbSelecionarGasto;
    @FXML
    private Label lblDescricao;
    @FXML
    private Label lblValor;
    @FXML
    private Label lblInstituicao;
    @FXML
    private Label lblCNPJ;
    @FXML
    private Label lblConcelho;
    @FXML
    private TextField txtDescricao;
    @FXML
    private TextField txtValor;
    @FXML
    private TextField txtCNPJ;
    @FXML
    private TextField txtInstituicao;
    @FXML
    private TextField txtConcelho;
    @FXML
    private Label lblGasto;
    @FXML
    private Button btnSalvar;

    private ObservableList<GastoDedutivel> selectedBox;

    @FXML
    private void initialize(){
        bindTableViewToItemsList();
        bindChoiceToValue();
        loadDataAndShow();
    }

    private void bindTableViewToItemsList() {
        selectedBox = FXCollections.observableArrayList();
        cbSelecionarGasto.setItems(selectedBox);
    }

    private void bindChoiceToValue() {

    }

    private void loadDataAndShow() {
    }
}
