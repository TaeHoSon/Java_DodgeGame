package first;

import java.awt.Color;
import static first.Client.player;
import static first.Field.gameStart;
import static first.Field.gameOver;


public class Ball extends Thread{
	public static final int SIZE = 20;
	public static final int INTERVAL = 17;	//�ӵ�
	int x, y;
	int xInterval, yInterval;
	DirectionStrategy direction;
	DrawStrategy draws;
	Color color;
	
	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setIntervals(int xInterval, int yInterval) {
		this.xInterval = xInterval;
		this.yInterval = yInterval;
	}

	public void setDirection(DirectionStrategy direction) {
		this.direction = direction;
	}

	public void setDraw(DrawStrategy draws) {
		this.draws = draws;
	}
	
	public void move() {
		direction.move(this);
	}
	
	public void draw() {
		draws.draw(this);
	}
	
	

	public void run() {	
		while(!gameOver) {		//�ε������� gameOver�� Ʈ��Ǹ鼭 ������ ����
			x = x+xInterval;
			y = y+yInterval;
			
			if ((x < 0 && xInterval < 0) || x + Ball.SIZE > BallFrame.WIDTH - 15 && xInterval>0) {
				xInterval = -xInterval;	
			}
			if ((y < 0 && yInterval < 0)|| y + Ball.SIZE > BallFrame.HEIGHT - 15 && yInterval>0) {
				yInterval = -yInterval;
				
			}
			
			if (x-15 <= player.x && player.x <= x+15 && y-15 <= player.y && player.y <= y +15) {	
				System.out.println("������");
				gameOver = true;			// �Ϻη� x��ǥ�� y��ǥ�� 15�� ���� ��ü�� ũ�⿡ �ε����� �Ͽ���.
				gameStart = false;
				
			}
			
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}
