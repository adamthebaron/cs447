// mary hermann and adam kessler

import java.awt.*;
import java.awt.Graphics;
import java.io.*;

enum Move_T
{
	BODY, ARM, GRAB;
}

public class text
{
	private String currentMove, theta1, theta2, fullStr;

	text()
	{
		currentMove = new String();
		theta1 = new String();
		theta2 = new String();
		fullStr = new String();
	}

	public void SetCurrentMove(Move_T move)
	{
		switch(move)
		{
			case BODY:
				currentMove = "moving body";
				break;
			case ARM:
				currentMove = "rotating arm";
				break;
			case GRAB:
				currentMove = "grabbing object";
				break;
		}
	}

	public String GetString()
	{
		fullStr = "action: " + currentMove;
		return fullStr;
	}
}