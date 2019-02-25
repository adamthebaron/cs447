/* adam kessler */
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.*;
import java.util.*;

class RobotScan extends Frame
{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args)
	{
		new RobotScan();
	}

	RobotScan()
	{
		super("robot scan");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		setSize(1000, 1000);
		add("Center", new CvRobotScan());
		setVisible(true);
	}
}

class CvRobotScan extends Canvas
{
	private static final long serialVersionUID = 1L;
	int minx;
	int miny;
	int maxx;
	int maxy;
	int n;
	int xcoords[];
	int ycoords[];
	int robotpos[] = new int[2];
	int angle;
	float angles[];
	int numSensors;
	float angleDiff;
	Polygon poly;
	float curx;
	float cury;
	float increment;

	CvRobotScan()
	{
		super();
		getInput();
		curx = cury = 0;
	}

	/**
	 * this program takes an input file of the form
	 * (number of points in polygon
	 * x0, y0
	 * x1, y1
	 * ...
	 * xn, yn
	 * point of robot
	 * angle of robot
	 * number of rays
	 */
	private void getInput()
	{
		try(BufferedReader br = new BufferedReader(new FileReader("input.txt")))
		{
			String line;
			n = Integer.parseInt(br.readLine());
			System.out.println(n + " points in polygon");
			xcoords = new int[n];
			ycoords = new int[n];
			for(int i = 0; i < n; i++)
			{
				line = br.readLine();
				xcoords[i] = Integer.parseInt(line.split(" ")[0]);
				ycoords[i] = Integer.parseInt(line.split(" ")[1]);
				System.out.println("got coordinate " + xcoords[i] + " " + ycoords[i]);
			}
			line = br.readLine();
			robotpos[0] = Integer.parseInt(line.split(" ")[0]);
			robotpos[1] = Integer.parseInt(line.split(" ")[1]);
			System.out.println("robot at point " + robotpos[0] + " " + robotpos[1]);
			angle = Integer.parseInt(br.readLine());
			System.out.println("robot heading at angle " + angle);
			numSensors = Integer.parseInt(br.readLine());
			angles = new float[numSensors];
			angles[0] = 0f;
			System.out.println(numSensors + " sensors");
			System.out.println(numSensors + " scan lines:");
			angleDiff = 2 * (float) Math.PI / numSensors;
			System.out.println(angleDiff + " angle diff");

		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
		}

	}

	public void paint(Graphics g)
	{
		Dimension d = getSize();
		maxx = d.width - 1;
		maxy = d.height - 1;
		minx = 1;
		miny = 1;

		Graphics2D g2 = (Graphics2D) g;
		// draw closed polygon
		poly = new Polygon(xcoords, ycoords, n);
		g2.draw(poly);
		//draw robot
		g2.drawRect(robotpos[0], robotpos[1], 10, 10);
		increment = 0f;
		// draw scanlines
		for(int i = 1; i < numSensors; i++)
		{
			angles[i] = angles[i - 1] + angleDiff;
			System.out.println("( " + i + ") angle is at " + angles[i]);
			curx = robotpos[0] + 5;
			cury = robotpos[1] + 5;
			while(poly.contains(curx, cury))
			{
				increment += 0.001f;
				curx += angleDiff * Math.cos(angleDiff * i);
				cury += angleDiff * Math.sin(angleDiff * i);
			}
			curx -= angleDiff * Math.cos(angleDiff * i);
			cury -= angleDiff * Math.sin(angleDiff * i);
			System.out.println("boundary is at " + Math.round(curx) + " " + Math.round(cury));
			g2.drawLine(robotpos[0] + 5, robotpos[1] + 5, Math.round(curx), Math.round(cury));
		}
	}
}
