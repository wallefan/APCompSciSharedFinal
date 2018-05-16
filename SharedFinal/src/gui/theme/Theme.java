package gui.theme;

import java.awt.Color;
import java.awt.Component;
import java.awt.TextField;

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
	// layout
	protected float alignmentY = Component.CENTER_ALIGNMENT;
	protected float alignmentX = Component.LEFT_ALIGNMENT;

	public void style(JComponent... components) {
		for (JComponent component : components) {
			component.setOpaque(opaque);
			component.setBorder(border);
			component.setBackground(backgroundColor);
			component.setForeground(textColor);
			component.setFont(component.getFont().deriveFont(fontSize));// ugly
			component.setAlignmentX(alignmentX);
			component.setAlignmentY(alignmentY);
		}
	}

	Theme() {
		jank();
	}
	
	Theme(Theme from){//TODO probably a better way to do this
		fontSize=from.fontSize;
		textColor=from.textColor;
		backgroundColor=from.backgroundColor;
		opaque=from.opaque;
		border=from.border;
		borderColor=from.borderColor;
		alignmentX=from.alignmentX;
		alignmentY=from.alignmentY;
		jank();
	}

	abstract void jank();

	/**
	 * <b>WILL NOT WORK WITH ANY BORDER!</b>
	 */
	protected void setPadding(int top, int left, int bottom, int right) {
		border = new EmptyBorder(top, left, bottom, right);
	}

	/**
	 * <b>WILL NOT WORK WITH ANY BORDER!</b>
	 * 
	 * @param padding
	 */
	protected void setPadding(int padding) {
		setPadding(padding, padding, padding, padding);
	}

	
}
