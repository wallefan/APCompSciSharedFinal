package gui;

import java.util.HashMap;

import park.Attraction;

public class GUITester {
	public static void main(String[] args) {
		HashMap<String, Object> testAttributeSet = new HashMap<>();
		testAttributeSet.put("Foo", 1);
		testAttributeSet.put("Bar", "Baz");
		Attraction test1 = new Attraction("Attraction 1", testAttributeSet);
		Attraction test2 = new Attraction("Attraction 2", testAttributeSet);
		Attraction test3 = new Attraction("Attraction 3", testAttributeSet);
		System.out.println(test1.getAttributes());
		MasterWindow.initGUI();
		RideSelector rideSelector = new RideSelector();
		rideSelector.addRide(test1);
		rideSelector.addRide(test2);
		rideSelector.addRide(test3);
		MasterWindow.setView(rideSelector);
	}
}
