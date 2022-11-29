package system.macros;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import system.Controller;

import java.awt.*;
import java.awt.event.KeyEvent;

public abstract class Macro {

    Robot r;
    Controller controller = new Controller();
    private String runKey;
    private final String name;

    public Macro(int runKey, String name) throws AWTException {
        r = new Robot();
        this.runKey = KeyEvent.getKeyText(runKey);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getRunKey() {
        return runKey;
    }

    public void setRunKey(int key) {
        this.runKey = KeyEvent.getKeyText(key);
    }

    public abstract void run() throws InterruptedException, AWTException;

}
