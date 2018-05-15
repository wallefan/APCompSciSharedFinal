package GUI;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public enum Theme{
	TITLE(0x444444,0xDDDDDD,20,5),
	BODY(0x222222,0xFFFFFF,12,3),
	BUTTONS(0x000000,0xCCCCCC,12,8);
	Color backgroundColor;
	Color textColor;
	int fontSize;
	int padding;
	/**
	 * @param textColorHex - text color as hex int, write as 0x00FF00
	 * @param backgroundColorHex - background color as hex int, write as 0x00FF00
	 * @param fontsize
	 */
	Theme(int textColorHex,int backgroundColorHex,int fontsize,int padding){
		this.textColor = new Color(textColorHex);
		this.backgroundColor = new Color(backgroundColorHex);
		this.fontSize = fontsize;
		this.padding=padding;
	}
	public JLabel makeLabel() {
		JLabel label = new JLabel();
		label.setOpaque(true);
		label.setBorder(new EmptyBorder(this.padding,this.padding,this.padding,this.padding));
		label.setBackground(this.backgroundColor);
		label.setFont(label.getFont().deriveFont((float) this.fontSize));// ugly code to set font size
		label.setForeground(this.textColor);
		return label;
	}
}