package application;

import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import system.MacroManager;
import system.listeners.WindowMouseListener;
import system.macros.Macro;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class App extends JFrame {

    static ImageIcon icon;
    public static int delayValue = 20;
    public static JLabel value = new JLabel(String.valueOf(delayValue));
    public static ArrayList<JLabel> labels = new ArrayList<>();
    private static final WindowMouseListener windowMouseListener = new WindowMouseListener();
    public static JSlider delay = new JSlider(20, 1000, delayValue);

    public App() throws NativeHookException, InterruptedException, AWTException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        icon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("res/icon.png")));
        MacroManager.initMacros();
        //setLocationRelativeTo(null);
        GradientPanel window = new GradientPanel(Color.black, new Color(85, 14, 238), GradientPanel.VERTICAL);

        this.add(window, BorderLayout.CENTER);

        window.setLayout(new BoxLayout(window, BoxLayout.Y_AXIS));
        window.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

        JLabel title = new JLabel("Speedrunning Macros");
        title.setLocation(0, 10);
        title.setFont(new Font("Bauhaus 93", Font.ITALIC, 30));
        title.setForeground(new Color(255, 0, 0, 219));
        title.setBorder(BorderFactory.createEtchedBorder(0));
        title.setBackground(new Color(8, 255, 152));
        window.add(title);

        JLabel help = new JLabel("Click on macro to change keybind");
        help.setFont(new Font("Agency FB", Font.BOLD, 25));
        help.setForeground(new Color(137, 0, 241));
        window.add(help);

        for (int i = 0; i < MacroManager.getMacros().size(); i++) {
            Macro m = MacroManager.getMacros().get(i);
            JLabel label = new JLabel(m.getName() + ": " + NativeKeyEvent.getKeyText(m.getRunKey()));
            label.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
            label.setOpaque(true);
            label.setBackground(new Color(34, 187, 234));
            labels.add(label);
            window.add(label);
        }

        //delay.setBackground(new Color(137, 0, 241));
        delay.setOpaque(false);
        window.add(delay);

        //value.setOpaque(true);
        value.setBackground(Color.black);
        value.setForeground(Color.GREEN);
        value.setFont(new Font("Comic Sans MS",  Font.PLAIN,20));
        window.add(value);

        JLabel sliderH = new JLabel("Delay between clicks (ms)");
        //sliderH.setOpaque(true);
        sliderH.setFont(new Font("Comic Sans MS",  Font.PLAIN,20));
        window.add(sliderH);

        this.addMouseListener(windowMouseListener);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Macros For Speedrunning");
        this.setIconImage(icon.getImage());
        this.pack();
        this.setVisible(true);
    }

    public void start() {
        while (true) {
            App.delayValue = App.delay.getValue();
            App.value.setText(String.valueOf(App.delayValue));
        }
    }

    public WindowMouseListener getWindowMouseListener() {
        return windowMouseListener;
    }

}
