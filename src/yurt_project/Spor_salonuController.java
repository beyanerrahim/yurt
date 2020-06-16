/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yurt_project;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author Bayoon
 */
public class Spor_salonuController implements Initializable,controller {
    @FXML
    private TableView<Spor_salonu> sportable;
    @FXML
    private TableColumn<Spor_salonu, Integer> id;
    @FXML
    private TableColumn<Spor_salonu, String> tip;
    @FXML
    private TableColumn<Spor_salonu, String> alan;
    @FXML
    private TableColumn<Spor_salonu, String> spor_tipi;
    @FXML
    private TableColumn<Spor_salonu, Integer> uye;
    
    @FXML
    private TextField T1;
    @FXML
    private TextField T2;
    @FXML
    private TextField T3;
    @FXML
    private TextField T4;
    @FXML
    private TextField T5;
    
    @FXML
    private TextField search;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Oku();
        } catch (IOException ex) {
            Logger.getLogger(Spor_salonuController.class.getName()).log(Level.SEVERE, null, ex);
        }
            id.setCellValueFactory(new PropertyValueFactory<Spor_salonu,Integer>("id"));
            tip.setCellValueFactory(new PropertyValueFactory<Spor_salonu,String>("salon_tipi"));
            alan.setCellValueFactory(new PropertyValueFactory<Spor_salonu,String>("alan"));
            spor_tipi.setCellValueFactory(new PropertyValueFactory<Spor_salonu,String>("spor_tipi"));
            uye.setCellValueFactory(new PropertyValueFactory<Spor_salonu,Integer>("uye_sayisi"));
        
            
            sportable.setItems(sporlist);
       
    }    
    ObservableList<Spor_salonu> sporlist = FXCollections.observableArrayList();
    Dosya_islemleri txt = new Dosya_islemleri();
    List<String> liste = new ArrayList<>();

    public void Oku() throws IOException {
        liste.clear();
        sporlist.clear();
        txt.TxtReader("sporsalonu.txt", liste);

        Spor_salonu tmp;
        for (int i = 0; i < txt.Length("sporsalonu.txt"); i++) {
            tmp = new Spor_salonu();
            tmp.setId(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("@") + 1, liste.get(i).indexOf("#"))));
            tmp.setSalon_tipi(liste.get(i).substring(liste.get(i).indexOf("#") + 1, liste.get(i).indexOf("$")));
            tmp.setAlan(liste.get(i).substring(liste.get(i).indexOf("$") + 1, liste.get(i).indexOf("%")));
            tmp.setSpor_tipi(liste.get(i).substring(liste.get(i).indexOf("%") + 1, liste.get(i).indexOf("^")));
            tmp.setUye_sayisi(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("^") + 1, liste.get(i).indexOf("&"))));

           sporlist.add(tmp);
        }
    }   

    @Override
    public void ekle() {
        if ((T1.getText().length() == 0) || T2.getText().length() == 0 || T3.getText().length() == 0 || T4.getText().length() == 0
                || T5.getText().length() == 0 ) {
            JOptionPane.showMessageDialog(null, "Bir Alani booooooos birktiniz");
        } else {
            sporlist.add(getData());
            T1.clear();
            T2.clear();
            T3.clear();
            T4.clear();
            T5.clear();
         
            try {
                txt.addLine("sporsalonu.txt", sporlist.get(sporlist.size() - 1).toString(), true);
            } catch (IOException ex) {
                Logger.getLogger(Spor_salonuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }         
        
    }
    public Spor_salonu getData() {
        int id=Integer.parseInt(T1.getText());
        String tip=T2.getText();
        String rengi=T3.getText();
        String spor=T4.getText();
        int uye=Integer.parseInt(T5.getText());
        
        return new Spor_salonu(spor, uye, id, tip, rengi);
    }
    int index;
    @Override
    public void getSelected() {
         index = sportable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        T1.setText( id.getCellData(index).toString());
        T2.setText(tip.getCellData(index));
        T3.setText(alan.getCellData(index));
        T4.setText(spor_tipi.getCellData(index));
        T5.setText(uye.getCellData(index).toString());
       
    }

    @Override
    public void guncelle() {
        if (index <= -1) {
            return;
        }
       if ((T1.getText().length() == 0) || T2.getText().length() == 0 || T3.getText().length() == 0 || T4.getText().length() == 0
                || T5.getText().length() == 0 ) {
            JOptionPane.showMessageDialog(null, "GUNCELLENECEK INDEXI SECMEDINIZ");
        } else {
            sporlist.set(index, getData());
            T1.clear();
            T2.clear();
            T3.clear();
            T4.clear();
            T5.clear();
                  
            for (int i = 0; i < sporlist.size(); i++) {
                try {
                    if (i == 0) {
                        txt.addLine("sporsalonu.txt", sporlist.get(i).toString(), false);

                    } else {
                        txt.addLine("sporsalonu.txt",sporlist.get(i).toString(), true);

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Spor_salonuController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }          
    }

    @Override
    public void sil() {
        if (index <= -1) {
            return;
        }
       if ((T1.getText().length() == 0) || T2.getText().length() == 0 || T3.getText().length() == 0 || T4.getText().length() == 0
                || T5.getText().length() == 0 ) {
            JOptionPane.showMessageDialog(null, "SILENECEK INDEXI SECMEDINIZ");
        } else {
            sportable.getItems().remove(index);
            index = -1;
            T1.clear();
            T2.clear();
            T3.clear();
            T4.clear();
            T5.clear();
                  
            for (int i = 0; i < sporlist.size(); i++) {
                try {
                    if (i == 0) {
                        txt.addLine("sporsalonu.txt", sporlist.get(i).toString(), false);

                    } else {
                        txt.addLine("sporsalonu.txt",sporlist.get(i).toString(), true);

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Spor_salonuController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }              }

    @Override
    public void ara() {
        search.textProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {

                if (search.textProperty().get().isEmpty()) {
                    sportable.setItems(sporlist);
                    return;
                }//eger bos ise

                //degilse?
                ObservableList<Spor_salonu> items = FXCollections.observableArrayList();
                ObservableList<TableColumn<Spor_salonu, ?>> column = sportable.getColumns();

                for (int row = 0; row < sporlist.size(); row++) {
                    for (int col = 0; col < column.size(); col++) {
                        TableColumn colVar = column.get(col);
                        String celValue = colVar.getCellData(sporlist.get(row)).toString();
                        celValue = celValue.toLowerCase();

                        if (celValue.contains(search.getText().toLowerCase()) && celValue.startsWith(search.getText().toLowerCase())) {
                            items.add(sporlist.get(row));
                            break;
                        }
                    }
                }
               sportable.setItems(items);
            }
        });   
    }
    
    @FXML
    private void Back(ActionEvent event) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("Salonlar.fxml"));
            Scene tableVView = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableVView);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(Konferens_salonuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
