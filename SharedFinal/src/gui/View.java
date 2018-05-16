package gui;

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
	protected JPanel header;
	
	/**
	 * primary panel for content, put everything in here.
	 */
	protected JPanel content;
	protected JPanel footer;
	protected JLabel title;
	private BorderLayout layout;
	private String name;

	View prev;
	
	View() {
		// setup view
		view = new JPanel();
		layout = new BorderLayout();
		view.setLayout(layout);
		// setup other panels
		header = new JPanel();
		title = Theme.TITLE.makeLabel();
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

	/**
	 * @return - JPanel encompassing entire view
	 */
	public JPanel getView() {
		return view;
	}
}