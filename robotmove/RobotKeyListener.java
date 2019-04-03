import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class RobotKeyListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e)
        {
			switch(e.getKeyCode())
			{
				case VK_RIGHT:
					break;
				case VK_LEFT:
					break;
				case VK_UP:
					break;
				case VK_DOWN:
					break;
			}
        }

		@Override
		public void keyReleased(KeyEvent e) {}

		@Override
		public void keyTyped(KeyEvent e) {}
}
