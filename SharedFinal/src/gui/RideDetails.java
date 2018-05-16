package gui;

import park.Attraction;

public class RideDetails extends View {
	Attraction ride;
	@Override
	void init() {
		
	}
	
	public RideDetails(Attraction ride) {
		this.ride=ride;
		setName(ride.getName());
	}
}
