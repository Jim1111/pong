package tennis;

import java.awt.*;

import java.awt.event.*;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

public class Game extends JFrame implements Runnable, KeyListener {

	int sc1 = 0;
	int sc2 = 0;

	Bat batLeft, batRt;

	Ball ball;

	boolean upPressed, downPressed, rightP, leftP;

	public Game() {
		setTitle("Tennis");
		setBackground(Color.green);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addKeyListener(this);
		setSize(600, 600);
		setVisible(true);
		createBufferStrategy(2);

		batLeft = new Bat(10, 100);
		batRt = new Bat(570, 100);

		ball = new Ball();
	}

	public void run() {
		while (true) {
			drawObjects();
			try {
				Thread.sleep(10); // redraw each frame after 1-mS
			} catch (InterruptedException e) {
			}
		}
	}

	// this method is called whenever a key is pressed

	public void keyPressed(KeyEvent key) {

		if (key.getKeyCode() == KeyEvent.VK_DOWN)
			downPressed = true;
		if (key.getKeyCode() == KeyEvent.VK_UP)
			upPressed = true;
		if (key.getKeyCode() == KeyEvent.VK_K)
			rightP = true;
		if (key.getKeyCode() == KeyEvent.VK_M)
			leftP = true;
	}

	// this method is called whenever a key is released

	public void keyReleased(KeyEvent key) {
		if (key.getKeyCode() == KeyEvent.VK_DOWN)
			downPressed = false;
		if (key.getKeyCode() == KeyEvent.VK_UP)
			upPressed = false;

		if (key.getKeyCode() == KeyEvent.VK_K)
			rightP = false;
		if (key.getKeyCode() == KeyEvent.VK_M)
			leftP = false;
	}

	// this method is called whenever a key is typed
	// not using it here
	public void keyTyped(KeyEvent key) {
	}

	private void drawObjects() {
		BufferStrategy bf = getBufferStrategy();
		Graphics g = bf.getDrawGraphics();
		// first clear the screen
		g.clearRect(0, 0, getWidth(), getHeight());

		batLeft.moveBat(upPressed, downPressed);
		batRt.moveBat(rightP, leftP);

		batLeft.drawBat(g);
		batRt.drawBat(g);

		int wallHit = ball.moveBall(getWidth(), getHeight());

		if (wallHit == 1) {
			sc1 = sc1 + 1;
		} else if (wallHit == 2) {

			sc2 = sc2 + 1;
		}

		ball.collLeftBat(batLeft.getbatX(), batLeft.getWt(), batLeft.getbatY(),
				batLeft.getHt());

		ball.collRtBat(batRt.getbatX(), batRt.getWt(), batRt.getbatY(),
				batLeft.getHt());

		ball.drawBall(g);

		g.setColor(Color.blue);
		g.setFont(new Font("Ariel", Font.PLAIN, 20));

		g.drawString("Score player 1: " + sc1, 15, 50);
		g.drawString("Score player 2: " + sc2, 430, 50);

		// Show the new image
		g.dispose();
		bf.show();
		Toolkit.getDefaultToolkit().sync();
	}
}
