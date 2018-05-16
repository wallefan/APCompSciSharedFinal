package gui.theme;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

public abstract class Theme {
	// text
	protected static double fontSize = 12;
	protected static Color textColor = Color.BLACK;
	protected static Font font = new Font(null, 0, 0);
	// background
	protected static Color backgroundColor = Color.WHITE;
	protected static boolean opaque = false;
	// border
	protected static AbstractBorder border = new EmptyBorder(0, 0, 0, 0);
	protected static Color borderColor = Color.BLACK;
	
	public static void style(JComponent component) {
		component.setOpaque(opaque);
		component.setBorder(border);
		component.setFont(font);
		component.setBackground(backgroundColor);
		// component.setFont(label.getFont().deriveFont((float) this.fontSize));// ugly
		// code to set font size
		// component.setForeground(this.textColor);
	}

	private Theme() {// Java adds an implicit public constructor to every class which does not define
						// at least one explicitly
	}
}
