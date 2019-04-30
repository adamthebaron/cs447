// NAME: Mary Hermann && Adam Kessler
// DUE: 2/18/19
// PROJECT: Robot Animation

import java.awt.*;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.event.*;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.event.KeyEvent;

public class robot extends Frame
{ 
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new robot();
	}
	public static final int FLOOR = 800;

	Rectangle body, arm1, arm2, hand, finger, box, claw1, claw2;
	AffineTransform at, ot;
	double theta;
	text t;

	robot(){
		super("Robot Animation");
		int bodyX =500, bodyY = 500;
		int robotMiddleX = bodyX + 100;
		int robotMiddleY = 150;
		theta = 0.0;
		body = new Rectangle(bodyX, bodyY, 200, 300);
		arm1 = new Rectangle(robotMiddleX - 25, robotMiddleY, 50, 400);
		arm2 = new Rectangle((int) arm1.getX(), (int) arm1.getY(), 200, 50);
		hand = new Rectangle();
		finger = new Rectangle();
		box = new Rectangle(1200, FLOOR - 50, 50, 50);
		claw1 = new Rectangle();
		claw2 = new Rectangle();
		t = new text();
		at = new AffineTransform();
		addWindowListener(new WindowAdapter()
         {public void windowClosing(WindowEvent e){System.exit(0);}});
		setSize(1500, 1000);
		setVisible(true);
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
						arm1.translate(5, 0);
					}
					t.SetCurrentMove(Move_T.BODY);
					break;
	            case KeyEvent.VK_LEFT:
					if(body.getX() > 5)
					{
						body.translate(-5, 0);
						arm1.translate(-5, 0);
					}
					t.SetCurrentMove(Move_T.BODY);
                    break;
				 case KeyEvent.VK_UP:
					if(theta > 0.0)
					{
						theta -= 5;
					}
					t.SetCurrentMove(Move_T.ARM);
                    break;
				 case KeyEvent.VK_DOWN:
				 	if(theta < 180.0)
					{
						theta += 5;
					}
					t.SetCurrentMove(Move_T.ARM);
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
		// draw body
		g.drawRect((int) body.getX(), (int) body.getY(), (int) body.getWidth(), (int) body.getHeight());
		// draw arm
		Graphics2D g2 = (Graphics2D) g;
		AffineTransform oldtransform = g2.getTransform();
		g2.rotate(Math.toRadians(theta), body.getX() + body.getWidth() / 2, body.getY());
		g.drawRect((int) arm1.getX(), (int) arm1.getY(), (int) arm1.getWidth(), (int) arm1.getHeight());
		g.drawRect((int) arm2.getX(), (int) arm2.getY(), (int) arm2.getWidth(), (int) arm2.getHeight());
		g2.setTransform(oldtransform);
		// draw box
		g.drawRect((int) box.getX(), (int) box.getY(), (int) box.getWidth(), (int) box.getHeight());
		g.drawString(t.GetString(), 100, 300);
	} 
}

