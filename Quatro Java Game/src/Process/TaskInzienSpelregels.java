package Process;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Presentation.SpelregelForm;
// Frank
public class TaskInzienSpelregels extends Task implements ActionListener {

	@Override
	public boolean validate() {
		return true;
	}

	@Override
	public void execute() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		new SpelregelForm();
	}
	
	public void spelRegelPopup(){
		new SpelregelForm();
	}

}
