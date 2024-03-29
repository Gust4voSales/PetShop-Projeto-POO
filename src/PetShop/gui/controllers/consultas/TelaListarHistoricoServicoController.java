/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetShop.gui.controllers.consultas;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import PetShop.Main;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import PetShop.negocio.contratos.ServicoAbstrato;
import PetShop.negocio.entidades.Cliente;
import PetShop.negocio.excecoes.ClienteInexistenteException;

/**
 * FXML Controller class
 * Essa classe faz a conexão entre a interface gráfica e a fachada.
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
public class TelaListarHistoricoServicoController implements Initializable {
    private Alert spam;

    @FXML
    private TableView<ServicoAbstrato> tbView;
    @FXML
    private Pane painelListaServico;
    @FXML
    private TextField inputCpf;
    @FXML
    private DatePicker dateSearch;
    @FXML
    private TableColumn<ServicoAbstrato, String> tbNome;
    @FXML
    private TableColumn<ServicoAbstrato, String> tbCpf;
    @FXML
    private TableColumn<ServicoAbstrato, String> tbTipoServico;
    @FXML
    private TableColumn<ServicoAbstrato, String> tbPet;
    @FXML
    private TableColumn<ServicoAbstrato, String> tbData;
    @FXML
    private TableColumn<?, ?> tbStatus;

    public TelaListarHistoricoServicoController(){
        spam = new Alert(Alert.AlertType.NONE);
        spam.setAlertType(Alert.AlertType.ERROR);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        tbNome.setCellValueFactory(cliente -> new SimpleStringProperty(cliente.getValue().getCliente().getNome()));
        tbCpf.setCellValueFactory(cliente -> new SimpleStringProperty(cliente.getValue().getCliente().getCpf()));
        tbTipoServico.setCellValueFactory(
                new PropertyValueFactory<>("descricao"));
        tbPet.setCellValueFactory(pet -> new SimpleStringProperty(pet.getValue().getPet().getNome()));
        tbData.setCellValueFactory(agendamento -> new SimpleStringProperty(
                (agendamento.getValue().getData() + " - " + agendamento.getValue().getHoraAgendada())));
        tbStatus.setCellValueFactory(
                new PropertyValueFactory<>("Status"));

        preencherHistorico();
    }

    private void preencherHistorico(){
        ArrayList<ServicoAbstrato> servicos = Main.petShop.consultarServicos();

        tbView.getItems().clear();
        for (ServicoAbstrato s: servicos){
            tbView.getItems().add(s);
        }
    }

    @FXML
    private void buscarBtnHandler(ActionEvent event) {
        LocalDate date = dateSearch.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        tbView.getItems().clear();
        if (inputCpf.getLength()>0){
            try{
                Cliente cliente = Main.petShop.consultarCliente(inputCpf.getText());

            } catch (ClienteInexistenteException e) {
                spam.setContentText(e.getMessage());
                spam.show();
                tbView.getItems().clear();
                return;
            }
            if (dateSearch.getValue()!=null){
                String data = date.format(formatter);
                ArrayList<ServicoAbstrato> servicos = Main.petShop.consultarServicosClientePorData(
                        inputCpf.getText(), data);

                for (ServicoAbstrato s: servicos) {
                    tbView.getItems().add(s);
                }
            } else {
                ArrayList<ServicoAbstrato> servicos = Main.petShop.consultarServicosCliente(inputCpf.getText());

                for (ServicoAbstrato s: servicos){
                    tbView.getItems().add(s);
                }
            }
        } else if (dateSearch.getValue()!=null){
            String data = date.format(formatter);
            ArrayList<ServicoAbstrato> servicos = Main.petShop.consultarServicosPorData(data);

            for (ServicoAbstrato s: servicos){
                tbView.getItems().add(s);
            }
        } else {
            preencherHistorico();
        }
    }

    @FXML
    private void voltarBtnHandler(ActionEvent event) {
        Pane listar;
        try {
            listar = FXMLLoader.load(getClass().getResource("../../views/consultas/TelaListar.fxml"));
            painelListaServico.getChildren().setAll(listar);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
    }

}
