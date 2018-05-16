package gui;

import javax.swing.BoxLayout;

import park.Attraction;

public class RideSelector extends View {
	@Override
	void init() {
		setName("Select Ride");
		body.setLayout(new BoxLayout(body,BoxLayout.Y_AXIS));
	}
	
	public void addRide(Attraction ride) {
		View me = this;
		Button button = new Button(ride.getName(),"") {
			@Override
			void onClick() {
				RideDetails thisRide = new RideDetails(ride);
				thisRide.setPrevView(me);
				MasterWindow.setView(thisRide);
			}
		};
		body.add(button.getButton());
	}
}
