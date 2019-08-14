package first;

import first.Ball;
import first.BallFrame;
import first.BlueDrawStrategy;
import first.DiagonalMoveStrategy;

public class Client{
	int BALL_COUNT = 13;
	int X_LOCATION[] = new int[BALL_COUNT];
	int Y_LOCATION[] = new int[BALL_COUNT];
	Ball balls[] = new Ball[BALL_COUNT];
	static Ball player;
	BallFrame ballFrame;
	
	public Client() {
		
		player = new Ball((BallFrame.WIDTH-43) / 2 , (BallFrame.HEIGHT-43) / 2);
		
		for (int i = 0; i < balls.length; i++) {
			if ( i % 2 ==0) {
				X_LOCATION[i] = (int)(Math.random()*2)* BallFrame.WIDTH; 
				Y_LOCATION[i] = (int)(Math.random()* BallFrame.HEIGHT);
				for (int j = 0; j < i; j++) {
					if (X_LOCATION[i] == 630) {
						X_LOCATION[i] = X_LOCATION[i] - 43;	//프레임을 맞춰도 공이 안보이는걸 시각적 효과를 높이기 위해
						break;
					}
					if (X_LOCATION[i] == X_LOCATION[j] && Y_LOCATION[i] == Y_LOCATION[j]) {
						if ( i == 0) {
							i =0;	
						} else {			//공의 위치가 중복되지 않게 하기 위해
							i = i-1;
						}
						break;
					}
				}
			} else {
				X_LOCATION[i] = (int)(Math.random()* BallFrame.WIDTH); 
				Y_LOCATION[i] = (int)(Math.random() * 2) * BallFrame.HEIGHT;
				for (int j = 0; j < i; j++) {
					if (Y_LOCATION[i] == 630) {
						Y_LOCATION[i] = Y_LOCATION[i] - 43;
						break;
					}
					if (X_LOCATION[i] == X_LOCATION[j] && Y_LOCATION[i] == Y_LOCATION[j]) {
						if ( i == 0) {
							i =0;
						} else {
							i = i-1;
						}
						break;
					}
				}
				
			}
			balls[i] = new Ball(X_LOCATION[i], Y_LOCATION[i]);
			balls[i].setDirection(new DiagonalMoveStrategy());
			balls[i].setDraw(new BlueDrawStrategy());
			balls[i].start();
			
		}
		
		new BallFrame(balls, player);	
	}
	
	
	
	public static void main(String[] args) {
		new Client(); 
}
}
