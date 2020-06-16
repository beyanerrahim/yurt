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
public class Calisma_salonuController implements Initializable,controller {

    @FXML
    private TableView<Calisma_salonu> calismatable;
    @FXML
    private TableColumn<Calisma_salonu, Integer> id;
    @FXML
    private TableColumn<Calisma_salonu, String> tip;
    @FXML
    private TableColumn<Calisma_salonu, String> alan;
    @FXML
    private TableColumn<Calisma_salonu, Integer> masa_sayisi;
    @FXML
    private TableColumn<Calisma_salonu, Integer> sand_sayisi;
    @FXML
    private TableColumn<Calisma_salonu, String> renk;
    
  
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
    private TextField T6;
    @FXML
    private TextField search;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Oku();
        } catch (IOException ex) {
            Logger.getLogger(Calisma_salonuController.class.getName()).log(Level.SEVERE, null, ex);
        }
            id.setCellValueFactory(new PropertyValueFactory<Calisma_salonu,Integer>("id"));
            tip.setCellValueFactory(new PropertyValueFactory<Calisma_salonu,String>("salon_tipi"));
            alan.setCellValueFactory(new PropertyValueFactory<Calisma_salonu,String>("alan"));
            masa_sayisi.setCellValueFactory(new PropertyValueFactory<Calisma_salonu,Integer>("masa_sayisi"));
            sand_sayisi.setCellValueFactory(new PropertyValueFactory<Calisma_salonu,Integer>("sandalye_sayisi"));
            renk.setCellValueFactory(new PropertyValueFactory<Calisma_salonu,String>("salon_rengi"));
        
            
            calismatable.setItems(calismalist);
       
    }  
    ObservableList<Calisma_salonu> calismalist = FXCollections.observableArrayList();
    Dosya_islemleri txt = new Dosya_islemleri();
    List<String> liste = new ArrayList<>();

    public void Oku() throws IOException {
        liste.clear();
        calismalist.clear();
        txt.TxtReader("calismasalonu.txt", liste);

        Calisma_salonu tmp;
        for (int i = 0; i < txt.Length("calismasalonu.txt"); i++) {
            tmp = new Calisma_salonu();
            tmp.setId(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("@") + 1, liste.get(i).indexOf("#"))));
            tmp.setSalon_tipi(liste.get(i).substring(liste.get(i).indexOf("#") + 1, liste.get(i).indexOf("$")));
            tmp.setAlan(liste.get(i).substring(liste.get(i).indexOf("$") + 1, liste.get(i).indexOf("%")));
            tmp.setMasa_sayisi(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("%") + 1, liste.get(i).indexOf("^"))));
            tmp.setSandalye_sayisi(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("^") + 1, liste.get(i).indexOf("&"))));
            tmp.setSalon_rengi(liste.get(i).substring(liste.get(i).indexOf("&") + 1, liste.get(i).indexOf("*")));

            calismalist.add(tmp);
        }
    }

    @Override
    public void ekle() {
        if ((T1.getText().length() == 0) || T2.getText().length() == 0 || T3.getText().length() == 0 || T4.getText().length() == 0
                || T5.getText().length() == 0 || T6.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Bir Alani booooooos birktiniz");
        } else {
            calismalist.add(getData());
            T1.clear();
            T2.clear();
            T3.clear();
            T4.clear();
            T5.clear();
            T6.clear();
         
            try {
                txt.addLine("calismasalonu.txt", calismalist.get(calismalist.size() - 1).toString(), true);
            } catch (IOException ex) {
                Logger.getLogger(Calisma_salonuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       

    }
    public Calisma_salonu getData() {
        int id=Integer.parseInt(T1.getText());
        String tip=T2.getText();
        String rengi=T3.getText();
        int masa_sayisi=Integer.parseInt(T4.getText());
        int sand=Integer.parseInt(T5.getText());
        String renk=T6.getText();
        
        return new Calisma_salonu(masa_sayisi, sand, renk, id, tip, rengi);
    }
    
    
    int index;
    
    @Override
    public void getSelected() {
         index = calismatable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        T1.setText( id.getCellData(index).toString());
        T2.setText(tip.getCellData(index));
        T3.setText(alan.getCellData(index));
        T4.setText(masa_sayisi.getCellData(index).toString());
        T5.setText(sand_sayisi.getCellData(index).toString());
        T6.setText(renk.getCellData(index)); 
    }

    @Override
    public void guncelle() {
         if (index <= -1) {
            return;
        }
       if ((T1.getText().length() == 0) || T2.getText().length() == 0 || T3.getText().length() == 0 || T4.getText().length() == 0
                || T5.getText().length() == 0 || T6.getText().length() == 0 ) {
            JOptionPane.showMessageDialog(null, "GUNCELLENECEK INDEXI SECMEDINIZ");
        } else {
            calismalist.set(index, getData());
            T1.clear();
            T2.clear();
            T3.clear();
            T4.clear();
            T5.clear();
            T6.clear();
         
            for (int i = 0; i < calismalist.size(); i++) {
                try {
                    if (i == 0) {
                        txt.addLine("calismasalonu.txt", calismalist.get(i).toString(), false);

                    } else {
                        txt.addLine("calismasalonu.txt", calismalist.get(i).toString(), true);

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Calisma_salonuController.class.getName()).log(Level.SEVERE, null, ex);
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
                || T5.getText().length() == 0 || T6.getText().length() == 0 ) {
            JOptionPane.showMessageDialog(null, "SILENECEK INDEXI SECMEDINIZ");
        } else {
           calismatable.getItems().remove(index);
            index = -1;
            T1.clear();
            T2.clear();
            T3.clear();
            T4.clear();
            T5.clear();
            T6.clear();
         
            for (int i = 0; i < calismalist.size(); i++) {
                try {
                    if (i == 0) {
                        txt.addLine("calismasalonu.txt", calismalist.get(i).toString(), false);

                    } else {
                        txt.addLine("calismasalonu.txt", calismalist.get(i).toString(), true);

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Calisma_salonuController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }          
    }

    @Override
    public void ara() {
        search.textProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {

                if (search.textProperty().get().isEmpty()) {
                    calismatable.setItems(calismalist);
                    return;
                }//eger bos ise

                //degilse?
                ObservableList<Calisma_salonu> items = FXCollections.observableArrayList();
                ObservableList<TableColumn<Calisma_salonu, ?>> column = calismatable.getColumns();

                for (int row = 0; row < calismalist.size(); row++) {
                    for (int col = 0; col < column.size(); col++) {
                        TableColumn colVar = column.get(col);
                        String celValue = colVar.getCellData(calismalist.get(row)).toString();
                        celValue = celValue.toLowerCase();

                        if (celValue.contains(search.getText().toLowerCase()) && celValue.startsWith(search.getText().toLowerCase())) {
                            items.add(calismalist.get(row));
                            break;
                        }
                    }
                }
                calismatable.setItems(items);
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
            Logger.getLogger(Calisma_salonuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }     
}
