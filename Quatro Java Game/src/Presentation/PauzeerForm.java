package Presentation;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
// Walter

public class PauzeerForm extends JFrame {
	int option;
	public void compilePopup(String title, String message, String button1) {
		Object[] buttons = { button1 };
		option = JOptionPane.showOptionDialog(this, message, title,
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,  // do not use a custom Icon
				buttons, // the titles of buttons
				buttons[0]); // default button title
	}
	
	public PauzeerForm() {
		compilePopup(
				// Titel
						"Spel Gepauzeerd",
						// Bericht
						"Het spel is gepauzeerd!\n",
						// Button
						"Spel Hervatten");
	
	}

	
}
