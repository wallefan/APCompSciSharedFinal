package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.Map.Entry;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.DocumentFilter;

import gui.theme.Themes;
import park.Attraction;
import park.AttributeTypes;

public class RideDetails implements GuiPanel {
	private NameChangeableView view;
	Attraction ride;

	public RideDetails(Attraction ride) {
		view = new NameChangeableView();
		this.ride = ride;
		view.setName(ride.getName());
		System.out.println("done setting name");
		ride.addNameChangeListener(view::setName);
		view.addNameChangeListener(ride::setName); // ordinarily configuring two objects to listen to each other like
													// this would mean infinite recursion but NameChangeableView has
													// measures to prevent that
		JPanel attrs = new JPanel();
		GridLayout layout = new GridLayout(ride.getAttributes().size(), 2);
		attrs.setLayout(layout);
		layout.setHgap(5);
		Themes.body.style(attrs);
		view.body.add(attrs);
		for (Entry<AttributeTypes, Object> attr : ride.getAttributes().entrySet()) {
			String name = "";
			for (String word : attr.getKey().name().split("_")) {
				name += word.substring(0, 1);
				if (word.length() > 1) {
					name += word.substring(1).toLowerCase();
				}
				name += " ";
			}
			JLabel keylabel = new JLabel(name);
			keylabel.setAlignmentX(Component.LEFT_ALIGNMENT);
			attrs.add(keylabel);
			// JLabel vallabel = new JLabel(attr.getValue().toString());
			// attrs.add(vallabel);
			if (attr.getKey().defaultVal instanceof Number) {
				JTextField keyField = new JTextField();
				Themes.input.style(keyField);
				keyField.setText(attr.getValue().toString());
				keyField.getDocument().addDocumentListener(new DocumentListener() {
					Class<? extends Object> numtype = attr.getKey().defaultVal.getClass();

					@Override
					public void removeUpdate(DocumentEvent e) {
						edit();
					}

					@Override
					public void insertUpdate(DocumentEvent e) {
						edit();
					}

					@Override
					public void changedUpdate(DocumentEvent e) {
						edit();
					}

					public void edit() {
						try {
							if (numtype == Integer.class) {
								attr.setValue(Integer.parseInt(keyField.getText()));
							} else if (numtype == Double.class) {
								attr.setValue(Double.parseDouble(keyField.getText()));
							}
							Themes.input.style(keyField);
						} catch (NumberFormatException e) {
							keyField.setForeground(Color.red);
						}
					}
				});
				attrs.add(keyField);
			} else {
				JLabel vallabel = new JLabel(attr.getValue().toString());
				attrs.add(vallabel);
			}
			Themes.body.style(keylabel);
		}
	}

	@Override
	public View getView() {
		return view;
	}
}