package gui;

import java.awt.Component;

import javax.swing.BoxLayout;

import park.Attraction;

public class RideSelector{
	View view;
	public RideSelector(){
		view = new View();
		view.setName("Select Ride");
		view.body.setLayout(new BoxLayout(view.body,BoxLayout.Y_AXIS));
	}
	
	public void addRide(Attraction ride) {
		Button button = new Button(ride.getName(),"") {
			@Override
			void onClick() {
				MasterWindow.setView(RideSelector.this.view);
			}
		};
		button.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);
		view.body.add(button.getButton());
	}
}
