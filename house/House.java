/* adam kessler */
import java.awt.*;
import java.awt.event.*;

class House extends Frame
{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args)
	{
		new House();
	}

	House()
	{
		super("house");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		setSize(1024, 1024);
		add("Center", new CvHouse());
		setVisible(true);
	}
}

class CvHouse extends Canvas
{
	private static final long serialVersionUID = 1L;
	public void drawCircle(Graphics g, int x, int y, int r)
	{
		x = x - (r / 2);
		y = y - (r / 2);
		g.fillOval(x, y, r, r);
	}

	public void paint(Graphics g)
	{
		Dimension d = getSize();
		int maxx = d.width - 1;
		int maxy = d.height - 1;
		int minx = 1;
		int miny = 1;
		// create sky
		g.setColor(new Color(91, 121, 255));
		g.fillRect(minx, miny, maxx, maxy);
		// create grass
		g.setColor(new Color(28, 147, 11));
		g.fillRect(0, 2 * Math.round(maxy / 3) + 100,
					maxx, Math.round(maxy / 3));
		// create house frame
		g.setColor(new Color(135, 1, 5));
		g.fillRect(Math.round(maxx / 4), 2 * Math.round(maxy / 3) - 300,
				   400, 400);
		int[] xpoints = new int[]{
			Math.round(maxx / 4),
			Math.round(maxx / 4) + 200,
			Math.round(maxx / 4) + 400
		};
		int[] ypoints = new int[]{
			2 * Math.round(maxy / 3) - 300,
			2 * Math.round(maxy / 3) - 400,
			2 * Math.round(maxy / 3) - 300
		};
		g.setColor(Color.lightGray);
		g.fillPolygon(xpoints, ypoints, 3);
		// create tree trunk
		g.setColor(new Color(139, 69, 19));
		xpoints = new int[]{
			maxx - Math.round(maxx / 4),
			maxx - Math.round(maxx / 4) + 10,
			maxx - Math.round(maxx / 4) + 10,
			maxx - Math.round(maxx / 4) + 60,
			maxx - Math.round(maxx / 4) + 60,
			maxx - Math.round(maxx / 4) + 70
		};
		ypoints = new int[]{
			2 * Math.round(maxy / 3) + 100,
			2 * Math.round(maxy / 3) + 100 - 10,
			2 * Math.round(maxy / 3) + 100 - 360,
			2 * Math.round(maxy / 3) + 100 - 360,
			2 * Math.round(maxy / 3) + 100 - 10,
			2 * Math.round(maxy / 3) + 100
		};
		g.fillPolygon(xpoints, ypoints, 6);
		// create tree leaves
		g.setColor(new Color(28, 147, 11));
		g.fillOval(maxx - Math.round(maxx / 4), 2 * Math.round(maxy / 3) - 350, 100, 100);
		g.fillOval(maxx - Math.round(maxx / 4) - 50, 2 * Math.round(maxy / 3) - 350, 100, 100);
		g.fillOval(maxx - Math.round(maxx / 4), 2 * Math.round(maxy / 3) - 325, 100, 100);
		g.fillOval(maxx - Math.round(maxx / 4) - 50, 2 * Math.round(maxy / 3) - 325, 100, 100);
		g.fillOval(maxx - Math.round(maxx / 4), 2 * Math.round(maxy / 3) - 300, 100, 100);
		g.fillOval(maxx - Math.round(maxx / 4) - 75, 2 * Math.round(maxy / 3) - 325, 100, 100);
		g.fillOval(maxx - Math.round(maxx / 4) + 10, 2 * Math.round(maxy / 3) - 300, 100, 100);
		// create door and windows
		g.setColor(new Color(40, 26, 13));
		g.fillRect(Math.round(maxx / 2) - 100, 2 * Math.round(maxy / 3) - 50, 100, 150);
		g.setColor(Color.white);
		g.fillRect(Math.round(maxx / 2) - 200, Math.round(maxy / 3) + 100, 75, 75);
		g.fillRect(Math.round(maxx / 2) + 25, Math.round(maxy / 3) + 100, 75, 75);
		// create sun
		g.setColor(Color.yellow);
		g.fillOval(minx - 50, miny - 50, 200, 200);
	}
}