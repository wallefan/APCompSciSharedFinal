package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;

abstract class Button implements MouseListener{
	String label;
	String hovertext;
	JButton button;
	Button(String label,String hovertext,Theme theme,JLabel target){
		JButton button = new JButton(label);
		button.addMouseListener(this);
	}
	abstract void onClick();
	public void mousePressed(MouseEvent e) {
		onClick();
	}
}
