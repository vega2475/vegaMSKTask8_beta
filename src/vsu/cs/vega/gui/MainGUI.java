package vsu.cs.vega.gui;

public class MainGUI {


    public static void winMain() {

        java.awt.EventQueue.invokeLater(() -> new FrameMain().setVisible(true));
    }

    public static void main(String[] args) {
        winMain();
    }
}
