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
public class Yatak_odasiController implements Initializable,controller {
    
    @FXML
    private TableView<Yatak_odasi> yataktable;
    @FXML
    private TableColumn<Yatak_odasi, Integer> oda_no;
    @FXML
    private TableColumn<Yatak_odasi, String> oda_tip;
    @FXML
    private TableColumn<Yatak_odasi, String> oda_rengi;
    @FXML
    private TableColumn<Yatak_odasi, Integer> yatak_sayisi;
    @FXML
    private TableColumn<Yatak_odasi, Integer> kisi_sayisi;
    @FXML
    private TableColumn<Yatak_odasi, String> hali_rengi;
    
  
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
            Logger.getLogger(Yatak_odasiController.class.getName()).log(Level.SEVERE, null, ex);
        }
            oda_no.setCellValueFactory(new PropertyValueFactory<Yatak_odasi,Integer>("oda_no"));
            oda_tip.setCellValueFactory(new PropertyValueFactory<Yatak_odasi,String>("oda_tip"));
            oda_rengi.setCellValueFactory(new PropertyValueFactory<Yatak_odasi,String>("rengi"));
            yatak_sayisi.setCellValueFactory(new PropertyValueFactory<Yatak_odasi,Integer>("yatak_sayisi"));
            kisi_sayisi.setCellValueFactory(new PropertyValueFactory<Yatak_odasi,Integer>("kisi_sayisi"));
            hali_rengi.setCellValueFactory(new PropertyValueFactory<Yatak_odasi,String>("hali_rengi"));
        
            
            yataktable.setItems(yataklist);    
    }    
    ObservableList<Yatak_odasi> yataklist = FXCollections.observableArrayList();
    Dosya_islemleri txt = new Dosya_islemleri();
    List<String> liste = new ArrayList<>();

    public void Oku() throws IOException {
        liste.clear();
        yataklist.clear();
        txt.TxtReader("yatakodasi.txt", liste);

        Yatak_odasi tmp;
        for (int i = 0; i < txt.Length("yatakodasi.txt"); i++) {
            tmp = new Yatak_odasi();
            tmp.setOda_no(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("@") + 1, liste.get(i).indexOf("#"))));
            tmp.setOda_tip(liste.get(i).substring(liste.get(i).indexOf("#") + 1, liste.get(i).indexOf("$")));
            tmp.setRengi(liste.get(i).substring(liste.get(i).indexOf("$") + 1, liste.get(i).indexOf("%")));
            tmp.setYatak_sayisi(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("%") + 1, liste.get(i).indexOf("^"))));
            tmp.setKisi_sayisi(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("^") + 1, liste.get(i).indexOf("&"))));
            tmp.setHali_rengi(liste.get(i).substring(liste.get(i).indexOf("&") + 1, liste.get(i).indexOf("*")));

            yataklist.add(tmp);
        }
    }

    @Override
    public void ekle() {
        
        if ((T1.getText().length() == 0) || T2.getText().length() == 0 || T3.getText().length() == 0 || T4.getText().length() == 0
                || T5.getText().length() == 0 || T6.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Bir Alani booooooos birktiniz");
        } else {
           yataklist.add(getData());
            T1.clear();
            T2.clear();
            T3.clear();
            T4.clear();
            T5.clear();
            T6.clear();
         
            try {
                txt.addLine("yatakodasi.txt", yataklist.get(yataklist.size() - 1).toString(), true);
            } catch (IOException ex) {
                Logger.getLogger(Yatak_odasiController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
    }
    public Yatak_odasi getData() {
        int oda_no=Integer.parseInt(T1.getText());
        String oda_tip=T2.getText();
        String oda_rengi=T3.getText();
        int yatak_sayisi=Integer.parseInt(T4.getText());
        int kisi_sayisi=Integer.parseInt(T5.getText());
        String hali_rengi=T6.getText();
        
        return new Yatak_odasi(yatak_sayisi, kisi_sayisi, hali_rengi, oda_no, oda_tip, oda_rengi);
    }
    int index;
    @Override
    public void getSelected() {
         index = yataktable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        T1.setText( oda_no.getCellData(index).toString());
        T2.setText(oda_tip.getCellData(index));
        T3.setText(oda_rengi.getCellData(index));
        T4.setText(yatak_sayisi.getCellData(index).toString());
        T5.setText(kisi_sayisi.getCellData(index).toString());
        T6.setText(hali_rengi.getCellData(index)); 
        
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
            yataklist.set(index, getData());
            T1.clear();
            T2.clear();
            T3.clear();
            T4.clear();
            T5.clear();
            T6.clear();
         
            for (int i = 0; i < yataklist.size(); i++) {
                try {
                    if (i == 0) {
                        txt.addLine("yatakodasi.txt", yataklist.get(i).toString(), false);

                    } else {
                        txt.addLine("yatakodasi.txt", yataklist.get(i).toString(), true);

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Yatak_odasiController.class.getName()).log(Level.SEVERE, null, ex);
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
            yataktable.getItems().remove(index);
            index = -1;
            T1.clear();
            T2.clear();
            T3.clear();
            T4.clear();
            T5.clear();
            T6.clear();
         
            for (int i = 0; i < yataklist.size(); i++) {
                try {
                    if (i == 0) {
                        txt.addLine("yatakodasi.txt", yataklist.get(i).toString(), false);

                    } else {
                        txt.addLine("yatakodasi.txt", yataklist.get(i).toString(), true);

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Yatak_odasiController.class.getName()).log(Level.SEVERE, null, ex);
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
                    yataktable.setItems(yataklist);
                    return;
                }//eger bos ise

                //degilse?
                ObservableList<Yatak_odasi> items = FXCollections.observableArrayList();
                ObservableList<TableColumn<Yatak_odasi, ?>> column = yataktable.getColumns();

                for (int row = 0; row < yataklist.size(); row++) {
                    for (int col = 0; col < column.size(); col++) {
                        TableColumn colVar = column.get(col);
                        String celValue = colVar.getCellData(yataklist.get(row)).toString();
                        celValue = celValue.toLowerCase();

                        if (celValue.contains(search.getText().toLowerCase()) && celValue.startsWith(search.getText().toLowerCase())) {
                            items.add(yataklist.get(row));
                            break;
                        }
                    }
                }
                yataktable.setItems(items);
            }
        });
    }
   
    @FXML
    private void Back(ActionEvent event) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("Odalar.fxml"));
            Scene tableVView = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableVView);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(Yatak_odasiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}
