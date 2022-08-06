package system.macros;

import java.awt.*;
import java.awt.event.KeyEvent;

public class EasyRSGWorld extends Macro {

    public EasyRSGWorld(int runKey) throws AWTException {
        super(runKey, "Create new RSG world");
    }

    @Override
    public void run() throws InterruptedException {
        controller.clickKey(KeyEvent.VK_TAB);
        controller.clickKey(KeyEvent.VK_SPACE);
        controller.clickKey(KeyEvent.VK_TAB, 3);
        controller.clickKey(KeyEvent.VK_SPACE);
        controller.clickKey(KeyEvent.VK_TAB, 2);
        controller.clickKey(KeyEvent.VK_SPACE, 3);
        controller.clickKey(KeyEvent.VK_TAB, 5);
        controller.clickKey(KeyEvent.VK_SPACE);
        System.out.println("Creating new Easy RSG world has been completed.");
    }

}
