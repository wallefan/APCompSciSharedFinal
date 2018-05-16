package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;

import gui.theme.Themes;

abstract class Button implements MouseListener {
	private String label;
	private String hovertext;
	private AbstractButton button; // might write in toggle buttons

	Button(String label, String hovertext) {
		button = new JButton(label);
		button.addMouseListener(this);
		button.setToolTipText(hovertext);
		Themes.button.style(button);
	}

	abstract void onClick();

	public void mousePressed(MouseEvent e) {

	}
	
	public AbstractButton getButton() {
		return button;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		onClick();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
