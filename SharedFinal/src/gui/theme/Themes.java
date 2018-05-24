package gui.theme;

import java.awt.Color;

import javax.swing.plaf.metal.MetalBorders;

public class Themes {
	public static Theme title = new Theme() {
		@Override
		void jank() {
			fontSize=20;
			setPadding(10);
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
	public static Theme input = new Theme(body) {
		@Override
		void jank() {
			border=new MetalBorders.TextFieldBorder();
		}
	};
	public static Theme badInput = new Theme(input) {

		@Override
		void jank() {
			backgroundColor=Color.red;
		}
		
	};
}
