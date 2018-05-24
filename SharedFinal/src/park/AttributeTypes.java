package park;

public enum AttributeTypes {
	NUMBER_OF_RIDERS(0), TICKET_PRICE(0.0);
	Object defaultVal;

	AttributeTypes(Object defaultVal) {
		this.defaultVal = defaultVal;
	}
}
