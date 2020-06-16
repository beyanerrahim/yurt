
/*
      Beyan Errahim     02180201091
      Ghina Ağa         02180201089
      Ahmed Alo         02180201086
      Mohamad Zakaria Kannas  02150001614  

*/
package yurt_project;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Bayoon
 */
public class Yurt_project extends Application {
    
    @Override
     public void start(Stage primaryStage) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("Login.fxml"));

            Scene scene = new Scene(parent);

            primaryStage.setTitle("Login Sayfasi");
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(Yurt_project.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
