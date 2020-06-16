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
public class Kitap_salonuController implements Initializable,controller {
    @FXML
    private TableView<Kitap_salonu> kitaptable;
    @FXML
    private TableColumn<Kitap_salonu, Integer> id;
    @FXML
    private TableColumn<Kitap_salonu, String> tip;
    @FXML
    private TableColumn<Kitap_salonu, String> alan;
    @FXML
    private TableColumn<Kitap_salonu, Integer> kitap_sayisi;
    @FXML
    private TableColumn<Kitap_salonu, String> kitap_tipi;
    @FXML
    private TableColumn<Kitap_salonu, String> durum;
    
  
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
            Logger.getLogger(Kitap_salonuController.class.getName()).log(Level.SEVERE, null, ex);
        }
            id.setCellValueFactory(new PropertyValueFactory<Kitap_salonu,Integer>("id"));
            tip.setCellValueFactory(new PropertyValueFactory<Kitap_salonu,String>("salon_tipi"));
            alan.setCellValueFactory(new PropertyValueFactory<Kitap_salonu,String>("alan"));
            kitap_sayisi.setCellValueFactory(new PropertyValueFactory<Kitap_salonu,Integer>("kitap_sayisi"));
            kitap_tipi.setCellValueFactory(new PropertyValueFactory<Kitap_salonu,String>("kitap_tipi"));
            durum.setCellValueFactory(new PropertyValueFactory<Kitap_salonu,String>("durum"));
        
            
            kitaptable.setItems(kitaplist);
    }    
    ObservableList<Kitap_salonu> kitaplist = FXCollections.observableArrayList();
    Dosya_islemleri txt = new Dosya_islemleri();
    List<String> liste = new ArrayList<>();

    public void Oku() throws IOException {
        liste.clear();
        kitaplist.clear();
        txt.TxtReader("kitapsalonu.txt", liste);

        Kitap_salonu tmp;
        for (int i = 0; i < txt.Length("kitapsalonu.txt"); i++) {
            tmp = new Kitap_salonu();
            tmp.setId(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("@") + 1, liste.get(i).indexOf("#"))));
            tmp.setSalon_tipi(liste.get(i).substring(liste.get(i).indexOf("#") + 1, liste.get(i).indexOf("$")));
            tmp.setAlan(liste.get(i).substring(liste.get(i).indexOf("$") + 1, liste.get(i).indexOf("%")));
            tmp.setKitap_sayisi(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("%") + 1, liste.get(i).indexOf("^"))));
            tmp.setKitap_tipi(liste.get(i).substring(liste.get(i).indexOf("^") + 1, liste.get(i).indexOf("&")));
            tmp.setDurum(liste.get(i).substring(liste.get(i).indexOf("&") + 1, liste.get(i).indexOf("*")));

            kitaplist.add(tmp);
        }
    }

    @Override
    public void ekle() {
        if ((T1.getText().length() == 0) || T2.getText().length() == 0 || T3.getText().length() == 0 || T4.getText().length() == 0
                || T5.getText().length() == 0 || T6.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Bir Alani booooooos birktiniz");
        } else {
            kitaplist.add(getData());
            T1.clear();
            T2.clear();
            T3.clear();
            T4.clear();
            T5.clear();
            T6.clear();
         
            try {
                txt.addLine("kitapsalonu.txt", kitaplist.get(kitaplist.size() - 1).toString(), true);
            } catch (IOException ex) {
                Logger.getLogger(Kitap_salonuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }               
    }
    public Kitap_salonu getData() {
        int id=Integer.parseInt(T1.getText());
        String tip=T2.getText();
        String rengi=T3.getText();
        int kitap_sayisi=Integer.parseInt(T4.getText());
        String tipi=T5.getText();
        String durum=T6.getText();
        
        return new Kitap_salonu(kitap_sayisi,tipi, durum, id, tip, rengi);
    }
    int index;
    @Override
    public void getSelected() {
      
        index = kitaptable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        T1.setText( id.getCellData(index).toString());
        T2.setText(tip.getCellData(index));
        T3.setText(alan.getCellData(index));
        T4.setText(kitap_sayisi.getCellData(index).toString());
        T5.setText(kitap_tipi.getCellData(index));
        T6.setText(durum.getCellData(index)); 
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
            kitaplist.set(index, getData());
            T1.clear();
            T2.clear();
            T3.clear();
            T4.clear();
            T5.clear();
            T6.clear();
         
            for (int i = 0; i < kitaplist.size(); i++) {
                try {
                    if (i == 0) {
                        txt.addLine("kitapsalonu.txt", kitaplist.get(i).toString(), false);

                    } else {
                        txt.addLine("kitapsalonu.txt", kitaplist.get(i).toString(), true);

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Kitap_salonuController.class.getName()).log(Level.SEVERE, null, ex);
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
            kitaptable.getItems().remove(index);
            index = -1;
            T1.clear();
            T2.clear();
            T3.clear();
            T4.clear();
            T5.clear();
            T6.clear();
         
            for (int i = 0; i < kitaplist.size(); i++) {
                try {
                    if (i == 0) {
                        txt.addLine("kitapsalonu.txt", kitaplist.get(i).toString(), false);

                    } else {
                        txt.addLine("kitapsalonu.txt", kitaplist.get(i).toString(), true);

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Kitap_salonuController.class.getName()).log(Level.SEVERE, null, ex);
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
                    kitaptable.setItems(kitaplist);
                    return;
                }//eger bos ise

                //degilse?
                ObservableList<Kitap_salonu> items = FXCollections.observableArrayList();
                ObservableList<TableColumn<Kitap_salonu, ?>> column = kitaptable.getColumns();

                for (int row = 0; row < kitaplist.size(); row++) {
                    for (int col = 0; col < column.size(); col++) {
                        TableColumn colVar = column.get(col);
                        String celValue = colVar.getCellData(kitaplist.get(row)).toString();
                        celValue = celValue.toLowerCase();

                        if (celValue.contains(search.getText().toLowerCase()) && celValue.startsWith(search.getText().toLowerCase())) {
                            items.add(kitaplist.get(row));
                            break;
                        }
                    }
                }
                kitaptable.setItems(items);
            }
        });
    }
   
    @FXML
    private void Back1(ActionEvent event) {
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
