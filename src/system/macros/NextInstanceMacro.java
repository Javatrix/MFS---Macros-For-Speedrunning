package system.macros;

import application.App;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class NextInstanceMacro extends Macro {

    private int currentInstance = 1;
    private int instanceCount = 2;

    public NextInstanceMacro(int runKey) throws AWTException {
        super(runKey, "Reset & Switch to Next Instance");
    }

    @Override
    public void run() throws InterruptedException, AWTException {
        instanceCount = App.instanceCount;
        new ExitMacro(0).run();
        TimeUnit.MILLISECONDS.sleep(App.hasFastReset.isSelected() ? 400 : 1500);
        new EasyRSGWorld(0).run();
        currentInstance = (currentInstance + 1 > instanceCount ? 1 : currentInstance + 1);
        int numpad = 96 + currentInstance;
        controller.pressKey(numpad);
        TimeUnit.MILLISECONDS.sleep(500);
        controller.releaseKey(numpad);
        int instanceKey = 48 + currentInstance;
        controller.pressKey(KeyEvent.VK_WINDOWS);
        controller.clickKey(instanceKey);
        controller.releaseKey(KeyEvent.VK_WINDOWS);
        System.out.println("Reset has been made.");
    }

}
