package Pong;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Panel extends JPanel implements Runnable{
    
    // Our pong panel with original ratio of pong table
    static final int WIDTH = 1000;
    static final int HEIGHT = (int)(WIDTH * 5.0/9.0);

    // Our screen dimension
    static final Dimension SCREEN = new Dimension(WIDTH, HEIGHT);

    // Our ball dimension
    static final int BALL_DIAMETER = 20;

    // Racket dimensions
    static final int RACKET_WIDTH = 25;
    static final int RACKET_HEIGHT = 100;

    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Racket racket1;
    Racket racket2;
    Ball ball;
    Score score;
    
    Panel(){
        newRackets();
        newBall();
        score = new Score(WIDTH, HEIGHT);

        // Read key presses and be focusable
        this.setFocusable(true);

        this.addKeyListener(new AL());

        this.setPreferredSize(SCREEN);

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newRackets() {
        racket1 = new Racket(0, (HEIGHT - RACKET_HEIGHT) / 2, RACKET_WIDTH, RACKET_HEIGHT, 1);
        racket2 = new Racket(WIDTH - RACKET_WIDTH, (HEIGHT - RACKET_HEIGHT) / 2, RACKET_WIDTH, RACKET_HEIGHT, 2);

    }

    public void newBall() {
        random = new Random();
        ball = new Ball((WIDTH - BALL_DIAMETER) / 2, random.nextInt(HEIGHT - BALL_DIAMETER), BALL_DIAMETER, BALL_DIAMETER);
    }

    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);

    }

    public void draw(Graphics g) {
        racket1.draw(g);
        racket2.draw(g);
        ball.draw(g);
        score.draw(g);

        Toolkit.getDefaultToolkit().sync();
    }

    public void move() {
        // Make movements smoother
        racket1.move();
        racket2.move();
        ball.move();
    }

    public void isCollision() {
        // limit ball movements with edges
        if (ball.y <= 0) {
            ball.setY(-ball.yVelocity);
                        
        }
        if (ball.y >= HEIGHT - BALL_DIAMETER) {
            ball.setY(-ball.yVelocity);
                    
        }

        // Limit rackets movement 
        if (racket1.y <= 0) {
            racket1.y = 0;
        }
        if (racket1.y >= (HEIGHT - RACKET_HEIGHT)) {
            racket1.y = HEIGHT - RACKET_HEIGHT;
        }

        if (racket2.y <= 0) {
            racket2.y = 0;
        }
        if (racket2.y >= (HEIGHT - RACKET_HEIGHT)) {
            racket2.y = HEIGHT - RACKET_HEIGHT;
        }

        // check ball movements with rackes
        if (ball.intersects(racket1)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            
            // add difficulty
            ball.xVelocity++;
            if (ball.yVelocity > 0 ) {
                ball.yVelocity++;
            }
            else{
                ball.yVelocity--;
            }

            ball.setX(ball.xVelocity);
            ball.setY(ball.yVelocity);
        }

        if (ball.intersects(racket2)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            
            // add difficulty
            ball.xVelocity++;
            if (ball.yVelocity > 0 ) {
                ball.yVelocity++;
            }
            else{
                ball.yVelocity--;
            }

            ball.setX(-ball.xVelocity);
            ball.setY(ball.yVelocity);
        }

        // count points
        if (ball.x <= 0) {
            score.player2++;
            newRackets();
            newBall();
        }

        if (ball.x >= WIDTH - BALL_DIAMETER) {
            score.player1++;
            newRackets();
            newBall();
        }
    }

    public void run() {
        // Loop
        long lastTime = System.nanoTime();
        double amountOfTickets = 60.0;
        double ns = 1000000000 / amountOfTickets;
        double delta = 0;
        
        while(true){
            long now =System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                move();
                isCollision();
                repaint();
                delta--;
            }
        }
    }

    // Action Listener Class
    public class AL extends KeyAdapter{

        public void keyPressed(KeyEvent e) {
            racket1.keyPressed(e);
            racket2.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            racket1.keyReleased(e);
            racket2.keyReleased(e);
        }        
    }
}
