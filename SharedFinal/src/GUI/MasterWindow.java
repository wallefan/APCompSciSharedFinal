package GUI;

import javax.swing.JDialog;

public class MasterWindow {
	static JDialog mainWindow;
	static View view;
	public static void initGUI() {
		//setup main window
		mainWindow = new JDialog();
		mainWindow.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		mainWindow.pack();
		mainWindow.setVisible(true);
	}
	public static void setView(View newView) {//make this better
		if(view != null) {
			view.hide();
		}
		if(newView.getView().getParent()==null) {
			mainWindow.add(newView.getView());
		}
		newView.show();
		view = newView;
		mainWindow.pack();
	}
}