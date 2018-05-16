package gui;

import park.Attraction;

public class RideSelector extends View {
	@Override
	void init() {
		setName("Ride Selection");
		
	}
	
	public void addRide(Attraction ride) {
		View me = this;
		Button button = new Button(ride.getName(),"",this.content) {
			@Override
			void onClick() {
				RideDetails thisRide = new RideDetails(ride);
				thisRide.setPrevView(me);
				MasterWindow.setView(thisRide);
			}
		};
	}
}
