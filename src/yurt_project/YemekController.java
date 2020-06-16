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
public class YemekController implements Initializable, controller {

    @FXML
    TableView<Yemek> yemektable;

    @FXML
    TableColumn<Yemek, Integer> id;
    @FXML
    TableColumn<Yemek, String> gun;
    @FXML
    TableColumn<Yemek, String> tarih;
    @FXML
    TableColumn<Yemek, String> yemek;
    @FXML
    TableColumn<Yemek, String> icecek;

    @FXML
    TextField id1;
    @FXML
    TextField gun1;
    @FXML
    TextField tarih1;
    @FXML
    TextField yemek1;
    @FXML
    TextField icecek1;
    @FXML
    TextField search;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Oku();
        } catch (IOException ex) {
            Logger.getLogger(YemekController.class.getName()).log(Level.SEVERE, null, ex);
        }
        id.setCellValueFactory(new PropertyValueFactory<Yemek, Integer>("id"));
        gun.setCellValueFactory(new PropertyValueFactory<Yemek, String>("gun"));
        tarih.setCellValueFactory(new PropertyValueFactory<Yemek, String>("tarih"));
        yemek.setCellValueFactory(new PropertyValueFactory<Yemek, String>("yemek_adi"));
        icecek.setCellValueFactory(new PropertyValueFactory<Yemek, String>("icecek_adi"));

        yemektable.setItems(yemeklist);
    }

    ObservableList<Yemek> yemeklist = FXCollections.observableArrayList();
    Dosya_islemleri txt = new Dosya_islemleri();
    List<String> liste = new ArrayList<>();

    public void Oku() throws IOException {
        liste.clear();
        yemeklist.clear();
        txt.TxtReader("Yemekler.txt", liste);

        Yemek tmp;
        for (int i = 0; i < txt.Length("Yemekler.txt"); i++) {

            tmp = new Yemek();
            tmp.setId(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("@") + 1, liste.get(i).indexOf("#"))));
            tmp.setGun(liste.get(i).substring(liste.get(i).indexOf("#") + 1, liste.get(i).indexOf("$")));
            tmp.setTarih(liste.get(i).substring(liste.get(i).indexOf("$") + 1, liste.get(i).indexOf("%")));
            tmp.setYemek_adi(liste.get(i).substring(liste.get(i).indexOf("%") + 1, liste.get(i).indexOf("^")));
            tmp.setIcecek_adi(liste.get(i).substring(liste.get(i).indexOf("^") + 1, liste.get(i).indexOf("&")));

            yemeklist.add(tmp);
        }
    }

    @Override
    public void ekle() {

        if ((id1.getText().length() == 0) || gun1.getText().length() == 0 || tarih1.getText().length() == 0 || yemek1.getText().length() == 0
                || icecek1.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Bir Alani booooooos birktiniz");
        } else {
            yemeklist.add(getData());
            id1.clear();
            gun1.clear();
            tarih1.clear();
            yemek1.clear();
            icecek1.clear();
            try {
                txt.addLine("Yemekler.txt", yemeklist.get(yemeklist.size() - 1).toString(), true);
            } catch (IOException ex) {
                Logger.getLogger(YemekController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public Yemek getData() {
        int id = Integer.parseInt(id1.getText());
        String gun = gun1.getText();
        String tarih = tarih1.getText();
        String yemek = yemek1.getText();
        String icecek = icecek1.getText();

        return new Yemek(id, gun, tarih, yemek, icecek);

    }
    int index;

    @Override
    public void getSelected() {
        index = yemektable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        id1.setText(id.getCellData(index).toString());
        gun1.setText(gun.getCellData(index));
        tarih1.setText(tarih.getCellData(index));
        yemek1.setText(yemek.getCellData(index));
        icecek1.setText(icecek.getCellData(index));

    }

    @Override
    public void guncelle() {
        if ((id1.getText().length() == 0) || gun1.getText().length() == 0 || tarih1.getText().length() == 0 || yemek1.getText().length() == 0
                || icecek1.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "GUNCELLENECEK INDEXI SECMEDINIZ");
        } else {
            yemeklist.set(index, getData());
            id1.clear();
            gun1.clear();
            tarih1.clear();
            yemek1.clear();
            icecek1.clear();

            for (int i = 0; i < yemeklist.size(); i++) {
                try {
                    if (i == 0) {
                        txt.addLine("Yemekler.txt", yemeklist.get(i).toString(), false);

                    } else {

                        txt.addLine("Yemekler.txt", yemeklist.get(i).toString(), true);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(YemekController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    @Override
    public void sil() {
        if ((id1.getText().length() == 0) || gun1.getText().length() == 0 || tarih1.getText().length() == 0 || yemek1.getText().length() == 0
                || icecek1.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "SILENECEK INDEXI SECMEDINIZ");
        } else {
            yemektable.getItems().remove(index);
            index = -1;
            id1.clear();
            gun1.clear();
            tarih1.clear();
            yemek1.clear();
            icecek1.clear();

            for (int i = 0; i < yemeklist.size(); i++) {
                try {
                    if (i == 0) {
                        txt.addLine("Yemekler.txt", yemeklist.get(i).toString(), false);

                    } else {

                        txt.addLine("Yemekler.txt", yemeklist.get(i).toString(), true);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(YemekController.class.getName()).log(Level.SEVERE, null, ex);
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
                    yemektable.setItems(yemeklist);
                    return;
                }//eger bos ise

                //degilse?
                ObservableList<Yemek> items = FXCollections.observableArrayList();
                ObservableList<TableColumn<Yemek, ?>> column = yemektable.getColumns();

                for (int row = 0; row < yemeklist.size(); row++) {
                    for (int col = 0; col < column.size(); col++) {
                        TableColumn colVar = column.get(col);
                        String celValue = colVar.getCellData(yemeklist.get(row)).toString();
                        celValue = celValue.toLowerCase();

                        if (celValue.contains(search.getText().toLowerCase()) && celValue.startsWith(search.getText().toLowerCase())) {
                            items.add(yemeklist.get(row));
                            break;
                        }
                    }

                }
                yemektable.setItems(items);

            }
        });

    }

    @FXML
    private void Back(ActionEvent event) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            Scene tableVView = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableVView);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
