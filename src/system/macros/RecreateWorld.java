package system.macros;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RecreateWorld extends Macro{

    public RecreateWorld(int runKey) throws AWTException {
        super(runKey, "Recreate last world");
    }

    @Override
    public void run() throws InterruptedException, AWTException {
        controller.clickKey(KeyEvent.VK_TAB);
        controller.clickKey(KeyEvent.VK_SPACE);
        controller.clickKey(KeyEvent.VK_TAB, 6);
        controller.clickKey(KeyEvent.VK_SPACE);
        controller.clickKey(KeyEvent.VK_TAB, 7);
        controller.clickKey(KeyEvent.VK_SPACE);
    }
}
