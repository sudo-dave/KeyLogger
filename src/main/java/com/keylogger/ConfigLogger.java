package com.keylogger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class ConfigLogger {
    private String date;
    private final String fileName;
    public ConfigLogger(String fileName) throws IOException {
        this.fileName = fileName;
        File file = new File(fileName);
        // Creates the file if never exsits; if exsits ignores
        if(file.createNewFile()){
           System.out.println("File is crated");
        }
        else{
        System.out.println("File Already there");
        }

    }
    public void writeFile(String keyInput){
        try {

            // attach a file to FileWriter
            FileWriter fw
                    = new FileWriter(fileName,true);

            // read each character from string and write
            // into FileWriter
            fw.write("\n");
            for (int i = 0; i < keyInput.length(); i++)
                fw.write(keyInput.charAt(i));

            fw.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }
}
