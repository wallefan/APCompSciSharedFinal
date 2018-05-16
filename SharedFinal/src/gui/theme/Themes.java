package gui.theme;

import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalBorders;

public class Themes {
	public static Theme title = new Theme() {
		@Override
		void jank() {
			fontSize=20;
			int padding = 10;
			border=new EmptyBorder(padding,padding,padding,padding);
		}
	};
	public static Theme button = new Theme() {
		@Override
		void jank() {
			opaque=true;
			border = new MetalBorders.ButtonBorder();
			
		}
	};
	public static Theme body = new Theme() {
		@Override
		void jank() {
			
		}
	};
}
