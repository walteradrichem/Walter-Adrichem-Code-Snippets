package Presentation;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Process.TaskSpelVerlaten;
import Process.TaskStartSpel;

// Walter
public class WinForm extends JFrame {
	int option;
	
	public void compilePopup(String title, String message, String button0) {
		Object[] buttons = { button0 };
		option = JOptionPane.showOptionDialog(this, message, title,
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				buttons,
				buttons[0]); 
	}
	
	public WinForm(String player) {
		compilePopup(
				// Titel
						"Game Over",
						// Bericht
						"Gefeliciteerd " + player
								+ ", u heeft het spel gewonnen!\n",
						// Button1
						"Spel Verlaten");
		TaskStartSpel herstart = new TaskStartSpel();
	
	}

	
}
