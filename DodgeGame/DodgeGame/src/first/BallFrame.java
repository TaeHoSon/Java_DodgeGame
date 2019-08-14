package first;

import java.awt.BorderLayout;
import static first.Client.player;
import static first.Field.playerScore;
import static first.Field.gameOver;
import static first.Field.gameStart;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class BallFrame extends JFrame implements KeyListener, MouseMotionListener{
	private static final long serialVersionUID = 1L;
	public static int WIDTH = 630;
	public static int HEIGHT = 630;
	private Field field;
	boolean moving = false;
	int playerX, playerY;
	
	
	public BallFrame(Ball[] balls, Ball player) {
		super("Dodge Game");
		System.out.println("Frame created");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                	gameStart = true;
                	for (int i = 0; i < balls.length; i++) {	// addkeyListener로 스페이스바를 눌럿을때
        				balls[i].draw();						// 게임이 시작된다.
        				balls[i].move();
        			} 
                }
         	   if (e.getKeyCode() == KeyEvent.VK_D) { 
        		   player.x = player.x + 7;
        			}
        	   else if (e.getKeyCode() == KeyEvent.VK_W) {
        		   player.y = player.y - 7;					// 플레이어 공이 움직이게 해준다.
        	   }
        	   else if (e.getKeyCode() == KeyEvent.VK_A) {
        		   player.x = player.x - 7;
        	   }
        	   else if (e.getKeyCode() == KeyEvent.VK_S) {
        		   player.y = player.y + 7;
        	   }
        	   else if (gameOver == true && e.getKeyCode() == KeyEvent.VK_Q) {
        		   System.exit(0);
        	   }
        	  
            }	
        });
		
		addMouseMotionListener(this);
		field = new Field(balls, player);
		Thread th = new Thread(field);
		th.start();
		
		add(field, BorderLayout.CENTER);
		setFocusable(true);
		setSize(WIDTH, HEIGHT+38);
		setVisible(true);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
        }


	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		player.x = e.getX();		// 스윙의 키이벤트 한계로 게임을 매끄럽게 해보기 위해
		player.y = e.getY();		// 마우스도 추가
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}
	

}
