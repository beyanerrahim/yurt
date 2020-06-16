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
public class Univer_ogrenciController implements Initializable,controller {

   
    @FXML
    TableView<Univer_ogrenci> univertable;
    @FXML
    TableColumn<Univer_ogrenci, Integer> u_id;
    @FXML
    TableColumn<Univer_ogrenci, String> uad_soyad;
    @FXML
    TableColumn<Univer_ogrenci, String> u_tc;
    @FXML
    TableColumn<Univer_ogrenci, Integer> u_yas;
    @FXML
    TableColumn<Univer_ogrenci, String> u_tel;
    @FXML
    TableColumn<Univer_ogrenci, String> u_email;
    @FXML
    TableColumn<Univer_ogrenci, Integer> u_ucret;
    @FXML
    TableColumn<Univer_ogrenci, String> ufakulte_adi;
   @FXML
    TableColumn<Univer_ogrenci, String> ubolum_adi;
   
    @FXML
    TextField idU;
    @FXML
    TextField adU;
    @FXML
    TextField tcU;
    @FXML
    TextField yasU;
    @FXML
    TextField telU;
    @FXML
    TextField emailU;
    @FXML
    TextField ucretU;
    @FXML
    TextField fak_adU;
    @FXML
    TextField bolum_adU;
    
    @FXML
    TextField search;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        try {
            Oku();
        } catch (IOException ex) {
            Logger.getLogger(Univer_ogrenciController.class.getName()).log(Level.SEVERE, null, ex);
        }
            u_id.setCellValueFactory(new PropertyValueFactory<Univer_ogrenci,Integer>("id"));
            uad_soyad.setCellValueFactory(new PropertyValueFactory<Univer_ogrenci,String>("ad_soyad"));
            u_tc.setCellValueFactory(new PropertyValueFactory<Univer_ogrenci,String>("tc"));
            u_yas.setCellValueFactory(new PropertyValueFactory<Univer_ogrenci,Integer>("yas"));
            u_tel.setCellValueFactory(new PropertyValueFactory<Univer_ogrenci,String>("tel"));
            u_email.setCellValueFactory(new PropertyValueFactory<Univer_ogrenci,String>("email"));
            u_ucret.setCellValueFactory(new PropertyValueFactory<Univer_ogrenci,Integer>("ucret"));
            ufakulte_adi.setCellValueFactory(new PropertyValueFactory<Univer_ogrenci,String>("fakulte_adi"));
            ubolum_adi.setCellValueFactory(new PropertyValueFactory<Univer_ogrenci,String>("bolum_adi"));

            univertable.setItems(univerlist);
        
    }    

    ObservableList<Univer_ogrenci> univerlist = FXCollections.observableArrayList();
    Dosya_islemleri txt = new Dosya_islemleri();
    List<String> liste = new ArrayList<>();

    public void Oku() throws IOException {
        liste.clear();
        univerlist.clear();
        txt.TxtReader("universite.txt", liste);

        Univer_ogrenci tmp;
        for (int i = 0; i < txt.Length("universite.txt"); i++) {

            tmp = new Univer_ogrenci();
            tmp.setId(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("@") + 1, liste.get(i).indexOf("#"))));
            tmp.setYas(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("#") + 1, liste.get(i).indexOf("$"))));
            tmp.setAd_soyad(liste.get(i).substring(liste.get(i).indexOf("$") + 1, liste.get(i).indexOf("%")));
            tmp.setUcret(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("%") + 1, liste.get(i).indexOf("^"))));
            tmp.setTel(liste.get(i).substring(liste.get(i).indexOf("^") + 1, liste.get(i).indexOf("&")));
            tmp.setTc(liste.get(i).substring(liste.get(i).indexOf("&") + 1, liste.get(i).indexOf("*")));
            tmp.setFakulte_adi(liste.get(i).substring(liste.get(i).indexOf("*") + 1, liste.get(i).indexOf("@@")));
            tmp.setEmail(liste.get(i).substring(liste.get(i).indexOf("@@") + 2, liste.get(i).indexOf("##")));
            tmp.setBolum_adi(liste.get(i).substring(liste.get(i).indexOf("##") + 2, liste.get(i).indexOf("$$")));

            univerlist.add(tmp);
        }
    }
    
    @Override
    public void ekle() {
        
      
        if ((idU.getText().length() == 0) || adU.getText().length() == 0 || tcU.getText().length() == 0 || yasU.getText().length() == 0
                || telU.getText().length() == 0 || emailU.getText().length() == 0 || ucretU.getText().length() == 0 || fak_adU.getText().length() == 0 || bolum_adU.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Bir Alani booooooos birktiniz");
        } else {
            univerlist.add(getData());
            idU.clear();
            adU.clear();
            tcU.clear();
            yasU.clear();
            telU.clear();
            emailU.clear();
            ucretU.clear();
            fak_adU.clear();
            bolum_adU.clear();

        
            try {
                txt.addLine("universite.txt", univerlist.get(univerlist.size() - 1).toString(), true);
            } catch (IOException ex) {
                Logger.getLogger(Univer_ogrenciController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
     public Univer_ogrenci getData() {
        int id=Integer.parseInt(idU.getText());
        String ad=adU.getText();
        String tc=tcU.getText();
        int yas=Integer.parseInt(yasU.getText());
        String tel=telU.getText();
        String email=emailU.getText();        
        int ucret=Integer.parseInt(ucretU.getText());
        String fakulte_adi=fak_adU.getText();
        String bolum_adi=bolum_adU.getText();

        return new Univer_ogrenci(fakulte_adi,bolum_adi ,id, ad,  tc,  yas, tel, email, ucret) ;
    }
     int index;
    @Override
    public void getSelected() {
         index = univertable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        idU.setText(u_id.getCellData(index).toString());
        adU.setText(uad_soyad.getCellData(index));
        tcU.setText(u_tc.getCellData(index));
        yasU.setText(u_yas.getCellData(index).toString());
        telU.setText(u_tel.getCellData(index));
        emailU.setText(u_email.getCellData(index));
        ucretU.setText(u_ucret.getCellData(index).toString());
        fak_adU.setText(ufakulte_adi.getCellData(index));
        bolum_adU.setText(ubolum_adi.getCellData(index));
        
    }
    @Override
    public void guncelle() {
        if ((idU.getText().length() == 0) || adU.getText().length() == 0 || tcU.getText().length() == 0 || yasU.getText().length() == 0
                || telU.getText().length() == 0 || emailU.getText().length() == 0 || ucretU.getText().length() == 0 || fak_adU.getText().length() == 0 || bolum_adU.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "GUNCELLENECEK INDEXI SECMEDINIZ");
        } else {
           univerlist.set(index, getData());
            idU.clear();
            adU.clear();
            tcU.clear();
            yasU.clear();
            telU.clear();
            emailU.clear();
            ucretU.clear();
            fak_adU.clear();
            bolum_adU.clear();
             for (int i = 0; i < univerlist.size(); i++) {
                try {
                    if (i == 0) {
                        txt.addLine("universite.txt", univerlist.get(i).toString(), false);

                    } else {
                        txt.addLine("universite.txt", univerlist.get(i).toString(), true);

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Univer_ogrenciController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    

    @Override
    public void sil() {
       
        if ((idU.getText().length() == 0) || adU.getText().length() == 0 || tcU.getText().length() == 0 || yasU.getText().length() == 0
                || telU.getText().length() == 0 || emailU.getText().length() == 0 || ucretU.getText().length() == 0 || fak_adU.getText().length() == 0 || bolum_adU.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "SILENECEK INDEXI SECMEDINIZ");
        } else {
            univertable.getItems().remove(index);
            index = -1;
            idU.clear();
            adU.clear();
            tcU.clear();
            yasU.clear();
            telU.clear();
            emailU.clear();
            ucretU.clear();
            fak_adU.clear();
            bolum_adU.clear();
             for (int i = 0; i < univerlist.size(); i++) {
                try {
                    if (i == 0) {
                        txt.addLine("universite.txt", univerlist.get(i).toString(), false);

                    } else {
                        txt.addLine("universite.txt", univerlist.get(i).toString(), true);

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Univer_ogrenciController.class.getName()).log(Level.SEVERE, null, ex);
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
                    univertable.setItems(univerlist);
                    return;
                }//eger bos ise

                //degilse?
                ObservableList<Univer_ogrenci> items = FXCollections.observableArrayList();
                ObservableList<TableColumn<Univer_ogrenci, ?>> column = univertable.getColumns();

                for (int row = 0; row < univerlist.size(); row++) {
                    for (int col = 0; col < column.size(); col++) {
                        TableColumn colVar = column.get(col);
                        String celValue = colVar.getCellData(univerlist.get(row)).toString();
                        celValue = celValue.toLowerCase();

                        if (celValue.contains(search.getText().toLowerCase()) && celValue.startsWith(search.getText().toLowerCase())) {
                            items.add(univerlist.get(row));
                            break;
                        }
                    }

                }
                univertable.setItems(items);

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
            Logger.getLogger(Univer_ogrenciController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
