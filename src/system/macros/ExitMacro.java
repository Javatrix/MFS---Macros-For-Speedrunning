package system.macros;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ExitMacro extends Macro {

    public ExitMacro(int runKey) throws AWTException {
        super(runKey, "Exit World");
    }

    @Override
    public void run() throws InterruptedException, AWTException {
        controller.clickKey(KeyEvent.VK_ESCAPE);
        controller.clickKey(KeyEvent.VK_TAB, 8);
        controller.clickKey(KeyEvent.VK_SPACE);
        System.out.println("Exited the world.");
    }

}
