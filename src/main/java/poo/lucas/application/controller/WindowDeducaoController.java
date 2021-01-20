package poo.lucas.application.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import poo.lucas.application.view.WindowPrincipal;
import poo.lucas.domain.entities.gasto.GastoDedutivel;
import poo.lucas.domain.entities.gasto.GastoEducacao;
import poo.lucas.domain.entities.gasto.GastoSaude;

import java.io.IOException;

import static poo.lucas.application.main.Main.createGastoDedutivelUseCase;
import static poo.lucas.application.main.Main.updateGastoDedutivelUseCase;

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

    private ObservableList<String> opcoes;

    @FXML
    private void initialize(){
        bindChoiceBoxToItens();
        loadChoices();
    }

    private void bindChoiceBoxToItens() {
        opcoes = FXCollections.observableArrayList();
        cbSelecionarGasto.setItems(opcoes);
    }

    private void loadChoices() {
        opcoes.addAll("Educação", "Saúde");
    }

    public void salvarDeducao(ActionEvent actionEvent) throws IOException {

        if (btnSalvar.getText().equals("Atualizar")){
            updateGastoDedutivelUseCase.update(gastoDedutivel);
            WindowPrincipal.setRoot("WindowPrincipal");
            return;
        }

        getEntityFromView();
        createGastoDedutivelUseCase.create(gastoDedutivel);
        WindowPrincipal.setRoot("WindowPrincipal");
    }

    private void cleanField() {
        txtDescricao.setText("");
        txtValor.setText("");
        txtCNPJ.setText("");
        txtConcelho.setText("");
        txtInstituicao.setText("");
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

    public void escolhaGasto(ActionEvent actionEvent) {
        Object selectedItem = cbSelecionarGasto.getSelectionModel().getSelectedItem();
        if (selectedItem == "Educação"){
            txtConcelho.setDisable(true);
            txtInstituicao.setDisable(false);
        } else if (selectedItem == "Saúde"){
            txtInstituicao.setDisable(true);
            txtConcelho.setDisable(false);
        }
    }

    public void setDeducao(GastoDedutivel gastoDedutivel) {
        if (gastoDedutivel == null){
            throw new IllegalArgumentException("Gasto não pode ser nulo.");
        }

        this.gastoDedutivel = gastoDedutivel;

        txtDescricao.setText(gastoDedutivel.getDescricao());
        txtCNPJ.setText(gastoDedutivel.getCnpj());
        txtValor.setText(String.valueOf(gastoDedutivel.getValor()));

        if (gastoDedutivel instanceof GastoEducacao){
            txtInstituicao.setText(((GastoEducacao) gastoDedutivel).getNomeInstituicao());
            cbSelecionarGasto.getSelectionModel().select("Educação");
        } else {
            txtConcelho.setText(((GastoSaude) gastoDedutivel).getRegConselho());
            cbSelecionarGasto.getSelectionModel().select("Saúde");
        }

        btnSalvar.setText("Atualizar");
    }
}
