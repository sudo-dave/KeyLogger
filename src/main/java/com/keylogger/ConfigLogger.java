package com.keylogger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConfigLogger {
    private String date;
    private final String fileName;
    public ConfigLogger(String fileName) throws IOException {
        this.fileName = fileName;

        // Creates the file if never exsits; if exsits  it ignores
        String date = ConfigLogger.getDate();
        try {
            FileWriter fw
                    = new FileWriter(fileName,true);
            File file = new File(fileName);

            String stamp= (file.length() != 0) ? "\n\nStarted up again @ " + date :
                    "File created: " + date;

            for (char c: stamp.toCharArray()){
                fw.write(c);
            }
            fw.write("\n");
            fw.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }

    }
    public static String getDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
    public void writeFile(String keyInput){
        String date = ConfigLogger.getDate();
        String output =  "Button Pressed: "+keyInput +"\t" + date;
        try {
            // attach a file to FileWriter
            FileWriter fw
                    = new FileWriter(fileName,true);

            fw.write("\n");
            for(char c: output.toCharArray()){
                fw.write(c);
            }
            fw.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }
}
