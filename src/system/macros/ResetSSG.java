package system.macros;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ResetSSG extends Macro {

    boolean num = false;

    public ResetSSG(int runKey) throws AWTException {
        super(runKey, "Reset SSG");
    }

    @Override
    public void run() throws InterruptedException, AWTException {
        new ExitMacro(0).run();
        new EasySSGWorld(0).run();
        controller.pressKey(KeyEvent.VK_ALT);
        controller.clickKey(KeyEvent.VK_TAB, 2);
        controller.releaseKey(KeyEvent.VK_ALT);
        controller.clickKey(num ? KeyEvent.VK_NUMPAD2 : KeyEvent.VK_NUMPAD1);
        controller.pressKey(KeyEvent.VK_ALT);
        controller.clickKey(KeyEvent.VK_TAB, 2);
        controller.releaseKey(KeyEvent.VK_ALT);
    }

}
