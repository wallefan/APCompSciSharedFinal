package gui.theme;

import java.awt.Color;

public class Themes {
	public static Theme title = new Theme() {
		@Override
		void jank() {
			backgroundColor=Color.RED;
		}
	};
	public static Theme button = new Theme() {
		@Override
		void jank() {
			opaque=true;
			backgroundColor=Color.MAGENTA;
		}
	};
}
