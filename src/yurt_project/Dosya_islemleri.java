/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yurt_project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bayoon
 */
public class Dosya_islemleri {
    
    List<String> liste;

    public Dosya_islemleri() {
         this.liste = new ArrayList<>();
    }
    
    //okuma hersey icin
    public void TxtReader(String fileName, List<String> tmp) throws IOException {
        File f = new File(fileName);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        while(br.ready() == true) {
            tmp.add(br.readLine());
        }
        fr.close();
        br.close();
    }

    public void addLine(String fileName, String tmp, boolean control) throws IOException {
        FileWriter fw = new FileWriter(new File(fileName), control);
        fw.write(tmp+"\n");
        fw.close();
    }
    //yeni satır ekle
    public void addLine(String fileName, String tmp) throws IOException {
        FileWriter fw = new FileWriter(new File(fileName), true);
        fw.write(tmp+"\n");
        fw.close();
    }
   
   //dosyada kac satir var
    public int Length(String FileName) throws IOException {
        File f = new File(FileName);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        int length = 0;
        while(br.ready() == true){
            br.readLine();
            length++;
        }
        return length;

    }

    //bir dosya ekle
    public void addFile(String fileName) throws IOException {
        File file = new File(fileName);
        file.createNewFile();

    }

    //bir dosya sil
    public void RemoveFile(String FileName){
        File oldFile = new File(FileName);
        oldFile.delete();
    }
}
