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
public class OdalarController implements Initializable {

    @FXML
    private void yatak(ActionEvent a) {
      try {
            Parent parent = FXMLLoader.load(getClass().getResource("Yatak_odasi.fxml"));
            Scene tableview = new Scene(parent);
            Stage window = (Stage) ((Node) a.getSource()).getScene().getWindow();
            window.setScene(tableview);
            window.setTitle("yatak odalar");

            window.show();
        } catch (IOException ex) {
           Logger.getLogger(OdalarController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @FXML
    private void dinlenme(ActionEvent a) {
      try {
            Parent parent = FXMLLoader.load(getClass().getResource("Dinlenme_odasi.fxml"));
            Scene tableview = new Scene(parent);
            Stage window = (Stage) ((Node) a.getSource()).getScene().getWindow();
            window.setScene(tableview);
            window.setTitle("dinlenme odalar");

            window.show();
        } catch (IOException ex) {
           Logger.getLogger(OdalarController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @FXML
    private void camasir(ActionEvent a) {
      try {
            Parent parent = FXMLLoader.load(getClass().getResource("Camasir_odasi.fxml"));
            Scene tableview = new Scene(parent);
            Stage window = (Stage) ((Node) a.getSource()).getScene().getWindow();
            window.setScene(tableview);
            window.setTitle("Camasir odalar");

            window.show();
        } catch (IOException ex) {
           Logger.getLogger(OdalarController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     @FXML
    private void Back1(ActionEvent event) {
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
       
    }    
    
}
