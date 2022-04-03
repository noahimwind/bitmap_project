package com.company;

import java.io.*;
import java.util.Scanner;

public class BMPMetaData {
    // Attribute
    String dateiname;
    int hoehe;  //Pixeldimensionen der Bitmap
    int breite;
    RandomAccessFile raf = null;
    BufferedWriter bw = null;
    BufferedReader br = null;
    Scanner sc = null;

    public BMPMetaData(String dateiname) throws IOException {
        this.dateiname = dateiname;
        File x = new File("C:\\Users\\noah.duerkes\\Documents\\SWD_CD\\BMP\\" + dateiname);
        raf = new RandomAccessFile(x, "r");
        // ist es eine BMP-Datei ? -> erste beiden Bytes
        String is_bmp = "";
        for (int i = 0; i < 2; i++){
            is_bmp += (char)raf.readByte();
        }
        if (is_bmp.equals("BM")){
            // true: hoehe und breite einlesen
            raf.seek(18);
            this.breite = Integer.reverseBytes(raf.readInt());
            this.hoehe = Integer.reverseBytes(raf.readInt());
        }else{
            // false: hoehe und breite auf 0 setzen
            this.hoehe = 0;
            this.breite = 0;
        }
        raf.close();
    }

    // toString Methode
    @Override
    public String toString() {
        return this.dateiname + "\n" + "Höhe: " + this.hoehe + "\nBreite: " + this.breite;
    }

    // überschreibt / hängt an Datei an
    public void schreibeTextdatei(String dateiname, boolean overwrite) throws IOException {
        File metadata = new File("C:\\Users\\noah.duerkes\\Documents\\SWD_CD\\BMP\\" + dateiname);

        if (overwrite){
            // Überschreiben
        }
        else{
            // Anhängen
        }
    }
}
