package Process;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Presentation.GameScreen;
// Gerben
public class TaskSpelVerlaten extends Task implements ActionListener {

	public static GameScreen gameScreen;
	
	public TaskSpelVerlaten(GameScreen gs) {
		gameScreen = gs;
	}
	
	public TaskSpelVerlaten() {
		
	}
	
	@Override
	public boolean validate() {
		return true;
	}

	@Override
	public void execute() {
		gameScreen.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.run();
	}

}
