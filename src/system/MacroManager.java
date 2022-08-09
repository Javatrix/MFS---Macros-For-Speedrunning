package system;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import system.listeners.NativeKeyListener;
import system.macros.*;

import java.awt.*;
import java.util.ArrayList;

public class MacroManager {

    static Robot r;
    static ArrayList<Macro> macros = new ArrayList<>();
    static NativeKeyListener nativeKeyListener = new NativeKeyListener();

    public static void initMacros() throws AWTException, NativeHookException, InterruptedException {
        r = new Robot();

        macros.add(new EasyRSGWorld(NativeKeyEvent.VC_L));
        macros.add(new ExitMacro(NativeKeyEvent.VC_P));
        macros.add(new EasySSGWorld(NativeKeyEvent.VC_O));
        macros.add(new RecreateWorld(NativeKeyEvent.VC_K));

        GlobalScreen.registerNativeHook();
        GlobalScreen.addNativeKeyListener(nativeKeyListener);
    }

    public static void keyTyped(char c) throws InterruptedException, AWTException {
        for(Macro m : macros) {
            if(NativeKeyEvent.getKeyText(m.getRunKey()).toLowerCase().equalsIgnoreCase(String.valueOf(c).toLowerCase())) {
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
