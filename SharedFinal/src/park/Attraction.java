package park;

public class Attraction {
	 private int maxRiders;
	 private double rideDuration;
	 private int maxConcurrentRides;
	 private double openTime;
	 private double closeTime;
	 private double minRiderHeight;
	 private double maxRiderWeight;
	 private double thrillRating;
	 private String name;
	 public Attraction(String name){
		this.name=name; 
	 }
	 public String getName() {
		 return this.name;
	 }
}
