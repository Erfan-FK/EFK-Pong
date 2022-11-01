package Pong;

import java.awt.*;
import java.util.*;

public class Ball extends Rectangle{

    Random random;
    
    // Balls speed through both y and x axiss 
    int xVelocity;
    int yVelocity;
    int ballspeed = 2;

    Ball(int x, int y, int width, int height) {
        super(x, y, width, height);
        random = new Random();
        
        int randomXDirection = random.nextInt(2);        
        if (randomXDirection == 0) {
            randomXDirection--;
        }
        setX(randomXDirection * ballspeed);

        int randomYDirection = random.nextInt(2);        
        if (randomYDirection == 0) {
            randomYDirection--;
        }
        setY(randomYDirection * ballspeed);
    }

    public void setX(int randomXDirection) {
        xVelocity = randomXDirection;
    }

    public void setY(int randomYDirection) {
        yVelocity = randomYDirection;
    }

    public void move() {
        x += xVelocity;
        y += yVelocity;
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(x, y, height, width);
    }
}
