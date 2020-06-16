/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yurt_project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Bayoon
 */
public class LoginController implements Initializable {

    @FXML
    TextField username;
    @FXML
    PasswordField password;
    
    @FXML
    public void login(Event e) {
        try {
            if (username.getText().trim().matches("") && password.getText().equalsIgnoreCase("")) {

                Parent parent = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));

                Scene scene = new Scene(parent);
                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("MainMenu");
               stage.show();
        

            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Password or UserName");
            }
        } catch (IOException ex) {
            
        }
    }
    @FXML
    public void exit() {
        Platform.exit();
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
