package gui;

import java.util.HashMap;

import park.Attraction;

public class GUITester {
	RideSelector rideSelector;
	public static void main(String[] args) {
		MasterWindow.initGUI(new RideSelector());
	}
}
