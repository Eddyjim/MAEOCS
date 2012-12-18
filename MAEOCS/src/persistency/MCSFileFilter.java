package persistency;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class MCSFileFilter extends FileFilter{

	@Override
	public boolean accept(File f) {
		return f.isDirectory() || f.getName().toLowerCase().endsWith(".mcs");
	}

	@Override
	public String getDescription() {
		return "MAEOCS files";
	}

}
