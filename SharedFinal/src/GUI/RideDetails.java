package GUI;

import park.Attraction;

public class RideDetails extends View {
	@Override
	void init() {
		
	}
	
	public RideDetails(Attraction target) {
		
	}
	
	public void setRide(Attraction ride) {
		setName(ride.getName());
		MasterWindow.mainWindow.pack();
	}
}
