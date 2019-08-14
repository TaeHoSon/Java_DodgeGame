package first;

import java.util.Random;

public class DiagonalMoveStrategy extends DirectionStrategy{
	public void move(Ball ball) {
		int x;
		int y;
		Random r = new Random();
		x = r.nextInt(Ball.INTERVAL)+1;
		y = r.nextInt(Ball.INTERVAL)+1;
		ball.setIntervals(x, y);	
	}
}
