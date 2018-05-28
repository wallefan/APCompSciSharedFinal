package gui;

import java.util.HashMap;

import park.Attraction;
import park.Attractions;

public class GUITester {
	public static void main(String[] args) {
		MasterWindow.initGUI();
		RideSelector r = new RideSelector();
		for(Attraction a:Attractions.attractions) {
			r.addRide(a);
		}
		MasterWindow.setView(r);
	}
}
