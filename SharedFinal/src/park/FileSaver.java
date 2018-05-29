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

public class FileSaver implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {
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
				Attractions.attractions.add(ride);
				zf.closeEntry();
			}
		} catch (FileNotFoundException e0) {
			System.out.println("Could not locate attractions.zip, loading defaults");
			Attractions.loadDefaults();
		} catch (IOException e1) {
			throw new IOError(e1);
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		try (ZipOutputStream zf = new ZipOutputStream(new FileOutputStream("attractions.zip"))) {
			for (Attraction ride : Attractions.attractions) {
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

}
