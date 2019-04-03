package com.javarush.task.task14.task1419;

import javax.xml.datatype.DatatypeConfigurationException;
import java.awt.*;
import java.awt.print.PrinterException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.SyncFailedException;
import java.nio.BufferOverflowException;
import java.text.ParseException;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        exceptions.add(new ArrayIndexOutOfBoundsException());
        exceptions.add(new ClassCastException());
        exceptions.add(new IOException());
        exceptions.add(new PrinterException());
        exceptions.add(new DataFormatException());
        exceptions.add(new NoSuchFieldException());
        exceptions.add(new BufferOverflowException());
        exceptions.add(new NullPointerException());
        exceptions.add(new DatatypeConfigurationException());


    }
}
