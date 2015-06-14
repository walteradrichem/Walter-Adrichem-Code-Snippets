package Process;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Business.Speelstukken;
import Business.Speler;
import Presentation.GameScreen;
import Presentation.Hoofdmenu;
import Presentation.SpelregelForm;
// Collin
public class TaskStartSpel extends Task implements ActionListener {

	
	@Override
	public boolean validate() {
		return true;
	}

	@Override
	public void execute() {
		
	}
	
	@Override

	public void actionPerformed(ActionEvent e) {
		new GameScreen();
	
	}




}
