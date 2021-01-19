package poo.lucas.application.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import poo.lucas.application.view.WindowPrincipal;
import poo.lucas.domain.entities.gasto.GastoDedutivel;
import poo.lucas.domain.entities.gasto.GastoEducacao;
import poo.lucas.domain.entities.gasto.GastoSaude;

import java.io.IOException;
import java.util.List;

import static poo.lucas.application.main.Main.createGastoDedutivelUseCase;

public class WindowDeducaoController {

    @FXML
    private ChoiceBox cbSelecionarGasto;
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
    private Button btnSalvar;

    private GastoDedutivel gastoDedutivel;

    @FXML
    private void initialize(){
        cbSelecionarGasto.setItems(FXCollections.observableArrayList(
                "Educação", "Saúde"
        ));
    }

    public void salvarDeducao(ActionEvent actionEvent) throws IOException {
        getEntityFromView();
        createGastoDedutivelUseCase.create(gastoDedutivel);
        WindowPrincipal.setRoot("WindowPrincipal");
    }

    private void getEntityFromView() {
        if (gastoDedutivel == null){
            createGastoProperKind();
        }
        gastoDedutivel.setDescricao(txtDescricao.getText());
        gastoDedutivel.setValor(Double.valueOf(txtValor.getText()));
        gastoDedutivel.setCnpj(txtCNPJ.getText());
    }

    private void createGastoProperKind() {
        Object selectedGasto = cbSelecionarGasto.getSelectionModel().getSelectedItem();
        if(selectedGasto == "Educação"){
            GastoEducacao gastoEducacao = new GastoEducacao();
            gastoEducacao.setNomeInstituicao(txtInstituicao.getText());
            gastoDedutivel = gastoEducacao;
        } else {
            txtInstituicao.setDisable(true);
            GastoSaude gastoSaude = new GastoSaude();
            gastoSaude.setRegConselho(txtConcelho.getText());
            gastoDedutivel = gastoSaude;
        }
    }
}
