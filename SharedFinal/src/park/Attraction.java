package park;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.swing.text.html.parser.Entity;

public class Attraction {
	// private final Properties properties;
	private final HashMap<AttributeTypes, Object> attributes = new HashMap<AttributeTypes, Object>();;



	// private final Map<AttributeTypes, Object> attributes;
	// public final int maxRiders;
	// public final double rideDuration;
	// public final int maxConcurrentRides;
	// public final double openTime;
	// public final double closeTime;
	// public final double minRiderHeight;
	// public final double maxRiderWeight;
	// public final double thrillRating;
	public final String name;
	private double ridesToday = 0;

	public Attraction(String name) {
		this.name = name;
		for (AttributeTypes attr : AttributeTypes.values()) {
			attributes.put(attr, attr.defaultVal);
		}
	}

	public Attraction(String name, File file) throws IOException {
		this.name = name;
		Properties properties = new Properties();
		try (FileInputStream fin = new FileInputStream(file)) {
			properties.load(fin);
		}
		for (Entry<Object, Object> entry : properties.entrySet()) {
			attributes.put((AttributeTypes) entry.getKey(), entry.getValue());
		}
	}

	public String getName() {
		return this.name;
	}

	public HashMap<AttributeTypes, Object> getAttributes() {
		return attributes;
	}

	// public Map<AttributeTypes, Object> getAttributes() {
	// HashMap<AttributeTypes, Object> m = new HashMap<AttributeTypes, Object>();
	// attributes.forEach((AttributeTypes key, Object value) -> {
	// if (key instanceof String)
	// m.put(AttributeTypes.valueOf((String) key), value);
	// else if (key instanceof AttributeTypes)
	// m.put((AttributeTypes) key, value);
	// else
	// throw new Error("Property keys must be either strings or instances of
	// AttributeTypes");
	// });
	// return m;
	// }

	void setAttribute(AttributeTypes attribute, Object newValue) {
		attributes.put(attribute, newValue);
	}

	void saveToFile(File f) throws IOException {
		Properties p = new Properties();
		// you ever just been reading the docs and decided you really, really hate Java?

		// "Because Properties inherits from Hashtable, the put and putAll methods can
		// be
		// applied to a Properties object. Their use is strongly discouraged as they
		// allow the caller to insert entries whose keys or values are not Strings. The
		// setProperty method should be used instead. If the store or save method is
		// called on a "compromised" Properties object that contains a non-String key or
		// value, the call will fail." WHY ISN'T IT A HashMap<String, String> THEN!?
		// It would be so easy to avoid this whole problem! Programming languages don't
		// NEED bureaucracy!
		
		// Oh well...

		attributes.forEach((AttributeTypes k, Object v) -> p.setProperty(k.toString(), v.toString()));
		try (FileOutputStream fout = new FileOutputStream(f)) {
			p.store(fout, name);
		}
	}

	void loadFromFile(File f) throws IOException {
		Properties p = new Properties();
		try (FileInputStream fin = new FileInputStream(f)) {
			p.load(fin);
		}
		p.forEach((Object k, Object v) -> {
			if (k instanceof AttributeTypes)
				attributes.put((AttributeTypes) k, v);
			else if (k instanceof String)
				attributes.put(AttributeTypes.valueOf((String) k), v);
			else
				throw new Error("Key types must be either AttributeTypes or Strings representing them");
		});

	}

}
