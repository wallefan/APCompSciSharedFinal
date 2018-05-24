package park;

import java.util.ArrayList;

public class Attractions {
	static ArrayList<Attraction> attractions = new ArrayList<Attraction>();
	static Attraction wheel = new Attraction("Ferris Wheel");
	static Attraction merryGoRound = new Attraction("Merry Go Round");
	static Attraction coaster = new Attraction("Roller Coaster");
	static {
		attractions.add(wheel);
		wheel.setAttribute(AttributeTypes.OPENING_TIME, 10.0);
		wheel.setAttribute(AttributeTypes.CLOSING_TIME, 18.0);
		wheel.setAttribute(AttributeTypes.THRILL_RATING, 1);
		wheel.setAttribute(AttributeTypes.CONCECUTIVE_CYCLES, 8);
		wheel.setAttribute(AttributeTypes.CYCLE_DURATION, 5.0);
		wheel.setAttribute(AttributeTypes.MIN_RIDER_HEIGHT, 60);
		wheel.setAttribute(AttributeTypes.MAX_RIDER_HEIGHT, 84);
		wheel.setAttribute(AttributeTypes.MAX_RIDER_WEIGHT, 400);
		wheel.setAttribute(AttributeTypes.MAXIMUM_RIDERS_PER_CYCLE, 4);
		wheel.setAttribute(AttributeTypes.RIDERS_PER_HOUR, 160);
		wheel.setAttribute(AttributeTypes.CYCLES_PER_HOUR, 10);
		attractions.add(merryGoRound);
		merryGoRound.setAttribute(AttributeTypes.OPENING_TIME, 10.0);
		merryGoRound.setAttribute(AttributeTypes.CLOSING_TIME, 18.0);
		merryGoRound.setAttribute(AttributeTypes.THRILL_RATING, 1);
		merryGoRound.setAttribute(AttributeTypes.CONCECUTIVE_CYCLES, 8);
		merryGoRound.setAttribute(AttributeTypes.CYCLE_DURATION, 5.0);
		merryGoRound.setAttribute(AttributeTypes.MIN_RIDER_HEIGHT, 60);
		merryGoRound.setAttribute(AttributeTypes.MAX_RIDER_HEIGHT, 84);
		merryGoRound.setAttribute(AttributeTypes.MAX_RIDER_WEIGHT, 400);
		merryGoRound.setAttribute(AttributeTypes.MAXIMUM_RIDERS_PER_CYCLE, 4);
		merryGoRound.setAttribute(AttributeTypes.RIDERS_PER_HOUR, 160);
		merryGoRound.setAttribute(AttributeTypes.CYCLES_PER_HOUR, 10);
		attractions.add(coaster);
		coaster.setAttribute(AttributeTypes.OPENING_TIME, 10.0);
		coaster.setAttribute(AttributeTypes.CLOSING_TIME, 18.0);
		coaster.setAttribute(AttributeTypes.THRILL_RATING, 5);
		coaster.setAttribute(AttributeTypes.CONCECUTIVE_CYCLES, 2);
		coaster.setAttribute(AttributeTypes.CYCLE_DURATION, 2.0);
		coaster.setAttribute(AttributeTypes.MIN_RIDER_HEIGHT, 60);
		coaster.setAttribute(AttributeTypes.MAX_RIDER_HEIGHT, 84);
		coaster.setAttribute(AttributeTypes.MAX_RIDER_WEIGHT, 400);
		coaster.setAttribute(AttributeTypes.MAXIMUM_RIDERS_PER_CYCLE, 18);
		coaster.setAttribute(AttributeTypes.RIDERS_PER_HOUR, 280);
		coaster.setAttribute(AttributeTypes.CYCLES_PER_HOUR, 20);
	}
}
