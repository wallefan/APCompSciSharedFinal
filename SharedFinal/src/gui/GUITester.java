package gui;

import java.util.HashMap;

import park.Attraction;

public class GUITester {
	public static void main(String[] args) {
		Attraction test1 = new Attraction("Attraction 1", new HashMap<String, Object>());
		Attraction test2 = new Attraction("Attraction 2", new HashMap<String, Object>());
		Attraction test3 = new Attraction("Attraction 3", new HashMap<String, Object>());
		MasterWindow.initGUI();
		RideSelector rideSelector = new RideSelector();
		rideSelector.addRide(test1);
		rideSelector.addRide(test2);
		rideSelector.addRide(test3);
		MasterWindow.setView(rideSelector);
	}
}
