package system.macros;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import system.Controller;

import java.awt.*;

public abstract class Macro {

    Robot r;
    Controller controller = new Controller();
    private int runKey;
    private final String name;

    public Macro(int runKey, String name) throws AWTException {
        r = new Robot();
        this.runKey = runKey;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getRunKey() {
        return runKey;
    }

    public void setRunKey(int key) {
        this.runKey = key;
    }

    public void setRunKey(char c) {
        for (int i = 0; i < 256; i++) {
            if (NativeKeyEvent.getKeyText(i).toUpperCase().equalsIgnoreCase(String.valueOf(c).toUpperCase())) {
                this.runKey = i;
            }
        }
    }

    public abstract void run() throws InterruptedException, AWTException;

}
