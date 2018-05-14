package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

abstract class Button implements MouseListener{
	String label;
	String hovertext;
	JButton button;
	Button(String label,String hovertext,Theme theme,JPanel target){
		JButton button = new JButton(label);
		button.addMouseListener(this);
		button.setToolTipText(hovertext);
		target.add(button);
	}
	abstract void onClick();
	public void mousePressed(MouseEvent e) {
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		onClick();
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
