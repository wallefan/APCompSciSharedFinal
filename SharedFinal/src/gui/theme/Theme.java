package gui.theme;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

public abstract class Theme {
	// text
	protected float fontSize = 12;
	protected Color textColor = Color.BLACK;
	// background
	protected Color backgroundColor = Color.WHITE;
	protected boolean opaque = false;
	// border
	protected AbstractBorder border = new EmptyBorder(0, 0, 0, 0);
	protected Color borderColor = Color.BLACK;
	//layout
	protected float alignmentY = Component.CENTER_ALIGNMENT;
	protected float alignmentX = Component.LEFT_ALIGNMENT;

	public void style(JComponent component) {
		component.setOpaque(opaque);
		component.setBorder(border);
		component.setBackground(backgroundColor);
		component.setForeground(textColor);
		component.setFont(component.getFont().deriveFont(fontSize));// ugly
		component.setAlignmentX(alignmentX);
		component.setAlignmentY(alignmentY);
	}
	
	Theme(){
		jank();
	}
	
	abstract void jank();
}
