package park;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Attraction {
	private final Properties properties;
	
	public enum AttributeTypes{
		NUMBER_OF_RIDERS,
		TICKET_PRICE;
	}
	
	//private final Map<AttributeTypes, Object> attributes;
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
	 public Attraction(String name, File attributes) throws IOException {
		this.name=name;
		properties = new Properties();
		try(FileInputStream fin = new FileInputStream(attributes)) {
			properties.load(fin);
		}
	 }
	 public String getName() {
		 return this.name;
	 }
	 
	 public Map<AttributeTypes, Object> getAttributes() {
		 HashMap<AttributeTypes, Object> m = new HashMap<AttributeTypes, Object>();
		 properties.forEach((Object key, Object value) -> {
			 if(key instanceof String)
				 m.put(AttributeTypes.valueOf((String)key), value);
			 else if(key instanceof AttributeTypes)
				 m.put((AttributeTypes) key, value);
			 else throw new Error("Property keys must be either strings or instances of AttributeTypes");
		 });
		 return m;
	 }
	void setAttribute(AttributeTypes attribute, Object newValue) {
		 properties.put(attribute, newValue);
	 }
	
	void saveToFile(File f) throws IOException {
		try(FileOutputStream fout = new FileOutputStream(f)) {
			properties.store(fout, name);
		}
	}
	 
	 
}
