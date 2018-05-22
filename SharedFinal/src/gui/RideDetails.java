package gui;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.Map.Entry;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.theme.Themes;
import park.Attraction;
import park.Attraction.AttributeTypes;

public class RideDetails {
	View view;
	Attraction ride;

	public RideDetails(Attraction ride) {
		view = new View();
		this.ride = ride;
		view.setName(ride.getName());
		JPanel attrs = new JPanel();
		GridLayout layout = new GridLayout(ride.getAttributes().size(), 2);
		attrs.setLayout(layout);
		layout.setHgap(5);
		Themes.body.style(attrs);
		view.body.add(attrs);
		for (Entry<AttributeTypes, Object> attr : ride.getAttributes().entrySet()) {
			JLabel keylabel = new JLabel(attr.getKey().name().toLowerCase().replace("_", " "));
			keylabel.setAlignmentX(Component.LEFT_ALIGNMENT);
			attrs.add(keylabel);
			JLabel vallabel = new JLabel(attr.getValue().toString());
			attrs.add(vallabel);
			Themes.body.style(keylabel, vallabel);
		}
	}
}