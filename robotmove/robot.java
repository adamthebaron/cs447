// NAME: Mary Hermann && Adam Kessler
// DUE: 2/18/19
// PROJECT: Robot Animation

import java.awt.*;
import java.awt.Color;
import java.awt.event.*;

public class robot extends Frame
{ 
	public static void main(String[] args){new robot();}
	
	robot(){ 
		super("Robot Animation");
		addWindowListener(new WindowAdapter()
         {public void windowClosing(WindowEvent e){System.exit(0);}});
		setSize(1500, 1000);
		show();
	}
	
	
	public void paint(Graphics g) 
    { 
		g.drawLine(0, 800, 1500, 800);
		int bodyX =500, bodyY = 500;
		g.drawRect(bodyX, bodyY, 200, 300);
		int robotMiddleX = bodyX+((bodyX+200-bodyX)/2);
		int robotMiddleY = 250;
		g.drawRect(robotMiddleX-25, robotMiddleY, 50, 400);
		
    } 
	
	
}

