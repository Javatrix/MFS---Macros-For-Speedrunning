package application;

import com.github.kwhat.jnativehook.NativeHookException;

import java.awt.*;

public class Start {

    private static App app;

    public static void main(String[] args) throws NativeHookException, InterruptedException, AWTException {
        app = new App();
        app.start();
    }

    public static App getApp() {
        return app;
    }

}
