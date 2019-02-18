/* adam kessler */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

class BarGraph extends Frame
{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args)
	{
		new BarGraph();
	}

	BarGraph()
	{
		super("bargraph");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		setSize(1024, 1024);
		add("Center", new CvBarGraph());
		setVisible(true);
	}
}

class CvBarGraph extends Canvas
{
	private static final long serialVersionUID = 1L;
	ArrayList<BarObj> barObjs;
	int barObjsNum;

	CvBarGraph()
	{
		super();
		barObjs = new ArrayList<BarObj>();
	}

	public void drawRectangle(Graphics g, int height)
	{
		Random rand = new Random();
		int r, gr, b;
		r = rand.nextInt(255);
		gr = rand.nextInt(255);
		b = rand.nextInt(255);
		Color c = new Color(r, gr, b);
		g.setColor(c);
		return;
	}

	public void paint(Graphics g)
	{
		Dimension d = getSize();
		int maxx = d.width - 1;
		int maxy = d.height - 1;
		int minx = 1;
		int miny = 1;
		// read input from file
		try(BufferedReader br = new BufferedReader(new FileReader("input.txt")))
		{
			String line;
			String name;
			int value;
			while((line = br.readLine()) != null)
			{
				name = line.split(" ")[0];
				value = Integer.parseInt(line.split(" ")[1]);
				System.out.println("adding " + name + " " + Integer.toString(value));
				BarObj b = new BarObj(name, value);
				barObjs.add(b);
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
		}
		// draw x and y axes
		g.drawLine(minx + 20, miny + 20, minx + 20, maxy - 20);
		g.drawLine(minx + 20, maxy - 20, maxx - 10, maxy - 20);

		// draw a hashmark every 100 pixels
		for(int i = 0; i <= maxy; i += 100)
		{
			g.drawLine(minx + 20, maxy - 20 - i, minx + 15, maxy - 20 - i);
			g.setColor(Color.BLACK);
			g.drawString(Integer.toString(Math.round(i / 10)), minx, maxy - 20 - i);
		}
		// draw rectangles

	}
}
