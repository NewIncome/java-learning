import javax.swing.*;

import gui.Screen;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Screen  screen = new Screen();
        screen.setVisible(true);    //to make the main screen appear
        screen.setLocationRelativeTo(null);     //appears in the center

    }
}
