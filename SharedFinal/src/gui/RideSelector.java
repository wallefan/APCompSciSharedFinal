package gui;

import java.awt.Component;

import javax.swing.BoxLayout;

import park.Attraction;

public class RideSelector implements GuiPanel{
	View view;
	public RideSelector(){
		view = new View();
		view.setName("Select Ride");
		view.body.setLayout(new BoxLayout(view.body,BoxLayout.Y_AXIS));
	}
	
	@Override
	public View getView() {
		return view;
	}
	
	public void addRide(Attraction ride) {
		RideDetails rd = new RideDetails(ride);
		Button button = new Button(ride.getName(),"") {
			@Override
			void onClick() {
				MasterWindow.setView(rd);
			}
		};
		button.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);
		view.body.add(button.getButton());
	}

	
}
