package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BMPMetaData x = new BMPMetaData("test2.bmp");
        System.out.println(x);
        x.schreibeTextdatei("bmptest.txt", false);
    }
}
