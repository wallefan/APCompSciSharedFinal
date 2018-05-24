package gui;

import java.util.HashMap;

import park.Attraction;

public class GUITester {
	public static void main(String[] args) {
		Attraction a = new Attraction("A");
		MasterWindow.initGUI();
		RideSelector r = new RideSelector();
		r.addRide(a);
		MasterWindow.setView(r);
	}
}
