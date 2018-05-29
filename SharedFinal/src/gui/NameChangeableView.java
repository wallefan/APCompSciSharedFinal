package gui;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JTextField;

import gui.theme.Themes;
import nc.NameChangeListener;

/**
 * A subclass of View where the view title is a text field rather than a label,
 * so it can be edited by the user.
 * 
 * @author 540725
 *
 */
public class NameChangeableView extends View {
	boolean changingName; // this is to avoid infinite recursion (since the setName() method of this, and
							// the ride this represents, listen to (and are called by) each other)
	private JTextField titleField;
	// I would inherit NameChangeable but ... single inheritance... *sigh*
	private ArrayList<NameChangeListener> listeners = new ArrayList<>();

	public NameChangeableView() {
		titleField = new JTextField();
		Themes.title.style(titleField);
		header.add(titleField);
		titleField.addFocusListener(new FocusListener() {
			String lastName;
			@Override
			public void focusGained(FocusEvent e) {
				lastName = titleField.getText();
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(titleField.getText()!=lastName)
					setName(titleField.getText());
			}
			
		});
	}

	@Override
	public void setName(String name) {
		titleField.setText(name);
		if (changingName)
			return;
		synchronized (this) {
			changingName = true;
			for (NameChangeListener l : listeners)
				l.nameChanged(name);
			changingName = false;
		}
	}
	
	
	public void addNameChangeListener(NameChangeListener l) {
		listeners.add(l);
	}
	
	public boolean removeNameChangeListener(NameChangeListener l) {
		return listeners.remove(l);
	}

}
