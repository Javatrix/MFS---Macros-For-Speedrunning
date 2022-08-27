package system;

import application.App;

import java.awt.*;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Controller {

    private final Robot r;

    public Controller() throws AWTException {
        r = new Robot();
    }

    public void clickKey(int key) throws InterruptedException {
        clickKey(key, 1);
        TimeUnit.MILLISECONDS.sleep(App.delayValue);
    }

    public void clickKey(int key, int times) throws InterruptedException {
        for (int i = 0; i < times; i++) {
            r.keyPress(key);
            r.keyRelease(key);
            TimeUnit.MILLISECONDS.sleep(App.delayValue);
        }
    }

    public void clickMouse(int button) throws InterruptedException {
        r.mousePress(button);
        Thread.sleep(20);
        r.mouseRelease(button);
    }

}
