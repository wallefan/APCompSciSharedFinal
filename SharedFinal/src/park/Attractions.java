package park;

import java.util.ArrayList;

public class Attractions {
	static ArrayList<Attraction> attractions = new ArrayList<Attraction>();
	static Attraction wheel = new Attraction("Wheely");
	static {
		attractions.add(wheel);
		wheel.setAttribute(AttributeTypes.NUMBER_OF_RIDERS,100);
		wheel.setAttribute(AttributeTypes.TICKET_PRICE,50.00);
	}
}
