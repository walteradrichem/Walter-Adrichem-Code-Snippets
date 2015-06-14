package Process;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Presentation.PauzeerForm;
import Presentation.SpelregelForm;
// Walter
public class TaskPauzeerSpel extends Task implements ActionListener {

	@Override
	public boolean validate() {
		return true;
	}

	@Override
	public void execute() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		new PauzeerForm();
	}
	

}
