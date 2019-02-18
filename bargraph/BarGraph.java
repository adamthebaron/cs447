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
		setSize(1000, 1000);
		add("Center", new CvBarGraph());
		setVisible(true);
	}
}

class CvBarGraph extends Canvas
{
	private static final long serialVersionUID = 1L;
	ArrayList<BarObj> barObjs;
	int barObjsNum;
	int minx;
	int miny;
	int maxx;
	int maxy;

	CvBarGraph()
	{
		super();
		barObjs = new ArrayList<BarObj>();
	}

	public void drawRectangle(Graphics g, BarObj barObj, int offset)
	{
		Random rand = new Random();
		int r, gr, b;
		r = rand.nextInt(255);
		gr = rand.nextInt(255);
		b = rand.nextInt(255);
		Color c = new Color(r, gr, b);
		// draw rectangle
		g.setColor(c);
		g.fillRect((minx + 20) + (offset + 1) * 150, maxy - 20 - (barObj.getValue() * 100), 100, barObj.getValue() * 100);
		// add to legend
		g.fillRect(minx + 30, miny + 30 * (offset + 1), 10, 10);
		g.setColor(Color.BLACK);
		g.drawString(barObj.getName(), minx + 30, miny + 30 * (offset + 1));
		return;
	}

	public void paint(Graphics g)
	{
		Dimension d = getSize();
		maxx = d.width - 1;
		maxy = d.height - 1;
		minx = 1;
		miny = 1;

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
			g.drawString(Integer.toString(Math.round(i / 100)), minx, maxy - 20 - i);
		}
		// draw rectangles
		for(int i = 0; i < barObjs.size(); i++)
		{
			drawRectangle(g, barObjs.get(i), i);
		}
	}
}
