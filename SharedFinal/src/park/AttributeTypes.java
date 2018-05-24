package park;

public enum AttributeTypes {
	MAXIMUM_RIDERS_PER_CYCLE(0), CYCLE_DURATION(0.0), CONCECUTIVE_CYCLES(0), RIDERS_PER_HOUR(0), CYCLES_PER_HOUR(0), OPENING_TIME(0.0), CLOSING_TIME(0.0), MIN_RIDER_HEIGHT(0), MAX_RIDER_HEIGHT(0), MAX_RIDER_WEIGHT(0), THRILL_RATING(0);
	// Ferris Wheel & Merry Go Round: RADIUS(0.0)
	// Roller Coaster: LENGTH(0.0), G_FORCE(0.0)
	public Object defaultVal;

	AttributeTypes(Object defaultVal) {
		this.defaultVal = defaultVal;
	}
}
