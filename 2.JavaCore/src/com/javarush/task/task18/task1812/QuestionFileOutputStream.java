package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {

    private AmigoOutputStream component;

    public QuestionFileOutputStream(AmigoOutputStream component) {
        this.component = component;
    }

    @Override
    public void flush() throws IOException {
        this.component.flush();
    }

    @Override
    public void write(int b) throws IOException {
        this.component.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        this.component.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        this.component.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        System.out.print("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        if(line.equals("Д")) component.close();
    }
}

