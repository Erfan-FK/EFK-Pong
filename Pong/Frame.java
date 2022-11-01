package Pong;

import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame{
   
    // Our Game Panel
    Panel panel;

    Frame(){
        panel = new Panel();

        // Add panel
        this.add(panel);

        // Add title
        this.setTitle("EFK PONG");

        // Prevent resizing
        this.setResizable(false);

        // Set background Color
        this.setBackground(new Color(0x2A2B2D));

        // Close app when X clicked
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Fit game panel
        this.pack();

        // Make panel visible
        this.setVisible(true);

        // Display panel
        this.setLocationRelativeTo(null);
    }
}
