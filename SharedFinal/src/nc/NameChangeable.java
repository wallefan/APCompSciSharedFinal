package nc;

import java.util.ArrayList;

public abstract class NameChangeable {
	ArrayList<NameChangeListener> listeners = new ArrayList<>();
	private String name;
	
	public void setName(String newName) {
		name=newName;
		for(NameChangeListener l : listeners) {
			l.nameChanged(newName);
		}
	}
	
	public final String getName() {
		return name;
	}
	
	public void addNameChangeListener(NameChangeListener l) {
		listeners.add(l);
	}
	
	public boolean removeNameChangeListener(NameChangeListener l) {
		return listeners.remove(l);
	}

}
