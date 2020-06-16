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
public class Kuran_ogretmenController implements Initializable,controller {

    @FXML
    TableView<Kuran_ogretmen>   ktable;
    @FXML
    TableColumn<Kuran_ogretmen, Integer> id;
    @FXML
    TableColumn<Kuran_ogretmen, String> ad;
    @FXML
    TableColumn<Kuran_ogretmen, String> tel;
    @FXML
    TableColumn<Kuran_ogretmen, Integer> yil;
    @FXML
    TableColumn<Kuran_ogretmen, String> uzmanlik;
    @FXML
    TableColumn<Kuran_ogretmen, String> ezber;
    
   
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
    TextField ezberT;
    
    @FXML
    TextField search;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Oku();
        } catch (IOException ex) {
            Logger.getLogger(Kuran_ogretmenController.class.getName()).log(Level.SEVERE, null, ex);
        }
            id.setCellValueFactory(new PropertyValueFactory<Kuran_ogretmen,Integer>("id"));
            ad.setCellValueFactory(new PropertyValueFactory<Kuran_ogretmen,String>("ad_soyad"));
            tel.setCellValueFactory(new PropertyValueFactory<Kuran_ogretmen,String>("tel"));
            yil.setCellValueFactory(new PropertyValueFactory<Kuran_ogretmen,Integer>("mezuniyet_yili"));
            uzmanlik.setCellValueFactory(new PropertyValueFactory<Kuran_ogretmen,String>("uzmanlik"));
            ezber.setCellValueFactory(new PropertyValueFactory<Kuran_ogretmen,String>("kur_ezber"));

            ktable.setItems(klist);
    }    
    ObservableList<Kuran_ogretmen> klist = FXCollections.observableArrayList();
    Dosya_islemleri txt = new Dosya_islemleri();
    List<String> liste = new ArrayList<>();

    public void Oku() throws IOException {
        liste.clear();
        klist.clear();
        txt.TxtReader("kuranogretmen.txt", liste);

        Kuran_ogretmen tmp;
        for (int i = 0; i < txt.Length("kuranogretmen.txt"); i++) {

            tmp = new Kuran_ogretmen();
            tmp.setId(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("@") + 1, liste.get(i).indexOf("#"))));
            tmp.setAd_soyad(liste.get(i).substring(liste.get(i).indexOf("#") + 1, liste.get(i).indexOf("$")));
            tmp.setTel(liste.get(i).substring(liste.get(i).indexOf("$") + 1, liste.get(i).indexOf("%")));
            tmp.setMezuniyet_yili(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("%") + 1, liste.get(i).indexOf("^"))));
            tmp.setUzmanlik(liste.get(i).substring(liste.get(i).indexOf("^") + 1, liste.get(i).indexOf("&")));
            tmp.setKur_ezber(liste.get(i).substring(liste.get(i).indexOf("&") + 1, liste.get(i).indexOf("*")));

            klist.add(tmp);
        }
    }

    @Override
    public void ekle() {
       
        if ((idT.getText().length() == 0) || adT.getText().length() == 0 || telT.getText().length() == 0 || yilT.getText().length() == 0
                || uzmanlikT.getText().length() == 0 || ezberT.getText().length() == 0 ) {
            JOptionPane.showMessageDialog(null, "Bir Alani booooooos birktiniz");
        } else {
            klist.add(getData());
            idT.clear();
            adT.clear();
            telT.clear();
            yilT.clear();
            uzmanlikT.clear();
            ezberT.clear();
     
            try {
                txt.addLine("kuranogretmen.txt", klist.get(klist.size() - 1).toString(), true);
            } catch (IOException ex) {
                Logger.getLogger(Kuran_ogretmenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public Kuran_ogretmen getData() {
        int id=Integer.parseInt(idT.getText());
        String ad=adT.getText();
        String tel=telT.getText();
        int yili=Integer.parseInt(yilT.getText());
        String uzman=uzmanlikT.getText();
        String ezberen=ezberT.getText();        
        
        return new Kuran_ogretmen(ezberen,id, ad,  tel,yili,uzman) ;
    }
  
    int index;
    @Override
    public void getSelected() {
         index = ktable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        idT.setText(id.getCellData(index).toString());
        adT.setText(ad.getCellData(index));
        telT.setText(tel.getCellData(index));
        yilT.setText(yil.getCellData(index).toString());
        uzmanlikT.setText(uzmanlik.getCellData(index));
        ezberT.setText(ezber.getCellData(index));
        
    }

    @Override
    public void guncelle() {
        if ((idT.getText().length() == 0) || adT.getText().length() == 0 || telT.getText().length() == 0 || yilT.getText().length() == 0
                || uzmanlikT.getText().length() == 0 || ezberT.getText().length() == 0 ) {
            JOptionPane.showMessageDialog(null, "GUNCELLENECEK INDEXI SECMEDINIZ");
        } else {
           klist.set(index, getData());
            idT.clear();
            adT.clear();
            telT.clear();
            yilT.clear();
            uzmanlikT.clear();
            ezberT.clear();
        
             for (int i = 0; i < klist.size(); i++) {
                try {
                    if (i == 0) {
                        txt.addLine("kuranogretmen.txt", klist.get(i).toString(), false);

                    } else {
                        txt.addLine("kuranogretmen.txt", klist.get(i).toString(), true);

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Kuran_ogretmenController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void sil() {
        if ((idT.getText().length() == 0) || adT.getText().length() == 0 || telT.getText().length() == 0 || yilT.getText().length() == 0
                || uzmanlikT.getText().length() == 0 || ezberT.getText().length() == 0 ) {
            JOptionPane.showMessageDialog(null, "SILENECEK INDEXI SECMEDINIZ");
        } else {
            ktable.getItems().remove(index);
            index = -1;
            idT.clear();
            adT.clear();
            telT.clear();
            yilT.clear();
            uzmanlikT.clear();
            ezberT.clear();
        
             for (int i = 0; i < klist.size(); i++) {
                try {
                    if (i == 0) {
                        txt.addLine("kuranogretmen.txt", klist.get(i).toString(), false);

                    } else {
                        txt.addLine("kuranogretmen.txt", klist.get(i).toString(), true);

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Kuran_ogretmenController.class.getName()).log(Level.SEVERE, null, ex);
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
                    ktable.setItems(klist);
                    return;
                }//eger bos ise

                //degilse?
                ObservableList<Kuran_ogretmen> items = FXCollections.observableArrayList();
                ObservableList<TableColumn<Kuran_ogretmen, ?>> column = ktable.getColumns();

                for (int row = 0; row < klist.size(); row++) {
                    for (int col = 0; col < column.size(); col++) {
                        TableColumn colVar = column.get(col);
                        String celValue = colVar.getCellData(klist.get(row)).toString();
                        celValue = celValue.toLowerCase();

                        if (celValue.contains(search.getText().toLowerCase()) && celValue.startsWith(search.getText().toLowerCase())) {
                            items.add(klist.get(row));
                            break;
                        }
                    }

                }
                ktable.setItems(items);

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
