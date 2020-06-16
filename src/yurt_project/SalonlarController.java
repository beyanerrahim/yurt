/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yurt_project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bayoon
 */
public class SalonlarController implements Initializable {
    
    @FXML
    private void calisma(ActionEvent a) {
      try {
            Parent parent = FXMLLoader.load(getClass().getResource("Calisma_salonu.fxml"));
            Scene tableview = new Scene(parent);
            Stage window = (Stage) ((Node) a.getSource()).getScene().getWindow();
            window.setScene(tableview);
            window.setTitle("Çalışma salonu");

            window.show();
        } catch (IOException ex) {
           Logger.getLogger(SalonlarController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @FXML
    private void konf(ActionEvent a) {
      try {
            Parent parent = FXMLLoader.load(getClass().getResource("Konferens_salonu.fxml"));
            Scene tableview = new Scene(parent);
            Stage window = (Stage) ((Node) a.getSource()).getScene().getWindow();
            window.setScene(tableview);
            window.setTitle("konferens salonu");

            window.show();
        } catch (IOException ex) {
           Logger.getLogger(SalonlarController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @FXML
    private void spor(ActionEvent a) {
      try {
            Parent parent = FXMLLoader.load(getClass().getResource("Spor_salonu.fxml"));
            Scene tableview = new Scene(parent);
            Stage window = (Stage) ((Node) a.getSource()).getScene().getWindow();
            window.setScene(tableview);
            window.setTitle("Spor salonu");

            window.show();
        } catch (IOException ex) {
           Logger.getLogger(SalonlarController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @FXML
    private void kitapsalonu(ActionEvent a) {
      try {
            Parent parent = FXMLLoader.load(getClass().getResource("Kitap_salonu.fxml"));
            Scene tableview = new Scene(parent);
            Stage window = (Stage) ((Node) a.getSource()).getScene().getWindow();
            window.setScene(tableview);
            window.setTitle("Kitap salonu");

            window.show();
        } catch (IOException ex) {
           Logger.getLogger(SalonlarController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     @FXML
    private void Back2(ActionEvent event) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            Scene tableVView = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableVView);

            window.show();
        } catch (IOException ex) {
            Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
