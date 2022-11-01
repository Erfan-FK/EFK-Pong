package Pong;

import java.awt.*;


public class Score extends Rectangle {

    static int width;
    static int height;

    // Player scores
    int player1;
    int player2;
    
    Score(int WIDTH, int HEIGHT) {
        Score.width = WIDTH;
        Score.height = HEIGHT;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 60));

        // Dashed line
        Stroke dashed = new BasicStroke(4, BasicStroke.CAP_BUTT,  BasicStroke.JOIN_BEVEL, 0, new float[]{25}, 30);
        g2d.setStroke(dashed);
        g2d.drawLine(width/2, 0, width/2, height);

        // Scores
        g.drawString(String.valueOf(player1/10) + String.valueOf(player1%10), width/2  - 85 , 50);
        g.drawString(String.valueOf(player2/10) + String.valueOf(player2%10), width/2  + 20 , 50);
    }
}
