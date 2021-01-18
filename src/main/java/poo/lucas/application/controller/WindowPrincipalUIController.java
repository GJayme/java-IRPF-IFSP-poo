package poo.lucas.application.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import poo.lucas.application.view.WindowPrincipal;
import poo.lucas.domain.entities.gasto.GastoDedutivel;
import poo.lucas.domain.entities.gasto.GastoEducacao;
import poo.lucas.domain.entities.gasto.GastoSaude;

import java.io.IOException;
import java.util.List;

import static poo.lucas.application.main.Main.findGastoDedutivelUseCase;

public class WindowPrincipalUIController {

    @FXML
    private Label lblRendaTributavel;
    @FXML
    private Label lblValorPago;
    @FXML
    private TextField txtValorTributavel;
    @FXML
    private TextField txtValorPago;
    @FXML
    private TableView<GastoDedutivel> tableView;
    @FXML
    private TableColumn<GastoDedutivel, String> cDescricao;
    @FXML
    private TableColumn<GastoDedutivel, Double> cValor;
    @FXML
    private TableColumn<GastoDedutivel, String> cCNPJ;
    @FXML
    private TableColumn<GastoDedutivel, String> cInstituicao;
    @FXML
    private TableColumn<GastoDedutivel, String> cConcelho;

    private ObservableList<GastoDedutivel> tableData;

    @FXML
    private void initialize(){
        bindTableViewToItemsList();
        bindColumnsToValueSources();
        loadDataAndShow();
    }

    private void bindTableViewToItemsList() {
        tableData = FXCollections.observableArrayList();
        tableView.setItems(tableData);
    }

    private void bindColumnsToValueSources() {
        cDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        cValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        cCNPJ.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
        cDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        cInstituicao.setCellValueFactory(new PropertyValueFactory<>("nomeInstituicao"));
        cConcelho.setCellValueFactory(new PropertyValueFactory<>("regConselho"));
    }

    private void loadDataAndShow() {
        List<GastoDedutivel> gastoDedutiveis = findGastoDedutivelUseCase.findAll();
        tableData.clear();
        tableData.addAll(gastoDedutiveis);
    }

    public void adicionarGastoDedutivel(ActionEvent actionEvent) throws IOException {
        WindowPrincipal windowPrincipal = new WindowPrincipal();
        windowPrincipal.show();
    }

    public void removerGastoDedutivel(ActionEvent actionEvent) {
    }

    public void editarGastoDedutivel(ActionEvent actionEvent) {
    }

    public void calcularDeclaracoes(ActionEvent actionEvent) {
    }
}
