package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        byte[] key = {1, 2, 3, 4, 5};

        FileInputStream fileInputStream = new FileInputStream(args[1]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[2]);

        switch (args[0]) {
            case "-e":
                while (fileInputStream.available() > 0) {
                    byte[] buf = new byte[fileInputStream.available()];
                    fileInputStream.read(buf);

                    //XOR Code
                    int j = 0;
                    for (int i = 0; i < buf.length; i++) {
                        buf[i] = (byte) (buf[i] ^ key[j]);
                        if (j > key.length)
                            j = 0;
                    }
                    fileOutputStream.write(buf);
                }

                break;

            case "-d":
                while (fileInputStream.available() > 0) {
                    byte[] buf = new byte[fileInputStream.available()];
                    fileInputStream.read(buf);

                    //XOR deCode
                    int j = 0;
                    for (int i = 0; i < buf.length; i++) {
                        buf[i] = (byte) (buf[i] ^ key[j]);
                        if (j > key.length)
                            j = 0;
                    }
                    fileOutputStream.write(buf);
                }

                break;
        }

        fileInputStream.close();
        fileOutputStream.close();
    }

}
