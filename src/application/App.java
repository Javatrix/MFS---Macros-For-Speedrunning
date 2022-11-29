package application;

import com.github.kwhat.jnativehook.NativeHookException;
import system.MacroManager;
import system.listeners.WindowMouseListener;
import system.macros.Macro;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Objects;

public class App extends JFrame {

    static ImageIcon icon;
    public static final String version = "v1.6";
    public static int delayValue = 20;
    public static JLabel value = new JLabel(String.valueOf(delayValue));
    public static JCheckBox hasFastReset = new JCheckBox("I have FastReset mod");
    public static int instanceCount = 3;
    public static JTextField instances = new JTextField("        " + instanceCount);
    public static ArrayList<JLabel> labels = new ArrayList<>();
    private static final WindowMouseListener windowMouseListener = new WindowMouseListener();
    public static JSlider delay = new JSlider(20, 1000, delayValue);

    public App() throws NativeHookException, InterruptedException, AWTException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        icon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("res/icon.png")));
        MacroManager.initMacros();

        GradientPanel window = new GradientPanel(Color.black, new Color(30, 33, 36), GradientPanel.VERTICAL);
        window.setBackground(new Color(0x2A2C30));

        this.add(window, BorderLayout.CENTER);

        window.setLayout(new BoxLayout(window, BoxLayout.Y_AXIS));
        window.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

        JLabel title = new JLabel("Speedrunning Macros " + version);
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
            JLabel label = new JLabel(m.getName() + ": " + m.getRunKey());
            label.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
            label.setOpaque(true);
            label.setBackground(new Color(40, 43, 48));
            label.setForeground(new Color(0x7289da));
            label.setFont(new Font("", Font.BOLD, 15));
            labels.add(label);
            window.add(label);
        }

        hasFastReset.setOpaque(false);
        hasFastReset.setForeground(Color.WHITE);
        hasFastReset.setBackground(Color.BLACK);
        hasFastReset.setFocusable(false);
        hasFastReset.setText(hasFastReset.getText() + ": " + "❌");
        hasFastReset.addActionListener(new FastResetListener());
        window.add(hasFastReset);


        JLabel instanceText = new JLabel("Number of instances you are using (up to 9 is supported): ");
        instanceText.setForeground(Color.WHITE);
        window.add(instanceText);

        instances.setOpaque(false);
        instances.setBorder(null);
        instances.setForeground(Color.WHITE);
        //instances.setPreferredSize(new Dimension(100, 20));
        instances.addKeyListener(new InstanceCountListener());
        window.add(instances);

        delay.setOpaque(false);
        window.add(delay);

        //value.setOpaque(true);
        value.setBackground(Color.BLACK);
        value.setForeground(Color.GREEN);
        value.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        window.add(value);

        JLabel sliderH = new JLabel("Delay between clicks (ms)");
        //sliderH.setOpaque(true);
        sliderH.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        window.add(sliderH);

        this.setFocusable(false);
        this.addMouseListener(windowMouseListener);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Macros For Speedrunning " + version);
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

    static class InstanceCountListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            try {
                instances.setText(instances.getText().replace(" ", ""));
                if (instances.getText().equalsIgnoreCase("")) return;
                instanceCount = Integer.parseInt(instances.getText());
                instanceCount = Math.min(9, Math.max(1, instanceCount));
                instances.setText("        " + instanceCount);
            } catch (NumberFormatException ex) {
                instanceCount = 1;
                instances.setText("        " + instanceCount);
            }
        }
    }

    static class FastResetListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            hasFastReset.setText("I have FastReset mod: " + (hasFastReset.isSelected() ? "✔" : "❌"));
        }

    }

    public WindowMouseListener getWindowMouseListener() {
        return windowMouseListener;
    }

}
