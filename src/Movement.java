import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JPanel;

public class Movement implements MouseListener, MouseMotionListener{
	private int x,y;
	
	public Movement(ArrayList<JLabel> lst) {
		for (JLabel panel:lst) {
			panel.addMouseListener(this);
			panel.addMouseMotionListener(this);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		e.getComponent().setLocation((e.getX()+e.getComponent().getX()-x), (e.getY()+e.getComponent().getY()-y));
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x= e.getX();
		y = e.getY();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}


