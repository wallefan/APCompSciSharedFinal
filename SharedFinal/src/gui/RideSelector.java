package gui;

import java.awt.Component;

import javax.swing.BoxLayout;

import park.Attraction;

public class RideSelector extends View {
	@Override
	void init() {
		setName("Select Ride");
		body.setLayout(new BoxLayout(body,BoxLayout.Y_AXIS));
	}
	
	public void addRide(Attraction ride) {
		RideDetails detailsPane = new RideDetails(ride);
		Button button = new Button(ride.getName(),"") {
			@Override
			void onClick() {
				switchView(detailsPane);
			}
		};
		button.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);
		body.add(button.getButton());
	}
}
