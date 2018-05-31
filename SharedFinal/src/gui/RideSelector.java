package gui;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.BoxLayout;

import park.Attraction;

public class RideSelector implements GuiPanel{
	View view;
	public ArrayList<Attraction> attractions = new ArrayList<Attraction>();
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
		attractions.add(ride);
		Button button = new Button(ride.getName(),"") {
			@Override
			void onClick() {
				// this is in here for ease of testing, I'll move it back out later.
				RideDetails rd = new RideDetails(ride);
				rd.getView().setPrevView(view);
				MasterWindow.setView(rd);
			}
		};
		button.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);
		view.body.add(button.getButton());
		ride.addNameChangeListener(button.getButton()::setText);
	}
}
