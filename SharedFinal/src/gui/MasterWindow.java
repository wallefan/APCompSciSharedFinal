package gui;

import javax.swing.JDialog;

import park.FileSaver;

public class MasterWindow {
	static JDialog mainWindow;
	static View view;
	public static void initGUI(RideSelector rideSelector) {
		//setup main window
		mainWindow = new JDialog();
		mainWindow.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		FileSaver fs = new FileSaver(rideSelector);
		mainWindow.addWindowListener(fs);
		fs.load();
		mainWindow.pack();
		mainWindow.setVisible(true);
		setView(rideSelector);
	}
	public static void setView(View newView) {//make this better
		if(view != null) {
			mainWindow.remove(view.getView());
		}
		view=newView;
		mainWindow.add(newView.getView());
		mainWindow.pack();
	}
	public static void setView(GuiPanel newView) {
		setView(newView.getView());
	}
}