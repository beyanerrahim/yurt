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
public class Lise_ogrenciController  implements Initializable,controller {

    @FXML
    private TableColumn<Lise_ogrenci, Integer> id;
    @FXML
    private TableView<Lise_ogrenci> table;
    @FXML
    private TableColumn<Lise_ogrenci, String> ad_soyad;
    @FXML
    private TableColumn<Lise_ogrenci, String> tc;
    @FXML
    private TableColumn<Lise_ogrenci, Integer> yas;
    @FXML
    private TableColumn<Lise_ogrenci, String> tel;
    @FXML
    private TableColumn<Lise_ogrenci, String> email;
    @FXML
    private TableColumn<Lise_ogrenci, Integer> ucret;
    @FXML
    private TableColumn<Lise_ogrenci, String> lise_adi;

    @FXML
    private TextField id1;
    @FXML
    private TextField ad_soyad1;
    @FXML
    private TextField tc1;
    @FXML
    private TextField yas1;
    @FXML
    private TextField tel1;
    @FXML
    private TextField email1;
    @FXML
    private TextField lise_adi1;
    @FXML
    private TextField ucret1;
    
    @FXML
    private TextField search;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            Oku();
        } catch (IOException ex) {
            Logger.getLogger(Lise_ogrenciController.class.getName()).log(Level.SEVERE, null, ex);
        }
            id.setCellValueFactory(new PropertyValueFactory<Lise_ogrenci,Integer>("id"));
            ad_soyad.setCellValueFactory(new PropertyValueFactory<Lise_ogrenci,String>("ad_soyad"));
            tc.setCellValueFactory(new PropertyValueFactory<Lise_ogrenci,String>("tc"));
            yas.setCellValueFactory(new PropertyValueFactory<Lise_ogrenci,Integer>("yas"));
            tel.setCellValueFactory(new PropertyValueFactory<Lise_ogrenci,String>("tel"));
            email.setCellValueFactory(new PropertyValueFactory<Lise_ogrenci,String>("email"));
            ucret.setCellValueFactory(new PropertyValueFactory<Lise_ogrenci,Integer>("ucret"));
            lise_adi.setCellValueFactory(new PropertyValueFactory<Lise_ogrenci,String>("lise_adi"));
            
            table.setItems(liselist);
    }
    
    ObservableList<Lise_ogrenci> liselist = FXCollections.observableArrayList();
    Dosya_islemleri txt = new Dosya_islemleri();
    List<String> liste = new ArrayList<>();

    public void Oku() throws IOException {
        liste.clear();
        liselist.clear();
        txt.TxtReader("Lise.txt", liste);

        Lise_ogrenci tmp;
        for (int i = 0; i < txt.Length("Lise.txt"); i++) {

            tmp = new Lise_ogrenci();
            tmp.setId(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("@") + 1, liste.get(i).indexOf("#"))));
            tmp.setYas(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("#") + 1, liste.get(i).indexOf("$"))));
            tmp.setAd_soyad(liste.get(i).substring(liste.get(i).indexOf("$") + 1, liste.get(i).indexOf("%")));
            tmp.setUcret(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("%") + 1, liste.get(i).indexOf("^"))));
            tmp.setTel(liste.get(i).substring(liste.get(i).indexOf("^") + 1, liste.get(i).indexOf("&")));
            tmp.setTc(liste.get(i).substring(liste.get(i).indexOf("&") + 1, liste.get(i).indexOf("*")));
            tmp.setLise_adi(liste.get(i).substring(liste.get(i).indexOf("*") + 1, liste.get(i).indexOf("@@")));
            tmp.setEmail(liste.get(i).substring(liste.get(i).indexOf("@@") + 2, liste.get(i).indexOf("##")));

            liselist.add(tmp);
        }
    }
    
   
    @Override
    public void ekle() {
       
        if ((id1.getText().length() == 0) || ad_soyad1.getText().length() == 0 || tc1.getText().length() == 0 || yas1.getText().length() == 0
                || tel1.getText().length() == 0 || email1.getText().length() == 0 || ucret1.getText().length() == 0 || lise_adi1.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Bir Alani booooooos birktiniz");
        } else {
            liselist.add(getData());
            id1.clear();
            ad_soyad1.clear();
            tc1.clear();
            yas1.clear();
            tel1.clear();
            email1.clear();
            ucret1.clear();
            lise_adi1.clear();
            try {
                txt.addLine("Lise.txt", liselist.get(liselist.size() - 1).toString(), true);
            } catch (IOException ex) {
                Logger.getLogger(Lise_ogrenciController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }
  
    public Lise_ogrenci getData() {
        int id=Integer.parseInt(id1.getText());
        String ad=ad_soyad1.getText();
        String tc=tc1.getText();
        int yas=Integer.parseInt(yas1.getText());
        String tel=tel1.getText();
        String email=email1.getText();        
        int ucret=Integer.parseInt(ucret1.getText());
        String lise_ad=lise_adi1.getText();
        
        return new Lise_ogrenci(  id, ad,  tc,  yas, tel, email, ucret,lise_ad) ;
    }
   int index;
   
   
    @Override
    public void getSelected() {
         index = table.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        id1.setText(id.getCellData(index).toString());
        ad_soyad1.setText(ad_soyad.getCellData(index));
        tc1.setText(tc.getCellData(index));
        yas1.setText(yas.getCellData(index).toString());
        tel1.setText(tel.getCellData(index));
        email1.setText(email.getCellData(index));
        ucret1.setText(ucret.getCellData(index).toString());
        lise_adi1.setText(lise_adi.getCellData(index));      
    }
    
    
    @Override
    public void sil() {
        if (index <= -1) {
            return;
        }
       if ((id1.getText().length() == 0) || ad_soyad1.getText().length() == 0 || tc1.getText().length() == 0 || yas1.getText().length() == 0
                || tel1.getText().length() == 0 || email1.getText().length() == 0 || ucret1.getText().length() == 0 || lise_adi1.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "SILENECEK INDEXI SECMEDINIZ");
        } else {
            table.getItems().remove(index);
            index = -1;
            id1.clear();
            ad_soyad1.clear();
            tc1.clear();
            yas1.clear();
            tel1.clear();
            email1.clear();
            ucret1.clear();       
            lise_adi1.clear();
        
            for (int i = 0; i < liselist.size(); i++) {
                try {
                    if (i == 0) {
                        txt.addLine("Lise.txt", liselist.get(i).toString(), false);

                    } else {
                        txt.addLine("Lise.txt", liselist.get(i).toString(), true);

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Lise_ogrenciController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }  
    }
    
    @Override
    public void guncelle() {
         if (index <= -1) {
            return;
        }
       if ((id1.getText().length() == 0) || ad_soyad1.getText().length() == 0 || tc1.getText().length() == 0 || yas1.getText().length() == 0
                || tel1.getText().length() == 0 || email1.getText().length() == 0 || ucret1.getText().length() == 0 || lise_adi1.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "GUNCELLENECEK INDEXI SECMEDINIZ");
        } else {
            liselist.set(index, getData());
            id1.clear();
            ad_soyad1.clear();
            tc1.clear();
            yas1.clear();
            tel1.clear();
            email1.clear();
            ucret1.clear();       
            lise_adi1.clear();
        
            for (int i = 0; i < liselist.size(); i++) {
                try {
                    if (i == 0) {
                        txt.addLine("Lise.txt", liselist.get(i).toString(), false);

                    } else {
                        txt.addLine("Lise.txt", liselist.get(i).toString(), true);

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Lise_ogrenciController.class.getName()).log(Level.SEVERE, null, ex);
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
                    table.setItems(liselist);
                    return;
                }//eger bos ise

                //degilse?
                ObservableList<Lise_ogrenci> items = FXCollections.observableArrayList();
                ObservableList<TableColumn<Lise_ogrenci, ?>> column = table.getColumns();

                for (int row = 0; row < liselist.size(); row++) {
                    for (int col = 0; col < column.size(); col++) {
                        TableColumn colVar = column.get(col);
                        String celValue = colVar.getCellData(liselist.get(row)).toString();
                        celValue = celValue.toLowerCase();

                        if (celValue.contains(search.getText().toLowerCase()) && celValue.startsWith(search.getText().toLowerCase())) {
                            items.add(liselist.get(row));
                            break;
                        }
                    }

                }
                table.setItems(items);

            }
        });
        
    }

    @FXML
    private void Back(ActionEvent event) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("Ogrenci.fxml"));
            Scene tableVView = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableVView);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(OgrenciController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

    


