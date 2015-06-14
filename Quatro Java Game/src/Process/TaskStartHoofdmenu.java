package Process;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Business.Speelstuk;
import Presentation.Hoofdmenu;
import Presentation.SpeelBord;
import Presentation.SpelregelForm;
// Walter
public class TaskStartHoofdmenu extends Task implements ActionListener {	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public boolean validate() {
		return true;
	}

	@Override
	public void execute() {
		new Hoofdmenu(this);
	}


}
