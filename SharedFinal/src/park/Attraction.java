package park;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;

public class Attraction {
	private final Map<String, Object> attributes;
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
	 public Attraction(String name, Map<String, Object> attributes){
		this.name=name;
		this.attributes = Collections.unmodifiableMap(attributes);
	 }
	 public String getName() {
		 return this.name;
	 }
	 
	 public Map<String, Object> getAttributes() {
		 return attributes;
	 }
}
