/* adam kessler */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

class CircleApprox extends Frame
{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args)
	{
		new CircleApprox();
	}

	CircleApprox()
	{
		super("approximate circle");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		setSize(1000, 1000);
		add("Center", new CvCircleApprox());
		setVisible(true);
	}
}

class CvCircleApprox extends Canvas
{
	private static final long serialVersionUID = 1L;
	int minx;
	int miny;
	int maxx;
	int maxy;

	CvCircleApprox()
	{
		super();
	}

	public void paint(Graphics g)
	{
		Dimension d = getSize();
		maxx = d.width - 1;
		maxy = d.height - 1;
		minx = 1;
		miny = 1;

		
	}
}
