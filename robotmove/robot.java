// NAME: Mary Hermann && Adam Kessler
// DUE: 2/18/19
// PROJECT: Robot Animation

import java.awt.*;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.event.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class robot extends Frame
{ 
	public static void main(String[] args){new robot();}
	public static final int FLOOR = 800;

	Rectangle body, arm, hand, finger, box;

	robot(){
		super("Robot Animation");
		int bodyX =500, bodyY = 500;
		int robotMiddleX = bodyX + 100;
		int robotMiddleY = 250;
		body = new Rectangle(bodyX, bodyY, 200, 300);
		arm = new Rectangle(robotMiddleX - 25, robotMiddleY, 50, 400);
		hand = new Rectangle();
		finger = new Rectangle();
		box = new Rectangle(1200, FLOOR - 50, 50, 50);
		addWindowListener(new WindowAdapter()
         {public void windowClosing(WindowEvent e){System.exit(0);}});
		setSize(1500, 1000);
		show();
		addKeyListener(new KeyListener(){
		@Override
        public void keyPressed(KeyEvent e)
        {
        	switch(e.getKeyCode())
        	{
            	case KeyEvent.VK_RIGHT:
					if(body.getX() < 1495)
					{
						body.translate(5, 0);
						arm.translate(5, 0);
					}
					break;
	            case KeyEvent.VK_LEFT:
					if(body.getX() > 5)
					{
						body.translate(-5, 0);
						arm.translate(-5, 0);
					}
                    break;
	             case KeyEvent.VK_UP:
                    break;
                 case KeyEvent.VK_DOWN:
                    break;
            }
			repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {}

        @Override
        public void keyTyped(KeyEvent e) {}
	
		});
	}
	
	
	public void paint(Graphics g) 
    { 
		// draw initial polygons
		g.drawLine(0, 800, 1500, 800);
		g.drawRect((int) body.getX(), (int) body.getY(), (int) body.getWidth(), (int) body.getHeight());
		g.drawRect((int) arm.getX(), (int) arm.getY(), (int) arm.getWidth(), (int) arm.getHeight());
   		g.drawRect((int) box.getX(), (int) box.getY(), (int) box.getWidth(), (int) box.getHeight());
	} 
}

