package system;

import application.App;

import java.awt.*;

public class Controller {

    private Robot r;

    public Controller() throws AWTException {
        r = new Robot();
    }

    public void clickKey(int key) throws InterruptedException {
        clickKey(key, 1);
    }

    public void clickKey(int key, int times) throws InterruptedException {
        for (int i = 0; i < times; i++) {
            r.keyPress(key);
            Thread.sleep(App.delayValue);
            r.keyRelease(key);
        }
    }

    public void clickMouse(int button) throws InterruptedException {
        r.mousePress(button);
        Thread.sleep(20);
        r.mouseRelease(button);
    }

}
