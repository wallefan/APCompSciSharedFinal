package park;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import gui.RideSelector;

public class FileSaver implements WindowListener {
	private final RideSelector rideSelector;
	public FileSaver(RideSelector rs) {
		rideSelector=rs;
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}
	
	public void load() {
		try (ZipInputStream zf = new ZipInputStream(new FileInputStream("attractions.zip"))) {
			ZipEntry entry;
			while ((entry = zf.getNextEntry()) != null) {
				if (entry.isDirectory())
					continue;
				String name = entry.getName();
				if (!name.endsWith(".properties"))
					continue;
				Attraction ride = new Attraction(name.substring(0, name.length() - 11)); // 11 is the length of the string ".properties"
				ride.loadFromFile(zf);
				rideSelector.addRide(ride);
				zf.closeEntry();
			}
		} catch (FileNotFoundException e0) {
			System.out.println("Could not locate attractions.zip, loading defaults");
			loadDefaults();
		} catch (IOException e1) {
			throw new IOError(e1);
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		try (ZipOutputStream zf = new ZipOutputStream(new FileOutputStream("attractions.zip"))) {
			for (Attraction ride : rideSelector.attractions) {
				zf.putNextEntry(new ZipEntry(ride.getName() + ".properties"));
				ride.saveToFile(zf);
				zf.closeEntry();
			}
		} catch (IOException e1) {
			throw new IOError(e1);
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}
	
	private void loadDefaults() {
		Attraction wheel = new Attraction("Ferris Wheel");
		rideSelector.addRide(wheel);
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
		Attraction merryGoRound = new Attraction("Merry-go-round");
		rideSelector.addRide(merryGoRound);
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
		Attraction coaster = new Attraction("Roller coaster");
		rideSelector.addRide(coaster);
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
