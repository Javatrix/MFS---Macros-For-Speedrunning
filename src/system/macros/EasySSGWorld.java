package system.macros;

import java.awt.*;
import java.awt.event.KeyEvent;

public class EasySSGWorld extends Macro{

    public EasySSGWorld(int runKey) throws AWTException {
        super(runKey, "Create new SSG World");
    }

    @Override
    public void run() throws InterruptedException, AWTException {
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
        Thread.sleep(20);
        new Robot().keyRelease(KeyEvent.VK_CONTROL);
        new Robot().keyRelease(KeyEvent.VK_V);
        controller.clickKey(KeyEvent.VK_TAB, 6);
        controller.clickKey(KeyEvent.VK_SPACE);
    }

}
