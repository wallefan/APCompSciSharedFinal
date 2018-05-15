package GUI;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class View {// TODO getters and setters I guess
	/**
	 * main panel containing entire view
	 */
	private JPanel view;
	/**
	 * header panel, used for title
	 */
	JPanel header;
	/**
	 * primary panel for content, put everything in here.
	 */
	JPanel content;
	JPanel footer;
	private BorderLayout layout;
	String name;
	JLabel title;

	View prev;
	
	View() {
		// setup view
		view = new JPanel();
		layout = new BorderLayout();
		view.setLayout(layout);
		// setup other panels
		header = new JPanel();
		title = new JLabel();
		title.setBackground(Theme.TITLE.backgroundColor);
		title.setFont(title.getFont().deriveFont((float) Theme.TITLE.fontSize));// ugly code to set font size
		title.setForeground(Theme.TITLE.textColor);
		header.add(title);
		footer = new JPanel();
		content = new JPanel();
		// put other panels in view
		view.add(header, BorderLayout.PAGE_START);// put header at the top of view
		view.add(content, BorderLayout.CENTER);// put content in the middle of view
		view.add(footer,BorderLayout.PAGE_END);// put footer at bottom of view
		init();
	}

	public void setName(String name) {
		this.name = name;
		title.setText(name);
	}
	
	public void setPrevView(View target) {
		Button goBack = new Button("Back","",footer) {
			@Override
			void onClick() {
				MasterWindow.setView(target);
			}
		};
	}

	/**
	 * Method executed once when the view is first constructed
	 */
	abstract void init();


	void show() {
		view.setVisible(true);
	}


	void hide() {
		view.setVisible(false);
	}

	/**
	 * @return - JPanel encompassing entire view
	 */
	public JPanel getView() {
		return view;
	}
}
