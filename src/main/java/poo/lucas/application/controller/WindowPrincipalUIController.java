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
import poo.lucas.domain.entities.declaracao.DeclaracaoCompleta;
import poo.lucas.domain.entities.declaracao.DeclaracaoSimplificada;
import poo.lucas.domain.entities.gasto.GastoDedutivel;
import poo.lucas.domain.usecases.utils.EntityNotFoundException;

import java.io.IOException;
import java.util.List;

import static poo.lucas.application.main.Main.deleteGastoDedutivelUseCase;
import static poo.lucas.application.main.Main.findGastoDedutivelUseCase;

public class WindowPrincipalUIController {

    @FXML
    private Label lblValorSimplicada;
    @FXML
    private Label lblValorCompleta;
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
    }

    private void loadDataAndShow() {
        List<GastoDedutivel> gastoDedutiveis = findGastoDedutivelUseCase.findAll();
        tableData.clear();
        tableData.addAll(gastoDedutiveis);
    }

    public void adicionarGastoDedutivel(ActionEvent actionEvent) throws IOException {
        WindowPrincipal.show("WindowDeducao");
    }

    public void removerGastoDedutivel(ActionEvent actionEvent) {
        GastoDedutivel selectedGasto = tableView.getSelectionModel().getSelectedItem();
        if (selectedGasto != null){
            deleteGastoDedutivelUseCase.delete(selectedGasto);
            loadDataAndShow();
        }
    }

    public void editarGastoDedutivel(ActionEvent actionEvent) throws IOException {
        GastoDedutivel selectedGasto = tableView.getSelectionModel().getSelectedItem();
        if (selectedGasto == null){
            throw new EntityNotFoundException("Nenhum gasto selecionado.");
        }

        WindowPrincipal.setRoot("WindowDeducao");
        WindowDeducaoController controller = (WindowDeducaoController) WindowPrincipal.getController();
        controller.setDeducao(selectedGasto);
    }

    public void calcularDeclaracoes(ActionEvent actionEvent) {
        Double renda = Double.valueOf(txtValorTributavel.getText());
        Double valorPago = Double.valueOf(txtValorPago.getText());

        showDeclaracaoSimplificada(renda, valorPago);
        showDeclaracaoCompleta(renda, valorPago);
    }

    private void showDeclaracaoCompleta(Double renda, Double valorPago) {
        DeclaracaoCompleta declaracaoCompleta = new DeclaracaoCompleta(renda, valorPago);

        for (GastoDedutivel gasto : tableData) {
            declaracaoCompleta.addGasto(gasto);
        }
        lblValorCompleta.setText(String.valueOf(declaracaoCompleta.valorImposto()));
    }

    private void showDeclaracaoSimplificada(Double renda, Double valorPago) {
        DeclaracaoSimplificada declaracaoSimplificada = new DeclaracaoSimplificada(renda, valorPago);
        lblValorSimplicada.setText(String.valueOf(declaracaoSimplificada.valorImposto()));
    }
}
