package application;

import com.github.kwhat.jnativehook.NativeHookException;

import javax.swing.*;
import java.awt.*;

public class Start {

    private static App app;
    public static void main(String[] args) throws NativeHookException, InterruptedException, AWTException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        app = new App();
        app.start();
    }

    public static App getApp() {
        return app;
    }

}
