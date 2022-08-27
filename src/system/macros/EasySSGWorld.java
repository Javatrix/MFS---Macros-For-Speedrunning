package system.macros;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

public class EasySSGWorld extends Macro{

    public EasySSGWorld(int runKey) throws AWTException {
        super(runKey, "Create new SSG World");
    }

    @Override
    public void run() throws AWTException, InterruptedException {
        controller.clickKey(KeyEvent.VK_TAB);
        controller.clickKey(KeyEvent.VK_SPACE);
        controller.clickKey(KeyEvent.VK_BACK_SPACE);
        controller.clickKey(KeyEvent.VK_TAB, 3);
        controller.clickKey(KeyEvent.VK_SPACE);
        controller.clickKey(KeyEvent.VK_TAB, 2);
        controller.clickKey(KeyEvent.VK_SPACE, 3);
        controller.clickKey(KeyEvent.VK_TAB, 4);
        controller.clickKey(KeyEvent.VK_SPACE);
        controller.clickKey(KeyEvent.VK_TAB, 3);
        new Robot().keyPress(KeyEvent.VK_CONTROL);
        new Robot().keyPress(KeyEvent.VK_V);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    new Robot().keyRelease(KeyEvent.VK_CONTROL);
                    new Robot().keyRelease(KeyEvent.VK_V);
                } catch (AWTException e) {
                    e.printStackTrace();
                }
            }
        }, 20);
        controller.clickKey(KeyEvent.VK_TAB, 6);
        controller.clickKey(KeyEvent.VK_SPACE);
    }

}
