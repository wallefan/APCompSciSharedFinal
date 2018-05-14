package GUI;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class MasterWindow {
	public static void main(String arg[]) {
		JDialog mainWindow = new JDialog();
		JPanel panel = new JPanel();
		mainWindow.add(panel);
		Button temp = new Button("click me","",Theme.BODY,panel) {
			@Override
			void onClick() {
				System.out.println("hello world");
			}
		};
		mainWindow.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		mainWindow.pack();
		mainWindow.setVisible(true);
	}
}
