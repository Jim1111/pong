package tennis;

import java.awt.*;

public class Ball {

	int x = 200; //
	int y = 200;
	int xa = 1;
	int ya = 1;

	public int moveBall(int winWidth, int winHt) {

		int score = 0;

		if (x > winWidth - 20) {
			xa = -xa;
			score = 1;
		}
		if (x < 0) {
			xa = -xa;
			score = 2;
		}

		x = x + xa;

		if (y > winHt - 20) {
			ya = -ya;
		}

		if (y < 0) {
			ya = -ya;
		}

		y = y + ya;
		return score;

	}

	public void drawBall(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval(x, y, 20, 20); // ball object
	}

	public void collLeftBat(int batX, int batWidth, int batY, int batHt) {
		if ((x <= batX + batWidth) && (y + 20 > batY) && (y <= batY + batHt)) {
			x = batX + batWidth;
			xa = -xa;
		}
	}

	public void collRtBat(int batX, int batWidth, int batY, int batHt) {

		if ((x + 20 > batX) && (y + 20 > batY) && (y <= batY + batHt)) {
			xa = -xa;
		}
	}
}
