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
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bayoon
 */
  public class MainMenuController implements Initializable {

    @FXML
    Button ogrenci;
    
    @FXML
    private void ogrenciler(ActionEvent a) {
      try {
            Parent parent = FXMLLoader.load(getClass().getResource("Ogrenci.fxml"));
            Scene tableview = new Scene(parent);
            Stage window = (Stage) ((Node) a.getSource()).getScene().getWindow();
            window.setScene(tableview);
             window.setTitle("ogrenciler");
            window.show();
        } catch (IOException ex) {
           Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
   
    @FXML
    private void yemekler(ActionEvent a) {
      try {
            Parent parent = FXMLLoader.load(getClass().getResource("Yemek.fxml"));
            Scene tableview = new Scene(parent);
            Stage window = (Stage) ((Node) a.getSource()).getScene().getWindow();
            window.setScene(tableview);
             window.setTitle("Yemekler");
            window.show();
        } catch (IOException ex) {
           Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @FXML
    private void Courseler(ActionEvent a) {
      try {
            Parent parent = FXMLLoader.load(getClass().getResource("Course.fxml"));
            Scene tableview = new Scene(parent);
            Stage window = (Stage) ((Node) a.getSource()).getScene().getWindow();
            window.setScene(tableview);
             window.setTitle("Courses");
            window.show();
        } catch (IOException ex) {
           Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @FXML
    private void salonler(ActionEvent a) {
      try {
            Parent parent = FXMLLoader.load(getClass().getResource("Salonlar.fxml"));
            Scene tableview = new Scene(parent);
            Stage window = (Stage) ((Node) a.getSource()).getScene().getWindow();
            window.setScene(tableview);
             window.setTitle("Salonlar");
            window.show();
        } catch (IOException ex) {
           Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @FXML
    private void odalar(ActionEvent a) {
      try {
            Parent parent = FXMLLoader.load(getClass().getResource("Odalar.fxml"));
            Scene tableview = new Scene(parent);
            Stage window = (Stage) ((Node) a.getSource()).getScene().getWindow();
            window.setScene(tableview);
             window.setTitle("Odalar");
            window.show();
        } catch (IOException ex) {
           Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @FXML
    private void ogretmenler(ActionEvent a) {
      try {
            Parent parent = FXMLLoader.load(getClass().getResource("Ogretmen.fxml"));
            Scene tableview = new Scene(parent);
            Stage window = (Stage) ((Node) a.getSource()).getScene().getWindow();
            window.setScene(tableview);
             window.setTitle("ogretmenler");
            window.show();
        } catch (IOException ex) {
           Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @FXML
    public void exit() {
        Platform.exit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}
