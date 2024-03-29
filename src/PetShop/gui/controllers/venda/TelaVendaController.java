package PetShop.gui.controllers.venda;/*
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
public class TelaVendaController implements Initializable {
    @FXML
    private Pane painel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void vendaProdutosHandler(ActionEvent event) {
        Pane vendaPet;

        try {
            vendaPet = FXMLLoader.load(getClass().getResource("../../views/venda/TelaVendaProdutos.fxml"));
            painel.getChildren().setAll(vendaPet);

        } catch (IOException ex) {
            ex.printStackTrace();

        }

    }
    @FXML
    private void vendaPetsHandler(ActionEvent event) {
        Pane vendaPet;
        try {
            vendaPet = FXMLLoader.load(getClass().getResource("../../views/venda/TelaVendaPets.fxml"));
            painel.getChildren().setAll(vendaPet);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
    }

    @FXML
    private void voltarHandler(ActionEvent event) {
        Pane menuInicial;
        try {
            menuInicial = FXMLLoader.load(getClass().getResource("../../views/MenuInicial.fxml"));
            painel.getChildren().setAll(menuInicial);
           
        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
