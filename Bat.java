package tennis;

import java.awt.*;

public class Bat{

	int batY;
	int batX = 1;

	public Bat(int batX, int batY) {

		this.batX = batX;
		this.batY = batY;
	}

	public void moveBat(boolean upPressed, boolean downPressed) {
		if (upPressed)
			if (batY > 25)
				batY -= 5;

		if (downPressed)
			if (batY + 100 < 600)
				batY += 5;
	}

	public void drawBat(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(batX, batY, 20, 100);
	}
	
	public int getbatX() {
	    return batX;
	     }
	public int getbatY() {
	    return batY;
	     }
	public int getWt() {
	    return 20;
	     }
	public int getHt() {
	    return 100;
	     }
	
}
