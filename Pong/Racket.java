package Pong;

import java.awt.*;
import java.awt.event.*;

public class Racket extends Rectangle {

    // racket ids
    int id;

    // speed of racket through y axis
    int yVelocity;

    int speed = 10;

    Racket(int x, int y, int RACKET_WIDTH, int RACKET_HEIGHT, int id) {
        super(x, y, RACKET_WIDTH, RACKET_HEIGHT);
        this.id = id;

    }

    public void keyPressed(KeyEvent e) {
        switch(id) {
        case 1:
            if (e.getKeyCode() == KeyEvent.VK_W){
                setY(-speed);
                move();
            }
            if (e.getKeyCode() == KeyEvent.VK_S){
                setY(speed);
                move();
            }
            break;

        case 2:
            if (e.getKeyCode() == KeyEvent.VK_UP){
                setY(-speed);
                move();
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN){
                setY(speed);
                move();
            }
            break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch(id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W){
                    setY(0);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_S){
                    setY(0);
                    move();
                }
                break;
    
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    setY(0);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    setY(0);
                    move();
                }
                break;
            }
    }

    public void setY(int yDirection) {
        yVelocity = yDirection;
    }

    public void move() {
        y += yVelocity;
    }

    public void draw(Graphics g) {
        if (id == 1){
            g.setColor(new Color(0x2DA8D8));
        }
        else {
            g.setColor(new Color(0xD9514E));
        }
        g.fillRect(x, y, width, height);

    }
}
