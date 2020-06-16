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
public class Arabca_ogretmenController implements Initializable,controller {
     @FXML
    TableView<Arabca_ogretmen>   atable;
    @FXML
    TableColumn<Arabca_ogretmen, Integer> id;
    @FXML
    TableColumn<Arabca_ogretmen, String> ad;
    @FXML
    TableColumn<Arabca_ogretmen, String> tel;
    @FXML
    TableColumn<Arabca_ogretmen, Integer> yil;
    @FXML
    TableColumn<Arabca_ogretmen, String> uzmanlik;
    @FXML
    TableColumn<Arabca_ogretmen, String> ulke;
    @FXML
    TableColumn<Arabca_ogretmen, String> milli;
   
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
    TextField ulkeT;
    @FXML
    TextField milliT;
    
    @FXML
    TextField search;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Oku();
        } catch (IOException ex) {
            Logger.getLogger(Arabca_ogretmenController.class.getName()).log(Level.SEVERE, null, ex);
        }
            id.setCellValueFactory(new PropertyValueFactory<Arabca_ogretmen,Integer>("id"));
            ad.setCellValueFactory(new PropertyValueFactory<Arabca_ogretmen,String>("ad_soyad"));
            tel.setCellValueFactory(new PropertyValueFactory<Arabca_ogretmen,String>("tel"));
            yil.setCellValueFactory(new PropertyValueFactory<Arabca_ogretmen,Integer>("mezuniyet_yili"));
            uzmanlik.setCellValueFactory(new PropertyValueFactory<Arabca_ogretmen,String>("uzmanlik"));
            ulke.setCellValueFactory(new PropertyValueFactory<Arabca_ogretmen,String>("mezun_ulke"));
            milli.setCellValueFactory(new PropertyValueFactory<Arabca_ogretmen,String>("milliyet"));

            atable.setItems(alist);
    }    
    ObservableList<Arabca_ogretmen> alist = FXCollections.observableArrayList();
    Dosya_islemleri txt = new Dosya_islemleri();
    List<String> liste = new ArrayList<>();

    public void Oku() throws IOException {
        liste.clear();
        alist.clear();
        txt.TxtReader("arapcaogretmen.txt", liste);

        Arabca_ogretmen tmp;
        for (int i = 0; i < txt.Length("arapcaogretmen.txt"); i++) {

            tmp = new Arabca_ogretmen();
            tmp.setId(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("@") + 1, liste.get(i).indexOf("#"))));
            tmp.setAd_soyad(liste.get(i).substring(liste.get(i).indexOf("#") + 1, liste.get(i).indexOf("$")));
            tmp.setTel(liste.get(i).substring(liste.get(i).indexOf("$") + 1, liste.get(i).indexOf("%")));
            tmp.setMezuniyet_yili(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("%") + 1, liste.get(i).indexOf("^"))));
            tmp.setUzmanlik(liste.get(i).substring(liste.get(i).indexOf("^") + 1, liste.get(i).indexOf("&")));
            tmp.setMezun_ulke(liste.get(i).substring(liste.get(i).indexOf("&") + 1, liste.get(i).indexOf("*")));
            tmp.setMilliyet(liste.get(i).substring(liste.get(i).indexOf("*") + 1, liste.get(i).indexOf("@@")));

            alist.add(tmp);
        }
    }

    @Override
    public void ekle() {
        if ((idT.getText().length() == 0) || adT.getText().length() == 0 || telT.getText().length() == 0 || yilT.getText().length() == 0
                || uzmanlikT.getText().length() == 0 || ulkeT.getText().length() == 0 || milliT.getText().length() == 0 ) {
            JOptionPane.showMessageDialog(null, "Bir Alani booooooos birktiniz");
        } else {
            alist.add(getData());
            idT.clear();
            adT.clear();
            telT.clear();
            yilT.clear();
            uzmanlikT.clear();
            ulkeT.clear();
            milliT.clear();
            try {
                txt.addLine("arapcaogretmen.txt", alist.get(alist.size() - 1).toString(), true);
            } catch (IOException ex) {
                Logger.getLogger(Arabca_ogretmenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }
    public Arabca_ogretmen getData() {
        int id=Integer.parseInt(idT.getText());
        String ad=adT.getText();
        String tel=telT.getText();
        int yili=Integer.parseInt(yilT.getText());
        String uzman=uzmanlikT.getText();
        String ulke=ulkeT.getText();        
        String mil=milliT.getText();        

        return new Arabca_ogretmen(ulke,mil,id, ad,  tel,yili,uzman) ;
    }
    int index;
    @Override
    public void getSelected() {
         index = atable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        idT.setText(id.getCellData(index).toString());
        adT.setText(ad.getCellData(index));
        telT.setText(tel.getCellData(index));
        yilT.setText(yil.getCellData(index).toString());
        uzmanlikT.setText(uzmanlik.getCellData(index));
        ulkeT.setText(ulke.getCellData(index));
        milliT.setText(milli.getCellData(index));
    }

    @Override
    public void guncelle() {
        if ((idT.getText().length() == 0) || adT.getText().length() == 0 || telT.getText().length() == 0 || yilT.getText().length() == 0
                || uzmanlikT.getText().length() == 0 || ulkeT.getText().length() == 0 || milliT.getText().length() == 0 ) {
            JOptionPane.showMessageDialog(null, "GUNCELLENECEK INDEXI SECMEDINIZ");
        } else {
           alist.set(index, getData());
            idT.clear();
            adT.clear();
            telT.clear();
            yilT.clear();
            uzmanlikT.clear();
            ulkeT.clear();
            milliT.clear();

             for (int i = 0; i < alist.size(); i++) {
                try {
                    if (i == 0) {
                        txt.addLine("arapcaogretmen.txt", alist.get(i).toString(), false);

                    } else {
                        txt.addLine("arapcaogretmen.txt", alist.get(i).toString(), true);

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Arabca_ogretmenController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void sil() {
        if ((idT.getText().length() == 0) || adT.getText().length() == 0 || telT.getText().length() == 0 || yilT.getText().length() == 0
                || uzmanlikT.getText().length() == 0 || ulkeT.getText().length() == 0 || milliT.getText().length() == 0 ) {
            JOptionPane.showMessageDialog(null, "SILENECEK INDEXI SECMEDINIZ");
        } else {
            atable.getItems().remove(index);
            index = -1;
            idT.clear();
            adT.clear();
            telT.clear();
            yilT.clear();
            uzmanlikT.clear();
            ulkeT.clear();
            milliT.clear();

             for (int i = 0; i < alist.size(); i++) {
                try {
                    if (i == 0) {
                        txt.addLine("arapcaogretmen.txt", alist.get(i).toString(), false);

                    } else {
                        txt.addLine("arapcaogretmen.txt", alist.get(i).toString(), true);

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Arabca_ogretmenController.class.getName()).log(Level.SEVERE, null, ex);
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
                    atable.setItems(alist);
                    return;
                }//eger bos ise

                //degilse?
                ObservableList<Arabca_ogretmen> items = FXCollections.observableArrayList();
                ObservableList<TableColumn<Arabca_ogretmen, ?>> column = atable.getColumns();

                for (int row = 0; row < alist.size(); row++) {
                    for (int col = 0; col < column.size(); col++) {
                        TableColumn colVar = column.get(col);
                        String celValue = colVar.getCellData(alist.get(row)).toString();
                        celValue = celValue.toLowerCase();

                        if (celValue.contains(search.getText().toLowerCase()) && celValue.startsWith(search.getText().toLowerCase())) {
                            items.add(alist.get(row));
                            break;
                        }
                    }

                }
                atable.setItems(items);

            }
        });
    }
    @FXML
    private void Back4(ActionEvent event) {
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
