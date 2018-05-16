package gui;

import javax.swing.JLabel;

import park.Attraction;

public class RideDetails extends View {
	Attraction ride;
	
	public RideDetails(Attraction ride) {
		this.ride=ride;
		setName(ride.getName());
		ride.getAttributes().forEach((String attribute, Object value) -> {
			getView().add(new JLabel(attribute + ": "+value));
		});
	}

	@Override
	void init() {
		// don't need to do anything here
	}
}
