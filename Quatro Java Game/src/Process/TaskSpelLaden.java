package Process;

//Collin

import Business.Speelstuk;
import Business.Speelstukken;
import Presentation.GameScreen;
import Presentation.SpeelBord;
import Presentation.SpeelStukkenContainer;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TaskSpelLaden implements ActionListener {	
	
	public SpeelStukkenContainer container;
	private SpeelBord speelbord;
	private GameScreen gs;
	private MouseListener task;

	public TaskSpelLaden(){
		
	}
	
	public TaskSpelLaden(SpeelStukkenContainer container, SpeelBord speelbord, GameScreen gs, MouseListener task){
		this.container = container;
		this.speelbord = speelbord;
		this.gs = gs;
		this.task = task;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.load();
	}
	
	public void load() {
		try {
			JFileChooser chooser = new JFileChooser();
		
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"DAT Files", "dat");
			chooser.setFileFilter(filter);
			
			int returnVal = chooser.showOpenDialog(chooser);
			
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				ObjectInputStream is = new ObjectInputStream(
						new FileInputStream(TaskSpelOpslaan.fileName));
				Speelstukken s = (Speelstukken) is.readObject();
				
				this.container.emptyContainer();
				this.speelbord.clearVeld();
				this.container.setVisible(false);
				
				SpeelStukkenContainer newContainer = new SpeelStukkenContainer(this.gs, this.task, s, this.speelbord);
				this.gs.add(newContainer, BorderLayout.EAST);
						
				newContainer.repaint();			
				is.close();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	

}
