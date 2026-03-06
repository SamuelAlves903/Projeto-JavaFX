package com.clinica.fx.controller.atendente;

import com.clinica.fx.dto.ServicoListarDTO;
import com.clinica.fx.service.ServicoService;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.math.BigDecimal;

public class AtendenteListaServicoController {

    private ServicoService servicoService = new ServicoService();

    @FXML
    private TableView<ServicoListarDTO> tableViewServico;

    @FXML
    private TableColumn<ServicoListarDTO, Long> idServico;

    @FXML
    private TableColumn<ServicoListarDTO, String> nomeServico;

    @FXML
    private TableColumn<ServicoListarDTO, BigDecimal> valorServico;

    @FXML
    private TableColumn<ServicoListarDTO, String> descricaoServico;

    public void initialize() {
        idServico.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().id()));
        nomeServico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nome()));
        descricaoServico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().descricao()));
        valorServico.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().preco()));

        ObservableList<ServicoListarDTO> list = FXCollections.observableArrayList(
                servicoService.listarServico()
        );

        tableViewServico.setItems(list);
    }
}
