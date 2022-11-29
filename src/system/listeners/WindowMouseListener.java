package system.listeners;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import system.MacroManager;
import application.App;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WindowMouseListener implements MouseListener {

    String lastText = "";
    JLabel lastLabel = new JLabel();
    boolean changing = false;
    static int index = 0;

    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY() - App.labels.get(0).getHeight() - 16;

        if (!changing) {
            for (int i = 0; i < App.labels.size(); i++) {
                JLabel label = App.labels.get(i);
                if (mouseX >= label.getX() && mouseX <= label.getX() + label.getWidth() &&
                        mouseY >= label.getY() && mouseY <= label.getY() + label.getHeight()) {
                    System.out.println(label.getText() + " has been clicked");
                    lastLabel = label;
                    lastText = label.getText();
                    index = i;
                    label.setText("Press any key");
                    changing = true;
                }
            }
        }
    }

    public void keyTyped(NativeKeyEvent e) {
        int id = e.getRawCode();
        if (changing) {
            MacroManager.getMacros().get(index).setRunKey(id);
            changing = false;
            lastLabel.setText(MacroManager.getMacros().get(index).getName() + ": " + MacroManager.getMacros().get(index).getRunKey());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
