package Process;

// Frank

import Business.Speelstukken;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TaskSpelOpslaan implements ActionListener {
	public static String fileName = "";
	private Speelstukken stukken;
	
	public TaskSpelOpslaan(Speelstukken stukken) {
		this.stukken = stukken;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		save(this.stukken);
		
	}

	public void save(Speelstukken stukken) {
		try {
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(chooser.getCurrentDirectory());
			chooser.setDialogTitle("Save the file");
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"DAT Files", "dat");

			chooser.setFileFilter(filter);

			int returnVal = chooser.showSaveDialog(chooser);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File f = chooser.getSelectedFile();
				fileName = f.getAbsolutePath();
				ObjectOutputStream os = new ObjectOutputStream(
						new FileOutputStream(fileName));
				os.writeObject(stukken);
				os.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println("Done");
	}
	
}
