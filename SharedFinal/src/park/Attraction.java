package park;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;

public class Attraction {
	public enum AttributeTypes{
		NUMBER_OF_RIDERS,
		TICKET_PRICE;
	}
	private final Map<AttributeTypes, Object> attributes;
	 //public final int maxRiders;
	 //public final double rideDuration;
	 //public final int maxConcurrentRides;
	 //public final double openTime;
	 //public final double closeTime;
	 //public final double minRiderHeight;
	 //public final double maxRiderWeight;
	 //public final double thrillRating;
	 public final String name;
	 private double ridesToday = 0;
	 public Attraction(String name, Map<AttributeTypes, Object> attributes){
		this.name=name;
		this.attributes = Collections.unmodifiableMap(attributes);
	 }
	 public String getName() {
		 return this.name;
	 }
	 
	 public Map<AttributeTypes, Object> getAttributes() {
		 return attributes;
	 }
}
