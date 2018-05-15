package GUI;

import java.awt.Color;

public enum Theme{
	TITLE(0x444444,0xDDDDDD,20),
	BODY(0x222222,0xFFFFFF,12),
	BUTTONS(0x000000,0xCCCCCC,12);
	Color backgroundColor;
	Color textColor;
	int fontSize;
	/**
	 * @param textColor
	 * @param backgroundColor
	 * @param fontSize
	 */
	Theme(Color textColor,Color backgroundColor,int fontSize){
		this.textColor=textColor;
		this.backgroundColor=backgroundColor;
		this.fontSize=fontSize;
	}
	/**
	 * @param textColorHex - text color as hex int, write as 0x00FF00
	 * @param backgroundColorHex - background color as hex int, write as 0x00FF00
	 * @param fontsize
	 */
	Theme(int textColorHex,int backgroundColorHex,int fontsize){
		this.textColor = new Color(textColorHex);
		this.backgroundColor = new Color(backgroundColorHex);
		this.fontSize = fontsize;
	}
}