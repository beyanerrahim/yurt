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
public class Turkce_kursuController implements Initializable,controller {

    @FXML
    TableView<Turkce_kursu> turkcetable;

    @FXML
    TableColumn<Turkce_kursu, Integer> id;
    @FXML
    TableColumn<Turkce_kursu, String> ad;
    @FXML
    TableColumn<Turkce_kursu, String> ogr_sayisi;
    @FXML
    TableColumn<Turkce_kursu, String> tarih;
    @FXML
    TableColumn<Turkce_kursu, String> seviye;
    @FXML
    TableColumn<Turkce_kursu, String> kitap_adi;
    
    @FXML
    TextField id1;
    @FXML
    TextField ad1;
    @FXML
    TextField ogr_sayisi1;
    @FXML
    TextField tarih1;
    @FXML
    TextField seviye1;    
    @FXML
    TextField kitap_adi1;
    
    @FXML
    TextField search;
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Oku();
        } catch (IOException ex) {
            Logger.getLogger(Turkce_kursuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        id.setCellValueFactory(new PropertyValueFactory<Turkce_kursu, Integer>("id"));
        ad.setCellValueFactory(new PropertyValueFactory<Turkce_kursu, String>("course_adi"));
        ogr_sayisi.setCellValueFactory(new PropertyValueFactory<Turkce_kursu, String>("ogrenci_sayisi"));
        tarih.setCellValueFactory(new PropertyValueFactory<Turkce_kursu, String>("tarih"));
        seviye.setCellValueFactory(new PropertyValueFactory<Turkce_kursu, String>("seviye"));
        kitap_adi.setCellValueFactory(new PropertyValueFactory<Turkce_kursu, String>("kitap_adi"));


        turkcetable.setItems(turkcelist);       
    }    
    ObservableList<Turkce_kursu> turkcelist = FXCollections.observableArrayList();
    Dosya_islemleri txt = new Dosya_islemleri();
    List<String> liste = new ArrayList<>();

    public void Oku() throws IOException {
        liste.clear();
        turkcelist.clear();
        txt.TxtReader("turkce.txt", liste);

        Turkce_kursu tmp;
        for (int i = 0; i < txt.Length("turkce.txt"); i++) {

            tmp = new Turkce_kursu();
            tmp.setId(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("@") + 1, liste.get(i).indexOf("#"))));
            tmp.setCourse_adi(liste.get(i).substring(liste.get(i).indexOf("#") + 1, liste.get(i).indexOf("$")));
            tmp.setOgrenci_sayisi(liste.get(i).substring(liste.get(i).indexOf("$") + 1, liste.get(i).indexOf("%")));
            tmp.setTarih(liste.get(i).substring(liste.get(i).indexOf("%") + 1, liste.get(i).indexOf("^")));
            tmp.setSeviye(liste.get(i).substring(liste.get(i).indexOf("^") + 1, liste.get(i).indexOf("&")));
            tmp.setKitap_adi(liste.get(i).substring(liste.get(i).indexOf("&") + 1, liste.get(i).indexOf("*")));

            turkcelist.add(tmp);
        }
    }

    @Override
    public void ekle() {       
        if ((id1.getText().length() == 0) || ad1.getText().length() == 0 || ogr_sayisi1.getText().length() == 0 || tarih1.getText().length() == 0
                || seviye1.getText().length() == 0 || kitap_adi1.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Bir Alani booooooos birktiniz");
        } else {
            turkcelist.add(getData());
            id1.clear();
            ad1.clear();
            ogr_sayisi1.clear();
            tarih1.clear();
            seviye1.clear();
            kitap_adi1.clear();
            try {
                txt.addLine("turkce.txt", turkcelist.get(turkcelist.size() - 1).toString(), true);
            } catch (IOException ex) {
                Logger.getLogger(Turkce_kursuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
    }
     public Turkce_kursu getData() {
        int id = Integer.parseInt(id1.getText());
        String ad =ad1.getText();
        String ogr_say = ogr_sayisi1.getText();
        String tarih = tarih1.getText();
        String seviye = seviye1.getText();
        String kitap = kitap_adi1.getText();

        return new Turkce_kursu(seviye,kitap,id, ad, ogr_say, tarih);
    }
     int index;
    @Override
    public void getSelected() {
        index = turkcetable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        id1.setText(id.getCellData(index).toString());
        ad1.setText(ad.getCellData(index));
        ogr_sayisi1.setText(ogr_sayisi.getCellData(index));
        tarih1.setText(tarih.getCellData(index));
        seviye1.setText(seviye.getCellData(index));
        kitap_adi1.setText(kitap_adi.getCellData(index));
    }

    @Override
    public void guncelle() {
        
         if ((id1.getText().length() == 0) || ad1.getText().length() == 0 || ogr_sayisi1.getText().length() == 0 || tarih1.getText().length() == 0
                || seviye1.getText().length() == 0 || kitap_adi1.getText().length() == 0) {
            JOptionPane.showMessageDialog(null,"GUNCELLENECEK INDEXI SECMEDINIZ");
        } else {
            turkcelist.set(index, getData());
            id1.clear();
            ad1.clear();
            ogr_sayisi1.clear();
            tarih1.clear();
            seviye1.clear();
            kitap_adi1.clear();
        for (int i = 0; i < turkcelist.size(); i++) {
                try {
                    if (i == 0) {
                        txt.addLine("turkce.txt", turkcelist.get(i).toString(), false);

                    } else {

                        txt.addLine("turkce.txt", turkcelist.get(i).toString(), true);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Turkce_kursuController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
         }    
    }

    @Override
    public void sil() {
        if ((id1.getText().length() == 0) || ad1.getText().length() == 0 || ogr_sayisi1.getText().length() == 0 || tarih1.getText().length() == 0
                || seviye1.getText().length() == 0 || kitap_adi1.getText().length() == 0) {
            JOptionPane.showMessageDialog(null,"SILENECEK INDEXI SECMEDINIZ");
        } else {
            turkcetable.getItems().remove(index);
            index = -1;
            id1.clear();
            ad1.clear();
            ogr_sayisi1.clear();
            tarih1.clear();
            seviye1.clear();
            kitap_adi1.clear();
        for (int i = 0; i < turkcelist.size(); i++) {
                try {
                    if (i == 0) {
                        txt.addLine("turkce.txt", turkcelist.get(i).toString(), false);

                    } else {

                        txt.addLine("turkce.txt", turkcelist.get(i).toString(), true);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Turkce_kursuController.class.getName()).log(Level.SEVERE, null, ex);
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
                    turkcetable.setItems(turkcelist);
                    return;
                }//eger bos ise

                //degilse?
                ObservableList<Turkce_kursu> items = FXCollections.observableArrayList();
                ObservableList<TableColumn<Turkce_kursu, ?>> column = turkcetable.getColumns();

                for (int row = 0; row < turkcelist.size(); row++) {
                    for (int col = 0; col < column.size(); col++) {
                        TableColumn colVar = column.get(col);
                        String celValue = colVar.getCellData(turkcelist.get(row)).toString();
                        celValue = celValue.toLowerCase();

                        if (celValue.contains(search.getText().toLowerCase()) && celValue.startsWith(search.getText().toLowerCase())) {
                            items.add(turkcelist.get(row));
                            break;
                        }
                    }
                }
                turkcetable.setItems(items);
            }
        });     
        
    }
    @FXML
    private void Back(ActionEvent event) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("Course.fxml"));
            Scene tableVView = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableVView);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
}
