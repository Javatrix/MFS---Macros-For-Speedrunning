package system;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import system.listeners.NativeKeyListener;
import system.macros.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class MacroManager {

    static Robot r;
    static ArrayList<Macro> macros = new ArrayList<>();
    static NativeKeyListener nativeKeyListener = new NativeKeyListener();

    public static void initMacros() throws AWTException, NativeHookException, InterruptedException {
        r = new Robot();

        macros.add(new EasyRSGWorld(KeyEvent.VK_L));
        macros.add(new ExitMacro(KeyEvent.VK_P));
        macros.add(new EasySSGWorld(KeyEvent.VK_O));
        macros.add(new RecreateWorld(KeyEvent.VK_K));
        macros.add(new NextInstanceMacro(KeyEvent.VK_U));

        GlobalScreen.registerNativeHook();
        GlobalScreen.addNativeKeyListener(nativeKeyListener);
    }

    public static void keyTyped(String key) throws InterruptedException, AWTException {
        for (Macro m : macros) {
            if (m.getRunKey().equalsIgnoreCase(key)) {
                m.run();
            }
        }
    }

    public static ArrayList<Macro> getMacros() {
        return macros;
    }

    public static NativeKeyListener getNativeKeyListener() {
        return nativeKeyListener;
    }
}
