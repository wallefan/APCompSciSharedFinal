package GUI;

import java.awt.Window.Type;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;

abstract class Button implements MouseListener{
	String label;
	String hovertext;
	AbstractButton button; //might write in toggle buttons
	Button(String label,String hovertext,JPanel target){
		JButton button = new JButton(label);
		button.addMouseListener(this);
		button.setToolTipText(hovertext);
		button.setBackground(Theme.BUTTONS.backgroundColor);
		button.setForeground(Theme.BUTTONS.textColor);
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
