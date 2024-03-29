package PetShop.gui.controllers.alterar;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import PetShop.gui.controllers.MenuInicialController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 * Essa classe faz a conexão entre a interface gráfica e a fachada.
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
public class TelaAlterarController implements Initializable {

    @FXML
    private Pane painelAlterar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void alterarClienteBtnHandler(ActionEvent event) {
        Pane alterarClientes;
        try {

            alterarClientes = FXMLLoader.load(getClass().getResource("../../views/alterar/TelaAlterarCliente.fxml"));
            painelAlterar.getChildren().setAll(alterarClientes);

        } catch (IOException ex) {
            System.out.println(ex);

        }
    }

    @FXML
    private void alterarProdutoBtnHandler(ActionEvent event) {
        Pane alterarPets;
        try {
            alterarPets = FXMLLoader.load(getClass().getResource("../../views/alterar/TelaAlterarProdutos.fxml"));
            painelAlterar.getChildren().setAll(alterarPets);

        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void alterarPetPetshopBtnHandler(ActionEvent event) {
        Pane alterarPets;
        try {
            alterarPets = FXMLLoader.load(getClass().getResource("../../views/alterar/TelaAlterarPets.fxml"));
            painelAlterar.getChildren().setAll(alterarPets);

        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void voltarBtnHandler(ActionEvent event) {
        Pane menuInicial;
        try {
            menuInicial = FXMLLoader.load(getClass().getResource("../../views/MenuInicial.fxml"));
            painelAlterar.getChildren().setAll(menuInicial);
           
        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterarServicoBtnHandler(ActionEvent actionEvent) {
        Pane alterarServico;
        try {
            alterarServico = FXMLLoader.load(getClass().getResource("../../views/alterar/TelaAlterarServico.fxml"));
            painelAlterar.getChildren().setAll(alterarServico);

        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
