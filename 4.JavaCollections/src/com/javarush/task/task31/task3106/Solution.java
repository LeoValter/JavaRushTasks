package com.javarush.task.task31.task3106;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        String resultFileName = args[0];
        String[] partOfZip = new String[args.length - 1];

        for (int i = 0; i < args.length - 1; i++) {
            partOfZip[i] = args[i + 1];
        }

        Arrays.sort(partOfZip);

        List<FileInputStream> inputStreamList = new ArrayList<>();

        for (String part: partOfZip) {
            inputStreamList.add(new FileInputStream(part));
        }

        SequenceInputStream seqInputStream = new SequenceInputStream(Collections.enumeration(inputStreamList));
        ZipInputStream zipInputStream = new ZipInputStream(seqInputStream);
        FileOutputStream fileOutputStream = new FileOutputStream(resultFileName);
        byte[] buffer = new byte[1024];
        while (zipInputStream.getNextEntry() != null) {
            int count;
            while ((count = zipInputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, count);
            }

            zipInputStream.closeEntry();
        }

        fileOutputStream.close();
        zipInputStream.close();
        seqInputStream.close();
    }
}
