package first;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Field extends JPanel implements Runnable{
	private static final long serialVersionUID = 1L;
	Ball[] balls;
	Ball player;
	Client client;
	static boolean gameStart = false;
	static boolean gameOver = false;
	static int playerScore = 0;
	
	
	public Field(Ball[] balls, Ball player) {
		this.balls = balls;
		this.player = player;
		setLayout(new FlowLayout());
		
	}
	
	
	public void paint(Graphics g) {
		
		g.clearRect(0, 0, BallFrame.WIDTH, BallFrame.HEIGHT);
		g.fillOval(player.getX(), player.getY(), Ball.SIZE, Ball.SIZE);
		for (int i = 0; i < balls.length; i++) {
			g.setColor(balls[i].getColor());
			g.fillOval(balls[i].getX(), balls[i].getY(), Ball.SIZE, Ball.SIZE);
		}
		g.setColor(new Color(255, 0, 255));
		g.drawString("SCORE", 10, 30);
		g.drawString("" + playerScore, 10, 55);
		if (!gameStart && !gameOver) {
			g.drawString("SPACE TO START", player.x-30, player.y-30);
		}
		if (gameStart) {
			playerScore++;
		} 
		if (gameOver) {
			g.setColor(new Color(255, 0, 0));
			g.drawString("GAME OVER", BallFrame.WIDTH / 2-43, BallFrame.HEIGHT / 2 -43);
			g.drawString("Q TO QUIT", BallFrame.WIDTH / 2-43, BallFrame.HEIGHT / 2 -23);
		}		// 공끼리 부딪히면 gameStart는 false가 되고 gameOver은 true가 되서 화면에 글 출력
	}
	

	@Override
	public void run() {
		while(!gameOver) {		//게임오버가 !트루가 되므로 run메소드 종료
			repaint();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}}
