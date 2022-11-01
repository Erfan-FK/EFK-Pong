# EFK PONG
#### Video Demo:  <URL https://www.youtube.com/watch?v=FOJewd8S9tc>
#### Description: EFK Pong is a 2-player game which is the revision of old-fashioned and astonishing game **PONG**.

Hello Everyone, Erfan here. I am from Tabriz, Iran. Currently i am a freshman in Bilkent University located in Ankara Turkey. I am
studying Computer Science and i have to say that it was a real pleasure to take this course.

Controls used in this game in order to play it are WASD keys and arrow keys. Using the WASD you can control the racket in the left side
and using arrow keys you can control the racket in the right side. There is score limit for win or loss. However, there is score and
whenever the ball touchs the your side walls, oppent achieve one point and game starts again.

The programming language which i used to code and develop this simple game is Java. Also i took advantege of some libraries such as Java
AWT which i used for user interfaces.

About the source code, in total there are 6 java files:

Pong.java, this file is the main file where my main method exists and my code executes.
In this file i created the object of my second file, Frame.java.

Frame.java, this file is my game frame file. First of all, in this file i created the object of my third file which is Panel.java.
Briefly, this file creates a frame for us in our window to display our game.

Panel.java, this file is the most important file of my project. It has all compenents and elements of the game such as rackets, ball and
score. It also has the game loop. in addition to game loop, it has the functions of drawing and displaying the element in the frame.
There are several functions and methods in this file and one of the most important ones is iscollosion(). This method checks for the
collision of our ball with border and alswo with rackets and whenever there is a collosion it bounces the ball back. It also checks for
the position of our rackets and limits their movement. Another function in this file is run() which has my gameloop. And finally there
is another class in this file which extends KeyAdapter which gives us the ability to use our keyboard keys.

Racket.java, is the file which has our rackets code and its drawing function which displays and animates the rackets in frame. other
methods in Racket.java are keyPressed and keyRealesd. These methods handle the key press and release actions of the players in keyboard.

Score.java, is the file which has the code of our score and it displays and updates the score. The method in this file is draw which in
fact divides the frame to two parts from the center of the width and draw a dashed line there and displays the each players score in
each side of this dashed line.

Ball.java, is the last file which has the code of ball and it displays and moves the ball. This file also has two other methods called
setX and setY. these methods handle the duty of balls positioning on the screen and they are used in Panel.java to change the direction
of ball and bounce it when there is collision.

That's it.

Thank you.

THIS WAS CS50!
