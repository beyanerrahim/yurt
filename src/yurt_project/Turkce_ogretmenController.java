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
public class Turkce_ogretmenController implements Initializable,controller {

    @FXML
    TableView<Turkce_ogretmen>   ttable;
    @FXML
    TableColumn<Turkce_ogretmen, Integer> id;
    @FXML
    TableColumn<Turkce_ogretmen, String> ad;
    @FXML
    TableColumn<Turkce_ogretmen, String> tel;
    @FXML
    TableColumn<Turkce_ogretmen, Integer> yil;
    @FXML
    TableColumn<Turkce_ogretmen, String> uzmanlik;
    @FXML
    TableColumn<Turkce_ogretmen, String> milli;
    
   
    @FXML
    TextField idT;
    @FXML
    TextField adT;
    @FXML
    TextField telT;
    @FXML
    TextField yilT;
    @FXML
    TextField uzmanlikT;
    @FXML
    TextField milliT;
    
    @FXML
    TextField search;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            Oku();
        } catch (IOException ex) {
            Logger.getLogger(Turkce_ogretmenController.class.getName()).log(Level.SEVERE, null, ex);
        }
            id.setCellValueFactory(new PropertyValueFactory<Turkce_ogretmen,Integer>("id"));
            ad.setCellValueFactory(new PropertyValueFactory<Turkce_ogretmen,String>("ad_soyad"));
            tel.setCellValueFactory(new PropertyValueFactory<Turkce_ogretmen,String>("tel"));
            yil.setCellValueFactory(new PropertyValueFactory<Turkce_ogretmen,Integer>("mezuniyet_yili"));
            uzmanlik.setCellValueFactory(new PropertyValueFactory<Turkce_ogretmen,String>("uzmanlik"));
            milli.setCellValueFactory(new PropertyValueFactory<Turkce_ogretmen,String>("milliyet"));

            ttable.setItems(tlist);
        
    }    
    ObservableList<Turkce_ogretmen> tlist = FXCollections.observableArrayList();
    Dosya_islemleri txt = new Dosya_islemleri();
    List<String> liste = new ArrayList<>();

    public void Oku() throws IOException {
        liste.clear();
        tlist.clear();
        txt.TxtReader("turkceogretmen.txt", liste);

        Turkce_ogretmen tmp;
        for (int i = 0; i < txt.Length("turkceogretmen.txt"); i++) {

            tmp = new Turkce_ogretmen();
            tmp.setId(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("@") + 1, liste.get(i).indexOf("#"))));
            tmp.setAd_soyad(liste.get(i).substring(liste.get(i).indexOf("#") + 1, liste.get(i).indexOf("$")));
            tmp.setTel(liste.get(i).substring(liste.get(i).indexOf("$") + 1, liste.get(i).indexOf("%")));
            tmp.setMezuniyet_yili(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("%") + 1, liste.get(i).indexOf("^"))));
            tmp.setUzmanlik(liste.get(i).substring(liste.get(i).indexOf("^") + 1, liste.get(i).indexOf("&")));
            tmp.setMilliyet(liste.get(i).substring(liste.get(i).indexOf("&") + 1, liste.get(i).indexOf("*")));

            tlist.add(tmp);
        }
    }

    @Override
    public void ekle() {
       
         if ((idT.getText().length() == 0) || adT.getText().length() == 0 || telT.getText().length() == 0 || yilT.getText().length() == 0
                || uzmanlikT.getText().length() == 0 || milliT.getText().length() == 0 ) {
            JOptionPane.showMessageDialog(null, "Bir Alani booooooos birktiniz");
        } else {
            tlist.add(getData());
            idT.clear();
            adT.clear();
            telT.clear();
            yilT.clear();
            uzmanlikT.clear();
            milliT.clear();
     
            try {
                txt.addLine("turkceogretmen.txt", tlist.get(tlist.size() - 1).toString(), true);
            } catch (IOException ex) {
                Logger.getLogger(Turkce_ogretmenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

       public Turkce_ogretmen getData() {
        int id=Integer.parseInt(idT.getText());
        String ad=adT.getText();
        String tel=telT.getText();
        int yili=Integer.parseInt(yilT.getText());
        String uzman=uzmanlikT.getText();
        String mil=milliT.getText();        
        
        return new Turkce_ogretmen(mil,id, ad, tel,yili,uzman) ;
    }
     int index;
    @Override
    public void getSelected() {
         index = ttable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        idT.setText(id.getCellData(index).toString());
        adT.setText(ad.getCellData(index));
        telT.setText(tel.getCellData(index));
        yilT.setText(yil.getCellData(index).toString());
        uzmanlikT.setText(uzmanlik.getCellData(index));
        milliT.setText(milli.getCellData(index));
    }

    @Override
    public void guncelle() {
        if ((idT.getText().length() == 0) || adT.getText().length() == 0 || telT.getText().length() == 0 || yilT.getText().length() == 0
                || uzmanlikT.getText().length() == 0 || milliT.getText().length() == 0 ) {
            JOptionPane.showMessageDialog(null, "GUNCELLENECEK INDEXI SECMEDINIZ");
        } else {
           tlist.set(index, getData());
            idT.clear();
            adT.clear();
            telT.clear();
            yilT.clear();
            uzmanlikT.clear();
            milliT.clear();
        
             for (int i = 0; i < tlist.size(); i++) {
                try {
                    if (i == 0) {
                        txt.addLine("turkceogretmen.txt", tlist.get(i).toString(), false);

                    } else {
                        txt.addLine("turkceogretmen.txt", tlist.get(i).toString(), true);

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Turkce_ogretmenController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void sil() {
        if ((idT.getText().length() == 0) || adT.getText().length() == 0 || telT.getText().length() == 0 || yilT.getText().length() == 0
                || uzmanlikT.getText().length() == 0 || milliT.getText().length() == 0 ) {
            JOptionPane.showMessageDialog(null, "SILENECEK INDEXI SECMEDINIZ");
        } else {
            ttable.getItems().remove(index);
            index = -1;
            idT.clear();
            adT.clear();
            telT.clear();
            yilT.clear();
            uzmanlikT.clear();
            milliT.clear();
        
             for (int i = 0; i < tlist.size(); i++) {
                try {
                    if (i == 0) {
                        txt.addLine("turkceogretmen.txt", tlist.get(i).toString(), false);

                    } else {
                        txt.addLine("turkceogretmen.txt", tlist.get(i).toString(), true);

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Turkce_ogretmenController.class.getName()).log(Level.SEVERE, null, ex);
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
                    ttable.setItems(tlist);
                    return;
                }//eger bos ise

                //degilse?
                ObservableList<Turkce_ogretmen> items = FXCollections.observableArrayList();
                ObservableList<TableColumn<Turkce_ogretmen, ?>> column = ttable.getColumns();

                for (int row = 0; row < tlist.size(); row++) {
                    for (int col = 0; col < column.size(); col++) {
                        TableColumn colVar = column.get(col);
                        String celValue = colVar.getCellData(tlist.get(row)).toString();
                        celValue = celValue.toLowerCase();

                        if (celValue.contains(search.getText().toLowerCase()) && celValue.startsWith(search.getText().toLowerCase())) {
                            items.add(tlist.get(row));
                            break;
                        }
                    }

                }
                ttable.setItems(items);

            }
        });
    }
     @FXML
    private void Back5(ActionEvent event) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("Ogretmen.fxml"));
            Scene tableVView = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableVView);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(Kuran_ogretmenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
