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
public class CourseController implements Initializable {

    
    @FXML
    private void arapca(ActionEvent a) {
      try {
            Parent parent = FXMLLoader.load(getClass().getResource("Arapca_kursu.fxml"));
            Scene tableview = new Scene(parent);
            Stage window = (Stage) ((Node) a.getSource()).getScene().getWindow();
            window.setScene(tableview);
            window.setTitle("Arapca kursu");

            window.show();
        } catch (IOException ex) {
           Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
   
    @FXML
    private void turkce(ActionEvent a) {
      try {
            Parent parent = FXMLLoader.load(getClass().getResource("Turkce_kursu.fxml"));
            Scene tableview = new Scene(parent);
            Stage window = (Stage) ((Node) a.getSource()).getScene().getWindow();
            window.setScene(tableview);
            window.setTitle("Turkce kursu");

            window.show();
        } catch (IOException ex) {
           Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void kuran(ActionEvent a) {
      try {
            Parent parent = FXMLLoader.load(getClass().getResource("Kuran_kursu.fxml"));
            Scene tableview = new Scene(parent);
            Stage window = (Stage) ((Node) a.getSource()).getScene().getWindow();
            window.setScene(tableview);
            window.setTitle("Kuran kursu");

            window.show();
        } catch (IOException ex) {
           Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
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
