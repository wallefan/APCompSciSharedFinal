package park;

import java.util.ArrayList;

public class Attractions {
	static ArrayList<Attraction> attractions = new ArrayList<Attraction>();
	static Attraction wheel = new Attraction("FerrisWheel");
	static {
		attractions.add(wheel);
		wheel.setAttribute(AttributeTypes.CLOSING_TIME, 10.0);
	}
}
