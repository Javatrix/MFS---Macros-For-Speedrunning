package system.listeners;

import application.App;
import application.Start;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.*;
import system.MacroManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class NativeKeyListener implements com.github.kwhat.jnativehook.keyboard.NativeKeyListener {

    ArrayList<Integer> pressedKeys = new ArrayList<>();
    long lastms = 0;

    public void nativeKeyPressed(NativeKeyEvent e) {
        pressedKeys.add(e.getKeyCode());
    }

    public void nativeKeyReleased(NativeKeyEvent e) {
        pressedKeys.clear();
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
        try {
            MacroManager.keyTyped(KeyEvent.getKeyText(e.getRawCode()));
            Start.getApp().getWindowMouseListener().keyTyped(e);
        } catch (InterruptedException | AWTException ex) {
            ex.printStackTrace();
        }
    }

    public boolean isKeyPressed(int key) {
        if (System.currentTimeMillis() - lastms > 100) {
            lastms = System.currentTimeMillis();
            return pressedKeys.contains(key);
        }
        return false;
    }

    public ArrayList<Integer> getPressedKeys() {
        return pressedKeys;
    }
}
