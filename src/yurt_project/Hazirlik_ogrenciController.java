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
public class Hazirlik_ogrenciController implements Initializable, controller {

    @FXML
    private TableColumn<Hazirlik_ogrenci, Integer> id;
    @FXML
    private TableView<Hazirlik_ogrenci> hazirliktable;
    @FXML
    private TableColumn<Hazirlik_ogrenci, String> ad_soyad;
    @FXML
    private TableColumn<Hazirlik_ogrenci, String> tc;
    @FXML
    private TableColumn<Hazirlik_ogrenci, Integer> yas;
    @FXML
    private TableColumn<Hazirlik_ogrenci, String> tel;
    @FXML
    private TableColumn<Hazirlik_ogrenci, String> email;
    @FXML
    private TableColumn<Hazirlik_ogrenci, Integer> ucret;
    @FXML
    private TableColumn<Hazirlik_ogrenci, String> dil_adi;

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
    private TextField dil_adi1;
    @FXML
    private TextField ucret1;

    @FXML
    private TextField search;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            Oku();
        } catch (IOException ex) {
            Logger.getLogger(Hazirlik_ogrenciController.class.getName()).log(Level.SEVERE, null, ex);
        }
        id.setCellValueFactory(new PropertyValueFactory<Hazirlik_ogrenci, Integer>("id"));
        ad_soyad.setCellValueFactory(new PropertyValueFactory<Hazirlik_ogrenci, String>("ad_soyad"));
        tc.setCellValueFactory(new PropertyValueFactory<Hazirlik_ogrenci, String>("tc"));
        yas.setCellValueFactory(new PropertyValueFactory<Hazirlik_ogrenci, Integer>("yas"));
        tel.setCellValueFactory(new PropertyValueFactory<Hazirlik_ogrenci, String>("tel"));
        email.setCellValueFactory(new PropertyValueFactory<Hazirlik_ogrenci, String>("email"));
        ucret.setCellValueFactory(new PropertyValueFactory<Hazirlik_ogrenci, Integer>("ucret"));
        dil_adi.setCellValueFactory(new PropertyValueFactory<Hazirlik_ogrenci, String>("dil_adi"));

        hazirliktable.setItems(hazirliklist);
    }

    ObservableList<Hazirlik_ogrenci> hazirliklist = FXCollections.observableArrayList();
    Dosya_islemleri txt = new Dosya_islemleri();
    List<String> liste = new ArrayList<>();

    public void Oku() throws IOException {
        liste.clear();
        hazirliklist.clear();
        txt.TxtReader("Hazirlik.txt", liste);

        Hazirlik_ogrenci tmp;
        for (int i = 0; i < txt.Length("Hazirlik.txt"); i++) {

            tmp = new Hazirlik_ogrenci();
            tmp.setId(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("@") + 1, liste.get(i).indexOf("#"))));
            tmp.setYas(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("#") + 1, liste.get(i).indexOf("$"))));
            tmp.setAd_soyad(liste.get(i).substring(liste.get(i).indexOf("$") + 1, liste.get(i).indexOf("%")));
            tmp.setUcret(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("%") + 1, liste.get(i).indexOf("^"))));
            tmp.setTel(liste.get(i).substring(liste.get(i).indexOf("^") + 1, liste.get(i).indexOf("&")));
            tmp.setTc(liste.get(i).substring(liste.get(i).indexOf("&") + 1, liste.get(i).indexOf("*")));
            tmp.setDil_adi(liste.get(i).substring(liste.get(i).indexOf("*") + 1, liste.get(i).indexOf("@@")));
            tmp.setEmail(liste.get(i).substring(liste.get(i).indexOf("@@") + 2, liste.get(i).indexOf("##")));

            hazirliklist.add(tmp);
        }
    }

    @Override
    public void ekle() {
        if ((id1.getText().length() == 0) || ad_soyad1.getText().length() == 0 || tc1.getText().length() == 0 || yas1.getText().length() == 0
                || tel1.getText().length() == 0 || email1.getText().length() == 0 || ucret1.getText().length() == 0 || dil_adi1.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Bir Alani booooooos birktiniz");
        } else {
            hazirliklist.add(getData());
            id1.clear();
            ad_soyad1.clear();
            tc1.clear();
            yas1.clear();
            tel1.clear();
            email1.clear();
            ucret1.clear();
            dil_adi1.clear();
            try {
                txt.addLine("Hazirlik.txt", hazirliklist.get(hazirliklist.size() - 1).toString(), true);
            } catch (IOException ex) {
                Logger.getLogger(Hazirlik_ogrenciController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Hazirlik_ogrenci getData() {
        int id = Integer.parseInt(id1.getText());
        String ad = ad_soyad1.getText();
        String tc = tc1.getText();
        int yas = Integer.parseInt(yas1.getText());
        String tel = tel1.getText();
        String email = email1.getText();
        int ucret = Integer.parseInt(ucret1.getText());
        String dil_ad = dil_adi1.getText();

        return new Hazirlik_ogrenci(dil_ad, id, ad, tc, yas, tel, email, ucret);
    }
    int index;

    @Override
    public void getSelected() {
        index = hazirliktable.getSelectionModel().getSelectedIndex();
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
        dil_adi1.setText(dil_adi.getCellData(index));
    }

    @Override
    public void guncelle() {
        if (index <= -1) {
            return;
        }
        if ((id1.getText().length() == 0) || ad_soyad1.getText().length() == 0 || tc1.getText().length() == 0 || yas1.getText().length() == 0
                || tel1.getText().length() == 0 || email1.getText().length() == 0 || ucret1.getText().length() == 0 || dil_adi1.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "GUNCELLENECEK INDEXI SECMEDINIZ");
        } else {
            hazirliklist.set(index, getData());
            id1.clear();
            ad_soyad1.clear();
            tc1.clear();
            yas1.clear();
            tel1.clear();
            email1.clear();
            ucret1.clear();
            dil_adi1.clear();

            for (int i = 0; i < hazirliklist.size(); i++) {
                try {
                    if (i == 0) {
                        txt.addLine("Hazirlik.txt", hazirliklist.get(i).toString(), false);

                    } else {
                        txt.addLine("Hazirlik.txt", hazirliklist.get(i).toString(), true);

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Hazirlik_ogrenciController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void sil() {
        if (index <= -1) {
            return;
        }
        if ((id1.getText().length() == 0) || ad_soyad1.getText().length() == 0 || tc1.getText().length() == 0 || yas1.getText().length() == 0
                || tel1.getText().length() == 0 || email1.getText().length() == 0 || ucret1.getText().length() == 0 || dil_adi1.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "SILENECEK INDEXI SECMEDINIZ");
        } else {
            hazirliktable.getItems().remove(index);
            index = -1;
            id1.clear();
            ad_soyad1.clear();
            tc1.clear();
            yas1.clear();
            tel1.clear();
            email1.clear();
            ucret1.clear();
            dil_adi1.clear();

            for (int i = 0; i < hazirliklist.size(); i++) {
                try {
                    if (i == 0) {
                        txt.addLine("Hazirlik.txt", hazirliklist.get(i).toString(), false);

                    } else {
                        txt.addLine("Hazirlik.txt", hazirliklist.get(i).toString(), true);

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Hazirlik_ogrenciController.class.getName()).log(Level.SEVERE, null, ex);
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
                    hazirliktable.setItems(hazirliklist);
                    return;
                }//eger bos ise

                //degilse?
                ObservableList<Hazirlik_ogrenci> items = FXCollections.observableArrayList();
                ObservableList<TableColumn<Hazirlik_ogrenci, ?>> column = hazirliktable.getColumns();

                for (int row = 0; row < hazirliklist.size(); row++) {
                    for (int col = 0; col < column.size(); col++) {
                        TableColumn colVar = column.get(col);
                        String celValue = colVar.getCellData(hazirliklist.get(row)).toString();
                        celValue = celValue.toLowerCase();

                        if (celValue.contains(search.getText().toLowerCase()) && celValue.startsWith(search.getText().toLowerCase())) {
                            items.add(hazirliklist.get(row));
                            break;
                        }
                    }

                }
                hazirliktable.setItems(items);

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
