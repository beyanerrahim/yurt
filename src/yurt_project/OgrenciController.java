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
public class OgrenciController implements Initializable {

    @FXML
    private void liseogrenci(ActionEvent a) {
      try {
            Parent parent = FXMLLoader.load(getClass().getResource("Lise_ogrenci.fxml"));
            Scene tableview = new Scene(parent);
            Stage window = (Stage) ((Node) a.getSource()).getScene().getWindow();
            window.setScene(tableview);
            window.setTitle("lise_ogrenci");

            window.show();
        } catch (IOException ex) {
           Logger.getLogger(OgrenciController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @FXML
    private void univergrenci(ActionEvent a) {
      try {
            Parent parent = FXMLLoader.load(getClass().getResource("Univer_ogrenci.fxml"));
            Scene tableview = new Scene(parent);
            Stage window = (Stage) ((Node) a.getSource()).getScene().getWindow();
            window.setScene(tableview);
            window.setTitle("universite ogrenciler");

            window.show();
        } catch (IOException ex) {
           Logger.getLogger(OgrenciController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @FXML
    private void hazirlik(ActionEvent a) {
      try {
            Parent parent = FXMLLoader.load(getClass().getResource("Hazirlik_ogrenci.fxml"));
            Scene tableview = new Scene(parent);
            Stage window = (Stage) ((Node) a.getSource()).getScene().getWindow();
            window.setScene(tableview);
            window.setTitle("Hazirlik ogrenciler");

            window.show();
        } catch (IOException ex) {
           Logger.getLogger(OgrenciController.class.getName()).log(Level.SEVERE, null, ex);
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
        // TODO
    }    
    
}
